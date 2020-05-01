-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema nairondb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nairondb` ;

-- -----------------------------------------------------
-- Schema nairondb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nairondb` DEFAULT CHARACTER SET latin1 ;
USE `nairondb` ;

-- -----------------------------------------------------
-- Table `nairondb`.`advert_budget`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`advert_budget` (
  `budget_id` INT(11) NOT NULL AUTO_INCREMENT,
  `budget_amount` DOUBLE NOT NULL,
  `budget_balance` DOUBLE NOT NULL,
  `start_date` DATETIME  NULL,
  `budget_per_day` DOUBLE NOT NULL,
    PRIMARY KEY (`budget_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`nairon_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`nairon_user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `fullname` VARCHAR(100) NULL DEFAULT NULL,
  `gender` VARCHAR(11) NULL DEFAULT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`advert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`advert` (
  `advert_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `title` VARCHAR(250) NOT NULL,
  `age_range` VARCHAR(11) NOT NULL,
  `target_location` VARCHAR(500) NOT NULL,
  `gender` VARCHAR(11) NOT NULL,
  `placement_type` VARCHAR(45) NOT NULL,
  `created_on` DATETIME NOT NULL ,
  `headlines` VARCHAR(500) NULL,
  `image_url` VARCHAR(250) NULL,
  `business_categories` VARCHAR(250) NULL,
  `devices` VARCHAR(250) NULL,
  `mobile_brands` VARCHAR(50) NULL,
  `desktop_brands` VARCHAR(50) NULL,
  `isp_technology` VARCHAR(50) NULL,
  `product_unique_desc` VARCHAR(140) NULL,
  `display_format` VARCHAR(45) NULL,
  `budget_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`advert_id`),

  INDEX `fk_advert_nairon_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_advert_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairondb`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_budget_id1`
      FOREIGN KEY (`budget_id`)
      REFERENCES `nairondb`.`advert_budget` (`budget_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`cash_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`cash_wallet` (
  `wallet_id` INT(11) NOT NULL AUTO_INCREMENT,
  `wallet_balance` DOUBLE NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`wallet_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`advertiser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`advertiser` (
  `advertiser_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `wallet_id` INT(11) NOT NULL,
  PRIMARY KEY (`advertiser_id`, `user_id`),
  INDEX `fk_advertiser_nairon_user_idx` (`user_id` ASC),
  INDEX `fk_advertiser_wallet1_idx` (`wallet_id` ASC),
  CONSTRAINT `fk_advertiser_nairon_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairondb`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertiser_wallet1`
    FOREIGN KEY (`wallet_id`)
    REFERENCES `nairondb`.`cash_wallet` (`wallet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`business_sector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`business_sector` (
  `sector_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sector_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sector_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`business` (
  `business_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `website_url` VARCHAR(100) NULL DEFAULT NULL,
  `business_sector_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`business_id`),
  INDEX `fk_business_business_sector1_idx` (`business_sector_id` ASC),
  INDEX `fk_business_nairon_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_business_business_sector1`
    FOREIGN KEY (`business_sector_id`)
    REFERENCES `nairondb`.`business_sector` (`sector_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairondb`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`questionnaire` (
  `questionnaire_id` INT(11) NOT NULL AUTO_INCREMENT,
  `max_pages` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`questionnaire_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 596
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairondb`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairondb`.`question` (
  `question_id` INT(11) NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `page_level` INT(11) NOT NULL,
  `choice` VARCHAR(45) NULL,
  `advert_property` VARCHAR(45) NOT NULL,
  `questionnaire_id` INT(11) NOT NULL,
  PRIMARY KEY (`question_id`),
  INDEX `fk_question_questionnaire1_idx` (`questionnaire_id` ASC),
  CONSTRAINT `fk_question_questionnaire1`
    FOREIGN KEY (`questionnaire_id`)
    REFERENCES `nairondb`.`questionnaire` (`questionnaire_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
