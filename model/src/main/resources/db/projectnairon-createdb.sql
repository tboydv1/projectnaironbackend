-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- Schema nairon_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nairon_db` ;

-- -----------------------------------------------------
-- Schema nairon_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nairon_db` DEFAULT CHARACTER SET latin1 ;
USE `nairon_db` ;

-- -----------------------------------------------------
-- Table `nairon_db`.`device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`device` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `brand_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`device_versions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`device_versions` (
#   `brand_name` VARCHAR(45) NOT NULL,
  `version` VARCHAR(45) NULL,
  `device_id` INT(11) NOT NULL,
  INDEX `fk_device_versions_device_idx` (`device_id` ASC),
  CONSTRAINT `fk_device_versions_device`
    FOREIGN KEY (`device_id`)
    REFERENCES `nairon_db`.`device` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `nairon_db` ;

-- -----------------------------------------------------
-- Table `nairon_db`.`advert_budget`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advert_budget` (
  `budget_id` INT(11) NOT NULL AUTO_INCREMENT,
  `budget_amount` DOUBLE NOT NULL,
  `budget_balance` DOUBLE NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `budget_per_day` DOUBLE NOT NULL,
  PRIMARY KEY (`budget_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`nairon_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`nairon_user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `fullname` VARCHAR(100) NULL DEFAULT NULL,
  `gender` VARCHAR(11) NULL DEFAULT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `UK35c2nk7kaqa3n4uamahjal6xl` (`email` ASC, `phone_number` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 89
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advert` (
  `advert_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `title` VARCHAR(250) NOT NULL,
  `age_range` VARCHAR(11) NOT NULL,
  `gender` VARCHAR(11) NOT NULL,
  `placement_type` VARCHAR(45) NOT NULL,
  `created_on` DATETIME NOT NULL,
  `headlines` VARCHAR(500) NULL DEFAULT NULL,
  `image_url` VARCHAR(250) NULL DEFAULT NULL,
  `isp_technology` VARCHAR(50) NULL DEFAULT NULL,
  `product_unique_desc` VARCHAR(140) NULL DEFAULT NULL,
  `display_format` VARCHAR(45) NULL DEFAULT NULL,
  `budget_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`advert_id`),
  INDEX `fk_advert_nairon_user1_idx` (`user_id` ASC),
  INDEX `fk_advert_budget_id1` (`budget_id` ASC),
  CONSTRAINT `fk_advert_budget_id1`
    FOREIGN KEY (`budget_id`)
    REFERENCES `nairon_db`.`advert_budget` (`budget_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`business_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`business_category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 56
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert_has_business_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advert_has_business_category` (
  `advert_id` INT(11) NOT NULL,
  `business_category_id` INT(11) NOT NULL,
  PRIMARY KEY (`advert_id`, `business_category_id`),
  INDEX `fk_advert_has_business_category_business_category1_idx` (`business_category_id` ASC),
  INDEX `fk_advert_has_business_category_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advert_has_business_category_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_has_business_category_business_category1`
    FOREIGN KEY (`business_category_id`)
    REFERENCES `nairon_db`.`business_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`device` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `brand_name` VARCHAR(45) NOT NULL,
  `version` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert_has_device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advert_has_device` (
  `advert_id` INT(11) NOT NULL,
  `device_id` INT(11) NOT NULL,
  PRIMARY KEY (`advert_id`, `device_id`),
  INDEX `fk_advert_has_device_device1_idx` (`device_id` ASC),
  INDEX `fk_advert_has_device_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advert_has_device_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_has_device_device1`
    FOREIGN KEY (`device_id`)
    REFERENCES `nairon_db`.`device` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`location` (
  `id` INT(11) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert_has_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advert_has_location` (
  `advert_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`advert_id`, `location_id`),
  INDEX `fk_advert_has_location_location1_idx` (`location_id` ASC),
  INDEX `fk_advert_has_location_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advert_has_location_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`advert_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advert_has_location_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `nairon_db`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`cash_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`cash_wallet` (
  `wallet_id` INT(11) NOT NULL AUTO_INCREMENT,
  `wallet_balance` DOUBLE NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`wallet_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advertiser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`advertiser` (
  `advertiser_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `wallet_id` INT(11) NOT NULL,
  `walet_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`advertiser_id`, `user_id`),
  INDEX `fk_advertiser_nairon_user_idx` (`user_id` ASC),
  INDEX `fk_advertiser_wallet1_idx` (`wallet_id` ASC),
  CONSTRAINT `fk_advertiser_nairon_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertiser_wallet1`
    FOREIGN KEY (`wallet_id`)
    REFERENCES `nairon_db`.`cash_wallet` (`wallet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`business` (
  `business_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `website_url` VARCHAR(100) NULL DEFAULT NULL,
  `business_sector_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `business_sector_id_id` INT(11) NULL DEFAULT NULL,
  `user_id_user_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`business_id`),
  INDEX `fk_business_business_sector1_idx` (`business_sector_id` ASC),
  INDEX `fk_business_nairon_user1_idx` (`user_id` ASC),
  INDEX `FK5vn85ma7po2dx180jnna9t5qd` (`business_sector_id_id` ASC),
  INDEX `FKecshtnxcudphwnnx537ki8ysr` (`user_id_user_id` ASC),
  CONSTRAINT `FK5vn85ma7po2dx180jnna9t5qd`
    FOREIGN KEY (`business_sector_id_id`)
    REFERENCES `nairon_db`.`business_category` (`id`),
  CONSTRAINT `FKecshtnxcudphwnnx537ki8ysr`
    FOREIGN KEY (`user_id_user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`user_id`),
  CONSTRAINT `fk_business_business_sector1`
    FOREIGN KEY (`business_sector_id`)
    REFERENCES `nairon_db`.`business_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`questionnaire` (
  `questionnaire_id` INT(11) NOT NULL AUTO_INCREMENT,
  `max_pages` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 201
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`question` (
  `question_id` INT(11) NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `page_level` INT(11) NOT NULL,
  `advert_property` VARCHAR(45) NOT NULL,
  `questionnaire_id` INT(11) NOT NULL,
  PRIMARY KEY (`question_id`),
  INDEX `fk_question_questionnaire1_idx` (`questionnaire_id` ASC),
  CONSTRAINT `fk_question_questionnaire1`
    FOREIGN KEY (`questionnaire_id`)
    REFERENCES `nairon_db`.`questionnaire` (`questionnaire_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`question_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`question_options` (
  `choice` VARCHAR(255) NULL DEFAULT NULL,
  `question_id` INT(11) NOT NULL,
  INDEX `fk_question_options_question1_idx` (`question_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nairon_db`.`sub_category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `business_category_id` INT(11) NOT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sub_category_business_category1_idx` (`business_category_id` ASC),
  INDEX `FKj6mqsr7prxgmqdg9h2uwt5kle` (`category_id` ASC),
  CONSTRAINT `FKj6mqsr7prxgmqdg9h2uwt5kle`
    FOREIGN KEY (`category_id`)
    REFERENCES `nairon_db`.`business_category` (`id`),
  CONSTRAINT `fk_sub_category_business_category1`
    FOREIGN KEY (`business_category_id`)
    REFERENCES `nairon_db`.`business_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
