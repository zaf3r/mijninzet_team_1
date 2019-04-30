-- MySQL Workbench Forward Engineering
-- ----------------------------------------------------
# dit script genereert een database met databasegebruiker
# op een lokale machine (localhost meestal op 
# adres 127.0.0.1). 
#LET OP: script controleert of database objecten bestaan,
# zo ja dan wordt database "gedropt".
-- ----------------------------------------------------


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Quizmaster
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Quizmaster` ;

-- -----------------------------------------------------
-- Schema Quizmaster
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Quizmaster` DEFAULT CHARACTER SET utf8 ;
USE `Quizmaster` ;

-- ------------------------------------------------------
-- Aanmaken database-user met ALLE rechten
-- ------------------------------------------------------
DROP USER 'Umaster'@'localhost';
CREATE USER 'Umaster'@'localhost' IDENTIFIED BY 'pwdUmaster';
GRANT ALL PRIVILEGES ON * . * TO 'Umaster'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


