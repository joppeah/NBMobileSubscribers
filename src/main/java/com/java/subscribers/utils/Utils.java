/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Junior
 */
public class Utils {

    public static boolean checkMSISDN(String msisdn) {
        Pattern msisdnpatt = Pattern.compile("^([0-9]{11})$");

        Matcher matcherstr = msisdnpatt.matcher(msisdn);
        return matcherstr.matches();
    }
}
