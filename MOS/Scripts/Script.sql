CREATE TABLE `staff` (
  `sID` varchar(20) NOT NULL,
  `pin` varchar(4) DEFAULT '0000',
  `isActive` varchar(1) DEFAULT 'n',
  `fName` varchar(30) NOT NULL,
  `lName` varchar(30) NOT NULL,
  `contactNum` varchar(12) DEFAULT NULL,
  `jobID` varchar(4) NOT NULL,   
  PRIMARY KEY (`sID`),
  KEY `staff_FK` (`jobID`),
  CONSTRAINT `staff_FK` FOREIGN KEY (`jobID`) REFERENCES `job` (`jobID`)
) ENGINE=InnoDB 
  DEFAULT CHARSET=utf8 
  COMMENT='Staff information'