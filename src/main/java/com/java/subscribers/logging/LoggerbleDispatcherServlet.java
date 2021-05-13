/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author Junior
 */
public class LoggerbleDispatcherServlet extends DispatcherServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoggerbleDispatcherServlet.class);
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }
        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }
        HandlerExecutionChain handler = getHandler(request);

        try {
            super.doDispatch(request, response);
        } finally {
            log(request, response, handler);
            updateResponse(response);
        }
    }

    private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache, HandlerExecutionChain handler) throws JsonProcessingException {
        LogMessage logmsg = new LogMessage();
        logmsg.setHttpStatus(responseToCache.getStatus());
        logmsg.setHttpMethod(requestToCache.getMethod());
        logmsg.setPath(requestToCache.getRequestURI());
        logmsg.setClientIp(requestToCache.getRemoteAddr());
        logmsg.setJavaMethod(handler.toString());
        logmsg.setResponse(getResponsePayload(responseToCache));
        
        if(!logmsg.getResponse().contains("/DOCTYPE") || !logmsg.getPath().contains("/swagger-ui.html")
                || !logmsg.getPath().contains("/webjars/springfox-swagger-ui"))
        {        
            logger.info("LOGGER: " + ow.writeValueAsString(logmsg)); 
        }      
    }

    private String getResponsePayload(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {

            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                int length = Math.min(buf.length, 5120);
                try {
                    return new String(buf, 0, length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException ex) {
                    // NOOP
                }
            }
        }
        return "[unknown]";
    }

    private void updateResponse(HttpServletResponse response) throws IOException {
        ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        responseWrapper.copyBodyToResponse();
    }
}
