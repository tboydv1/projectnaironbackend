-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- Schema nairondb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nairondb` ;

-- -----------------------------------------------------
-- Schema nairondb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nairondb` DEFAULT CHARACTER SET utf8 ;


-- -----------------------------------------------------
-- Table `mydb`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`roles` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`roles` (
  `roles_id` INT NOT NULL AUTO_INCREMENT,
  `roles_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roles_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairondb`.`nairon_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`nairon_user` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`nairon_user` (
  `nairon_user_id` INT(10) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(100) NULL DEFAULT NULL,
  `business_sector` VARCHAR(100) NULL DEFAULT NULL,
  `business_name` VARCHAR(100) NULL DEFAULT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`nairon_user_id`, `email`),
  INDEX `email_index` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`roles_has_nairon_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`roles_has_nairon_user` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`roles_has_nairon_user` (
  `roles_roles_id` INT NOT NULL,
  `nairon_user__id` INT(10) NOT NULL,
  PRIMARY KEY (`roles_roles_id`, `nairon_user__id`),
  INDEX `fk_roles_has_nairon_user_nairon_user1_idx` (`nairon_user__id` ASC),
  INDEX `fk_roles_has_nairon_user_roles_idx` (`roles_roles_id` ASC),
  CONSTRAINT `fk_roles_has_nairon_user_roles`
    FOREIGN KEY (`roles_roles_id`)
    REFERENCES `nairondb`.`roles` (`roles_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_nairon_user_nairon_user1`
    FOREIGN KEY (`nairon_user__id`)
    REFERENCES `nairondb`.`nairon_user` (`nairon_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `nairondb` ;

-- -----------------------------------------------------
-- Table `nairondb`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`admin` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`admin` (
  `admin_id` INT(11) NOT NULL,
  `nairon_user_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`admin_id`),
  INDEX `fk_admin_nairon_user1_idx` (`nairon_user_email` ASC),
  CONSTRAINT `fk_admin_nairon_user1`
    FOREIGN KEY (`nairon_user_email`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`advert_budget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert_budget` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert_budget` (
  `advert_budget_id` INT(11) NOT NULL,
  `budget_amount` DOUBLE NULL DEFAULT NULL,
  `budget_balance` DOUBLE NULL DEFAULT NULL,
  `budget_per_day` DOUBLE NULL DEFAULT NULL,
  `standing_order` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`advert_budget_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`advert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert` (
  `advert_id` INT(11) NOT NULL,
  `advertiser_user` INT(11) NOT NULL,
  `advert_budget_id` INT(11) NOT NULL,
  `advert_duration` VARCHAR(45) NOT NULL,
  `nairon_user_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`advert_id`),
  INDEX `fk_advert_advert_budget1_idx` (`advert_budget_id` ASC),
  INDEX `fk_advert_nairon_user1_idx` (`nairon_user_email` ASC),
  CONSTRAINT `fk_advert_advert_budget1`
    FOREIGN KEY (`advert_budget_id`)
    REFERENCES `nairondb`.`advert_budget` (`advert_budget_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_nairon_user1`
    FOREIGN KEY (`nairon_user_email`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`advert_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert_question` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert_question` (
  `advert_question_id` INT(11) NOT NULL,
  `advert_id` INT(11) NOT NULL,
  `question` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`advert_question_id`),
  INDEX `fk_advertQuestion_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advertQuestion_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairondb`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`advert_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advert_answer` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advert_answer` (
  `advert_answerId` INT(11) NOT NULL,
  `advert_questionId` INT(11) NOT NULL,
  `answer` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`advert_answerId`),
  UNIQUE INDEX `answer_UNIQUE` (`answer` ASC),
  INDEX `fk_advertAnswer_advertQuestion1_idx` (`advert_questionId` ASC),
  CONSTRAINT `fk_advertAnswer_advertQuestion1`
    FOREIGN KEY (`advert_questionId`)
    REFERENCES `nairondb`.`advert_question` (`advert_question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`advertiser_wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`advertiser_wallet` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`advertiser_wallet` (
  `wallet_id` INT(11) NOT NULL,
  `wallet_balance` DOUBLE NULL DEFAULT NULL,
  `nairon_user_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`wallet_id`),
  INDEX `fk_advertiser_wallet_nairon_user1_idx` (`nairon_user_email` ASC),
  CONSTRAINT `fk_advertiser_wallet_nairon_user1`
    FOREIGN KEY (`nairon_user_email`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nairondb`.`publisher_wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairondb`.`publisher_wallet` ;

CREATE TABLE IF NOT EXISTS `nairondb`.`publisher_wallet` (
  `wallet_id` INT(11) NOT NULL,
  `wallet_balance` DECIMAL(10,0) NULL DEFAULT NULL,
  `nairon_user_email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`wallet_id`),
  INDEX `fk_publisher_wallet_nairon_user1_idx` (`nairon_user_email` ASC),
  CONSTRAINT `fk_publisher_wallet_nairon_user1`
    FOREIGN KEY (`nairon_user_email`)
    REFERENCES `nairondb`.`nairon_user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
