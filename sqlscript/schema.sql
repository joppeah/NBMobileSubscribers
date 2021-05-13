# Host: localhost  (Version 5.7.18-log)
# Date: 2021-05-13 14:10:00
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "mobilesubscriber"
#

DROP TABLE IF EXISTS `mobilesubscriber`;
CREATE TABLE `mobilesubscriber` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `msisdn` varchar(11) NOT NULL DEFAULT '' COMMENT 'The mobile number in E164 format, ex. 35699123456',
  `customer_id_owner` int(11) NOT NULL DEFAULT '0' COMMENT 'The ID referencing the owner of this mobile number',
  `customer_id_user` int(11) NOT NULL DEFAULT '0' COMMENT 'ID referencing the user of this mobile number',
  `service_type` enum('MOBILE_PREPAID','MOBILE_POSTPAID') NOT NULL DEFAULT 'MOBILE_POSTPAID' COMMENT 'An enum defining the type of service. Possible values are: - MOBILE_PREPAID,- MOBILE_POSTPAID',
  `service_start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'The time this mobile number was created, encoded in Unix Epoch in Milliseconds.',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `userpassword` varchar(255) NOT NULL DEFAULT '',
  `user_role` enum('ADMIN','USER') NOT NULL DEFAULT 'ADMIN',
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
