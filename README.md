# NBMobileSubscribers

SQL Scripts
---------------
SQL schema and data scripts are in sqlscripts directory

End Points
---------------
1. Postman test file is in endpoints directory
2. End points are also exposed using Swagger UI. Details are below

Basic Auth (Users are authenticated from the database) 
---------------
username: admin
password: @dmin123
role    : ADMIN

username: user1
password: @user1
role    : APIDEV

username: user2
password: @user2
role    : USER

ADMIN Role can access all urls
APIDEV Role can only access /mobile/** and /swagger-ui.html
USER Role can access only /mobile/** url


Swagger UI Documentation
------------------------

URL: http://localhost:8080/swagger-ui.html

username: admin
password: @dmin123

Select mobile-subscriber-controller and user-controller to view the endpoints for testing


Please Note: This project was created with Apache Netbeans IDE 12.1 

