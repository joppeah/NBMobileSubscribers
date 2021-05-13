CREATE DATABASE `mobilesubscriberdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `mobilesubscriber` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `msisdn` varchar(11) NOT NULL DEFAULT '' COMMENT 'The mobile number in E164 format, ex. 35699123456',
  `customer_id_owner` int(11) NOT NULL DEFAULT '0' COMMENT 'The ID referencing the owner of this mobile number',
  `customer_id_user` int(11) NOT NULL DEFAULT '0' COMMENT 'ID referencing the user of this mobile number',
  `service_type` enum('MOBILE_PREPAID','MOBILE_POSTPAID') NOT NULL DEFAULT 'MOBILE_POSTPAID' COMMENT 'An enum defining the type of service. Possible values are: - MOBILE_PREPAID,- MOBILE_POSTPAID',
  `service_start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'The time this mobile number was created, encoded in Unix Epoch in Milliseconds.',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


