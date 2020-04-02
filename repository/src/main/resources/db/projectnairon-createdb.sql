-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nairondb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nairondb
-- -----------------------------------------------------
DROP DATABASE nairondb;
CREATE SCHEMA IF NOT EXISTS `nairondb` DEFAULT CHARACTER SET utf8 ;
USE `nairondb`;

-- -----------------------------------------------------
-- Table `nairondb`.`nairon_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`nairon_user` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`nairon_user` (
  `nairon_user_id` INT(10) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(100) NULL,
  `business_sector` VARCHAR(100) NULL,
  `business_name` VARCHAR(100) NULL,
  `gender` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`nairon_user_id`, `email`),
  INDEX `email_index` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`publisher_wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`publisher_wallet` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`publisher_wallet` (
  `walletId` INT NOT NULL,
  `walletBalance` DECIMAL NULL,
  PRIMARY KEY (`walletId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advertiser_wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advertiser_wallet` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advertiser_wallet` (
  `wallet_id` INT NOT NULL,
  `wallet_balance` DOUBLE NULL,
  PRIMARY KEY (`wallet_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`transaction` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`transaction` (
  `transactionId` INT NOT NULL,
  `transactionType` VARCHAR(45) NOT NULL,
  `transactionDate` VARCHAR(45) NOT NULL,
  `advertiser_walletId` INT NOT NULL,
  `publisher_walletId` INT NOT NULL,
  PRIMARY KEY (`transactionId`),
  INDEX `fk_transaction_advertiser_wallet1_idx` (`advertiser_walletId` ASC),
  INDEX `fk_transaction_publisher_wallet1_idx` (`publisher_walletId` ASC),
  CONSTRAINT `fk_transaction_advertiser_wallet1`
    FOREIGN KEY (`advertiser_walletId`)
    REFERENCES `nairondb`.`advertiser_wallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_publisher_wallet1`
    FOREIGN KEY (`publisher_walletId`)
    REFERENCES `nairondb`.`publisher_wallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advertiser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advertiser` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advertiser` (
  `advertiserId` INT NOT NULL AUTO_INCREMENT,
  `advertiser_walletId` INT NOT NULL,
  `naironuserEmail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`advertiserId`, `naironuserEmail`),
  INDEX `fk_advertiserUser_Awallet1_idx` (`advertiser_walletId` ASC),
  INDEX `fk_advertiserUser_nairon_user1_idx` (`naironuserEmail` ASC),
  CONSTRAINT `fk_advertiserUser_Awallet1`
    FOREIGN KEY (`advertiser_walletId`)
    REFERENCES `nairondb`.`advertiser_wallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertiserUser_nairon_user1`
    FOREIGN KEY (`naironuserEmail`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advert_budget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert_budget` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert_budget` (
  `advert_budgetId` INT NOT NULL,
  `budgetAmount` DOUBLE NULL,
  `budgetBalance` DOUBLE NULL,
  `budgetPerDay` DOUBLE NULL,
  `standingOrder` VARCHAR(45) NULL,
  PRIMARY KEY (`advert_budgetId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert` (
  `advertId` INT NOT NULL,
  `advertiserUser` INT NOT NULL,
  `advert_budgetId` INT NOT NULL,
  `advertDuration` VARCHAR(45) NOT NULL,
  INDEX `fk_advert_advertiserUser1_idx` (`advertiserUser` ASC),
  PRIMARY KEY (`advertId`),
  INDEX `fk_advert_advert_budget1_idx` (`advert_budgetId` ASC),
  CONSTRAINT `fk_advert_advertiserUser1`
    FOREIGN KEY (`advertiserUser`)
    REFERENCES `nairondb`.`advertiser` (`advertiserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_advert_budget1`
    FOREIGN KEY (`advert_budgetId`)
    REFERENCES `nairondb`.`advert_budget` (`advert_budgetId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`publisher` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`publisher` (
  `publisherId` INT NOT NULL,
  `publisher_walletId` INT NOT NULL,
  `naironuserEmail` VARCHAR(100) NOT NULL,
  `publishedadvertId` INT NULL,
  `blogUrl` VARCHAR(45) NULL,
  PRIMARY KEY (`publisherId`, `naironuserEmail`),
  INDEX `fk_publisherUser_Pwallet1_idx` (`publisher_walletId` ASC),
  INDEX `fk_publisherUser_nairon_user1_idx` (`naironuserEmail` ASC),
  INDEX `fk_publisher_advert1_idx` (`publishedadvertId` ASC),
  CONSTRAINT `fk_publisherUser_Pwallet1`
    FOREIGN KEY (`publisher_walletId`)
    REFERENCES `nairondb`.`publisher_wallet` (`walletId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publisherUser_nairon_user1`
    FOREIGN KEY (`naironuserEmail`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publisher_advert1`
    FOREIGN KEY (`publishedadvertId`)
    REFERENCES `nairondb`.`advert` (`advertId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advertQuestion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advertQuestion` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advertQuestion` (
  `advertQuestionId` INT NOT NULL,
  `advertId` INT NOT NULL,
  `question` VARCHAR(45) NULL,
  PRIMARY KEY (`advertQuestionId`),
  INDEX `fk_advertQuestion_advert1_idx` (`advertId` ASC),
  CONSTRAINT `fk_advertQuestion_advert1`
    FOREIGN KEY (`advertId`)
    REFERENCES `nairondb`.`advert` (`advertId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`advertAnswer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advertAnswer` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advertAnswer` (
  `advertAnswerId` INT NOT NULL,
  `advertQuestionId` INT NOT NULL,
  `answer` VARCHAR(45) NULL,
  PRIMARY KEY (`advertAnswerId`),
  INDEX `fk_advertAnswer_advertQuestion1_idx` (`advertQuestionId` ASC),
  UNIQUE INDEX `answer_UNIQUE` (`answer` ASC),
  CONSTRAINT `fk_advertAnswer_advertQuestion1`
    FOREIGN KEY (`advertQuestionId`)
    REFERENCES `nairondb`.`advertQuestion` (`advertQuestionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`admin` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`admin` (
  `adminId` INT NOT NULL,
  `naironuserEmail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`adminId`),
  INDEX `fk_admin_nairon_user1_idx` (`naironuserEmail` ASC),
  CONSTRAINT `fk_admin_nairon_user1`
    FOREIGN KEY (`naironuserEmail`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
