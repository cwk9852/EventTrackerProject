-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema crestdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `crestdb` ;

-- -----------------------------------------------------
-- Schema crestdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crestdb` DEFAULT CHARACTER SET utf8 ;
USE `crestdb` ;

-- -----------------------------------------------------
-- Table `entity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `entity` ;

CREATE TABLE IF NOT EXISTS `entity` (
  `id` INT NOT NULL,
  `stuff` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS crestdbuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'crestdbuser'@'localhost' IDENTIFIED BY 'crestdbuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'crestdbuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `entity`
-- -----------------------------------------------------
START TRANSACTION;
USE `crestdb`;
INSERT INTO `entity` (`id`, `stuff`) VALUES (1, 'Hello, World!');
INSERT INTO `entity` (`id`, `stuff`) VALUES (2, 'Its Friday!');

COMMIT;

