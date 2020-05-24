-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema nairon_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nairon_db` ;

-- -----------------------------------------------------
-- Schema nairon_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nairon_db` DEFAULT CHARACTER SET latin1 ;
USE `nairon_db` ;

-- -----------------------------------------------------
-- Table `nairon_db`.`nairon_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`nairon_user` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`nairon_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `full_name` VARCHAR(100) NULL DEFAULT NULL,
  `gender` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `UK35c2nk7kaqa3n4uamahjal6xl` (`email` ASC, `phone_number` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`advert` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`advert` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `title` VARCHAR(250) NOT NULL,
  `age_range` VARCHAR(11) NOT NULL,
  `gender` VARCHAR(11) NOT NULL,
  `placement_type` VARCHAR(45) NOT NULL,
  `created_on` DATETIME NOT NULL,
  `display_format` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_advert_nairon_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_advert_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_budget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_budget` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_budget` (
  `budget_id` INT(11) NOT NULL AUTO_INCREMENT,
  `budget_amount` DOUBLE NOT NULL,
  `budget_balance` DOUBLE NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `budget_per_day` DOUBLE NOT NULL,
  `advert_id` INT(11) NOT NULL,
  PRIMARY KEY (`budget_id`, `advert_id`),
  INDEX `fk_advert_budget_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advert_budget_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_business_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_business_category` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_business_category` (
  `category_name` VARCHAR(45) NOT NULL,
  `advert_id` INT(11) NOT NULL,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC),
  INDEX `fk_ad_business_category_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_ad_business_category_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_devices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_devices` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_devices` (
  `id` INT(11) NOT NULL,
  `brand_name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `advert_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ad_devices_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_ad_devices_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_device_versions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_device_versions` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_device_versions` (
  `version` VARCHAR(45) NOT NULL,
  `ad_devices_id` INT(11) NOT NULL,
  PRIMARY KEY (`ad_devices_id`),
  CONSTRAINT `fk_ad_device_versions_ad_devices1`
    FOREIGN KEY (`ad_devices_id`)
    REFERENCES `nairon_db`.`ad_devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`location` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`location` (
  `id` INT(11) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`advert_has_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`advert_has_location` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`advert_has_location` (
  `advert_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`advert_id`, `location_id`),
  INDEX `fk_advert_has_location_location1_idx` (`location_id` ASC),
  INDEX `fk_advert_has_location_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_advert_has_location_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
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
-- Table `nairon_db`.`business`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`business` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`business` (
  `business_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `website_url` VARCHAR(100) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`business_id`),
  INDEX `fk_business_nairon_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_business_nairon_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`city` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`city` (
  `city_name` VARCHAR(45) NOT NULL,
  `location_id` INT(11) NOT NULL,
  INDEX `fk_city_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_city_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `nairon_db`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`questionnaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`questionnaire` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`questionnaire` (
  `questionnaire_id` INT(11) NOT NULL AUTO_INCREMENT,
  `max_pages` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`question` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`question` (
  `id` INT(11) NOT NULL,
  `question` VARCHAR(112) NOT NULL,
  `page_level` INT(11) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `questionnaire_id` INT(11) NOT NULL,
  `advert_property` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_page_questionnaire1_idx` (`questionnaire_id` ASC),
  CONSTRAINT `fk_page_questionnaire1`
    FOREIGN KEY (`questionnaire_id`)
    REFERENCES `nairon_db`.`questionnaire` (`questionnaire_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`question_options`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`question_options` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`question_options` (
  `choice` VARCHAR(255) NULL DEFAULT NULL,
  `question_id` INT(11) NOT NULL,
  INDEX `fk_question_options_question1_idx` (`question_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_ad_creation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_ad_creation` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_ad_creation` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_business_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_business_category` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_business_category` (
  `category_name` VARCHAR(100) NOT NULL,
  `ref_ad_creation_id` INT NOT NULL,
  INDEX `fk_ref_business_category_ref_ad_creation1_idx` (`ref_ad_creation_id` ASC),
  CONSTRAINT `fk_ref_business_category_ref_ad_creation1`
    FOREIGN KEY (`ref_ad_creation_id`)
    REFERENCES `nairon_db`.`ref_ad_creation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_mobile_devices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_mobile_devices` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_mobile_devices` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `brand_name` VARCHAR(45) NOT NULL,
  `ref_ad_creation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ref_mobile_devices_ref_ad_creation1_idx` (`ref_ad_creation_id` ASC),
  CONSTRAINT `fk_ref_mobile_devices_ref_ad_creation1`
    FOREIGN KEY (`ref_ad_creation_id`)
    REFERENCES `nairon_db`.`ref_ad_creation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_device_versions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_device_versions` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_device_versions` (
  `version` VARCHAR(45) NULL DEFAULT NULL,
  `device_id` INT(11) NOT NULL,
  INDEX `fk_device_versions_device_idx` (`device_id` ASC),
  CONSTRAINT `fk_device_versions_device`
    FOREIGN KEY (`device_id`)
    REFERENCES `nairon_db`.`ref_mobile_devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`roles` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`roles` (
  `id` INT(11) NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  `nairon_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC),
  INDEX `fk_roles_nairon_user1_idx` (`nairon_user_id` ASC),
  CONSTRAINT `fk_roles_nairon_user1`
    FOREIGN KEY (`nairon_user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`wallet` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`wallet` (
  `wallet_id` INT(11) NOT NULL AUTO_INCREMENT,
  `wallet_balance` DOUBLE NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `nairon_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`wallet_id`, `nairon_user_id`),
  INDEX `fk_wallet_nairon_user1_idx` (`nairon_user_id` ASC),
  CONSTRAINT `fk_wallet_nairon_user1`
    FOREIGN KEY (`nairon_user_id`)
    REFERENCES `nairon_db`.`nairon_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_headlines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_headlines` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_headlines` (
  `advert_id` INT(11) NOT NULL,
  `headline1` VARCHAR(112) NOT NULL,
  `headline2` VARCHAR(112) NULL,
  `description1` VARCHAR(250) NULL,
  `description2` VARCHAR(250) NULL,
  `display_url` VARCHAR(200) NULL,
  `image_url` VARCHAR(140) NOT NULL,
  INDEX `fk_ad_headlines_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_ad_headlines_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_isp`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_isp` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_isp` (
  `isp_name` VARCHAR(50) NOT NULL,
  `ref_ad_creation_id` INT NOT NULL,
  INDEX `fk_ref_isp_ref_ad_creation1_idx` (`ref_ad_creation_id` ASC),
  CONSTRAINT `fk_ref_isp_ref_ad_creation1`
    FOREIGN KEY (`ref_ad_creation_id`)
    REFERENCES `nairon_db`.`ref_ad_creation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `nairon_db`.`ref_desktop_devices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_desktop_devices` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_desktop_devices` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `brand_name` VARCHAR(45) NOT NULL,
  `ref_ad_creation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ref_mobile_devices_ref_ad_creation1_idx` (`ref_ad_creation_id` ASC),
  CONSTRAINT `fk_ref_mobile_devices_ref_ad_creation10`
    FOREIGN KEY (`ref_ad_creation_id`)
    REFERENCES `nairon_db`.`ref_ad_creation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ref_desktop_versions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ref_desktop_versions` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ref_desktop_versions` (
  `version` VARCHAR(45) NULL DEFAULT NULL,
  `ref_desktop_devices_id` INT(11) NOT NULL,
  INDEX `fk_ref_device_versions_copy1_ref_desktop_devices1_idx` (`ref_desktop_devices_id` ASC),
  CONSTRAINT `fk_ref_device_versions_copy1_ref_desktop_devices1`
    FOREIGN KEY (`ref_desktop_devices_id`)
    REFERENCES `nairon_db`.`ref_desktop_devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `nairon_db`.`ad_isp`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nairon_db`.`ad_isp` ;

CREATE TABLE IF NOT EXISTS `nairon_db`.`ad_isp` (
  `isp_name` VARCHAR(50) NOT NULL,
  `advert_id` INT(11) NOT NULL,
  INDEX `fk_ad_isp_advert1_idx` (`advert_id` ASC),
  CONSTRAINT `fk_ad_isp_advert1`
    FOREIGN KEY (`advert_id`)
    REFERENCES `nairon_db`.`advert` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
