-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema NaironDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema NaironDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NaironDB` DEFAULT CHARACTER SET utf8 ;
USE `NaironDB` ;

-- -----------------------------------------------------
-- Table `NaironDB`.`NaironUser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`NaironUser` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`NaironUser` (
  `naironUserId` INT(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fullName` VARCHAR(100) NULL,
  `businessSector` VARCHAR(100) NULL,
  `businessName` VARCHAR(100) NULL,
  `gender` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`naironUserId`, `email`),
  INDEX `email_index` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`PublisherWallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`PublisherWallet` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`PublisherWallet` (
  `walletId` INT NOT NULL,
  `walletBalance` DECIMAL NULL,
  PRIMARY KEY (`walletId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`AdvertiserWallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`AdvertiserWallet` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`AdvertiserWallet` (
  `walletId` INT NOT NULL,
  `walletBalance` DOUBLE NULL,
  PRIMARY KEY (`walletId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`Transcation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`Transcation` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`Transcation` (
  `transcationId` INT NOT NULL,
  `transactionType` VARCHAR(45) NOT NULL,
  `transactionDate` VARCHAR(45) NOT NULL,
  `advertiserWalletId` INT NOT NULL,
  `publisherWalletId` INT NOT NULL,
  PRIMARY KEY (`transcationId`),
  INDEX `fk_Transcation_AdvertiserWallet1_idx` (`advertiserWalletId` ASC),
  INDEX `fk_Transcation_PublisherWallet1_idx` (`publisherWalletId` ASC),
  CONSTRAINT `fk_Transcation_AdvertiserWallet1`
    FOREIGN KEY (`advertiserWalletId`)
    REFERENCES `NaironDB`.`AdvertiserWallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transcation_PublisherWallet1`
    FOREIGN KEY (`publisherWalletId`)
    REFERENCES `NaironDB`.`PublisherWallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`Advertiser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`Advertiser` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`Advertiser` (
  `advertiserId` INT NOT NULL AUTO_INCREMENT,
  `advertiserWalletId` INT NOT NULL,
  `naironUserEmail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`advertiserId`, `naironUserEmail`),
  INDEX `fk_AdvertiserUser_Awallet1_idx` (`advertiserWalletId` ASC),
  INDEX `fk_AdvertiserUser_NaironUser1_idx` (`naironUserEmail` ASC),
  CONSTRAINT `fk_AdvertiserUser_Awallet1`
    FOREIGN KEY (`advertiserWalletId`)
    REFERENCES `NaironDB`.`AdvertiserWallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AdvertiserUser_NaironUser1`
    FOREIGN KEY (`naironUserEmail`)
    REFERENCES `NaironDB`.`NaironUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`AdvertBudget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`AdvertBudget` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`AdvertBudget` (
  `advertBudgetId` INT NOT NULL,
  `budgetAmount` DOUBLE NULL,
  `budgetBalance` DOUBLE NULL,
  `budgetPerDay` DOUBLE NULL,
  `standingOrder` VARCHAR(45) NULL,
  PRIMARY KEY (`advertBudgetId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`Advert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`Advert` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`Advert` (
  `advertId` INT NOT NULL,
  `advertiserUser` INT NOT NULL,
  `advertBudgetId` INT NOT NULL,
  `advertDuration` VARCHAR(45) NOT NULL,
  INDEX `fk_Advert_AdvertiserUser1_idx` (`advertiserUser` ASC),
  PRIMARY KEY (`advertId`),
  INDEX `fk_Advert_AdvertBudget1_idx` (`advertBudgetId` ASC),
  CONSTRAINT `fk_Advert_AdvertiserUser1`
    FOREIGN KEY (`advertiserUser`)
    REFERENCES `NaironDB`.`Advertiser` (`advertiserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Advert_AdvertBudget1`
    FOREIGN KEY (`advertBudgetId`)
    REFERENCES `NaironDB`.`AdvertBudget` (`advertBudgetId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`Publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`Publisher` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`Publisher` (
  `publisherId` INT NOT NULL,
  `publisherWalletId` INT NOT NULL,
  `naironUserEmail` VARCHAR(100) NOT NULL,
  `publishedAdvertId` INT NULL,
  `blogUrl` VARCHAR(45) NULL,
  PRIMARY KEY (`publisherId`, `naironUserEmail`),
  INDEX `fk_PublisherUser_Pwallet1_idx` (`publisherWalletId` ASC),
  INDEX `fk_PublisherUser_NaironUser1_idx` (`naironUserEmail` ASC),
  INDEX `fk_Publisher_Advert1_idx` (`publishedAdvertId` ASC),
  CONSTRAINT `fk_PublisherUser_Pwallet1`
    FOREIGN KEY (`publisherWalletId`)
    REFERENCES `NaironDB`.`PublisherWallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PublisherUser_NaironUser1`
    FOREIGN KEY (`naironUserEmail`)
    REFERENCES `NaironDB`.`NaironUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publisher_Advert1`
    FOREIGN KEY (`publishedAdvertId`)
    REFERENCES `NaironDB`.`Advert` (`advertId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`AdvertQuestion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`AdvertQuestion` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`AdvertQuestion` (
  `advertQuestionId` INT NOT NULL,
  `advertId` INT NOT NULL,
  `question` VARCHAR(45) NULL,
  PRIMARY KEY (`advertQuestionId`),
  INDEX `fk_AdvertQuestion_Advert1_idx` (`advertId` ASC),
  CONSTRAINT `fk_AdvertQuestion_Advert1`
    FOREIGN KEY (`advertId`)
    REFERENCES `NaironDB`.`Advert` (`advertId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`AdvertAnswer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`AdvertAnswer` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`AdvertAnswer` (
  `advertAnswerId` INT NOT NULL,
  `advertQuestionId` INT NOT NULL,
  `answer` VARCHAR(45) NULL,
  PRIMARY KEY (`advertAnswerId`),
  INDEX `fk_AdvertAnswer_AdvertQuestion1_idx` (`advertQuestionId` ASC),
  UNIQUE INDEX `answer_UNIQUE` (`answer` ASC),
  CONSTRAINT `fk_AdvertAnswer_AdvertQuestion1`
    FOREIGN KEY (`advertQuestionId`)
    REFERENCES `NaironDB`.`AdvertQuestion` (`advertQuestionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NaironDB`.`Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NaironDB`.`Admin` ;

CREATE TABLE IF NOT EXISTS `NaironDB`.`Admin` (
  `adminId` INT NOT NULL,
  `naironUserEmail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`adminId`),
  INDEX `fk_Admin_NaironUser1_idx` (`naironUserEmail` ASC),
  CONSTRAINT `fk_Admin_NaironUser1`
    FOREIGN KEY (`naironUserEmail`)
    REFERENCES `NaironDB`.`NaironUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
