# Host: localhost  (Version 5.7.18-log)
# Date: 2021-05-13 14:10:55
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Data for table "mobilesubscriber"
#

INSERT INTO `mobilesubscriber` (`Id`,`msisdn`,`customer_id_owner`,`customer_id_user`,`service_type`,`service_start_date`) VALUES (1,'35622145446',1,1,'MOBILE_PREPAID','2021-03-24 08:48:06'),(2,'35621145446',2,2,'MOBILE_PREPAID','2021-05-13 13:38:31'),(3,'35620145446',3,3,'MOBILE_POSTPAID','2021-05-13 13:47:18');

#
# Data for table "user"
#

INSERT INTO `user` (`Id`,`username`,`email`,`userpassword`,`user_role`,`datecreated`) VALUES (1,'admin','admin@gmail.com','$2a$10$F5UtR6MoGolu0rvH991gV.lGQtbkeWy6FgbzghClWPanuZj4WvS1K','ADMIN','2021-05-13 10:51:31'),(2,'user','user@gmail.com','$2a$10$Jv78zEMOMJwNMG4C2U0gxOLyNrUOWLy4RCAa6Yue5HxWlXgGFCwJ6','USER','2021-05-13 13:01:25'),(3,'user1','user1@gmail.com','$2a$10$PBil6xq3ol3apvSByXZG8ePwU0uZDbvR0Iw16Vdx7zHrQ/SHJ06qu','USER','2021-05-13 13:01:25'),(4,'user2','user2@gmail.com','$2a$10$ez1RybrDh3bu2.NUbmncNubpKMlCmYqGWT7OGtbzbtPE.q1NliviO','USER','2021-05-13 13:36:19');
