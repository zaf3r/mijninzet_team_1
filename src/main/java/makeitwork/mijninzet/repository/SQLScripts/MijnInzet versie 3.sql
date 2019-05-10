-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mijninzet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mijninzet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mijninzet` DEFAULT CHARACTER SET utf8 ;
USE `mijninzet` ;

-- -----------------------------------------------------
-- Table `mijninzet`.`gebruiker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`gebruiker` (
  `idGebruiker` INT(11) NOT NULL AUTO_INCREMENT,
  `gebruikersnaam` VARCHAR(45) NOT NULL,
  `wachtwoord` CHAR(60) NOT NULL,
  `actief` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idGebruiker`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

INSERT INTO `mijninzet`.`gebruiker` (`idGebruiker`, `gebruikersnaam`, `wachtwoord`,`actief`) VALUES ('1', 'TheBoss', '$2a$10$txE89lVWqzofuQpGc7LFcuC.y6BbsrtSeXUcUnOGU/Obw5cQsFNsS','1');
INSERT INTO `mijninzet`.`gebruiker` (`idGebruiker`, `gebruikersnaam`, `wachtwoord`,`actief`) VALUES ('2', 'TheTeacher', '$2a$10$szbWYgtrnVnTZV4FxwcS6.XfB7flFK3ElwMg70GDXzHvJn/q7GPSu','1');
INSERT INTO `mijninzet`.`gebruiker` (`idGebruiker`, `gebruikersnaam`, `wachtwoord`,`actief`) VALUES ('3', 'capo di tutti capi', '$2a$10$Gv9vyEofFsczKjLB73UbhevF9.Twq4DXzL1XvquYhFgxU0gPmd3fe','1');
INSERT INTO `mijninzet`.`gebruiker` (`idGebruiker`, `gebruikersnaam`, `wachtwoord`,`actief`) VALUES ('4', 'ForeverDisabled', '$2a$10$bkyCwHFpeiSt6TcaDCEXS.tOXrip8FmM0Hlrxy8ZjzRjdAb4yEYx2','0');

-- -----------------------------------------------------
-- Table `mijninzet`.`docent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`docent` (
  `idGebruiker` INT(11) NOT NULL,
  `Contracturen` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idGebruiker`),
  CONSTRAINT `fk_Docent_Gebruiker`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`gebruiker` (`idGebruiker`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`beschikbaarheid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`beschikbaarheid` (
  `Semester` DATE NOT NULL,
  `Jaar` TIME NOT NULL,
  `Blok` INT(11) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  PRIMARY KEY (`idGebruiker`, `Semester`, `Jaar`, `Blok`),
  INDEX `fk_Beschikbaarheid_Docent1_idx` (`idGebruiker` ASC) VISIBLE,
  CONSTRAINT `fk_Beschikbaarheid_Docent1`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`docent` (`idGebruiker`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`dagdelen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`dagdelen` (
  `Ochtend` INT(11) NOT NULL,
  `Middag` INT(11) NOT NULL,
  `Dag` DATE NOT NULL,
  `idnummer` INT(11) NOT NULL,
  `UrenDagDeel` INT(11) NOT NULL DEFAULT '4',
  PRIMARY KEY (`idnummer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`dagdelen_has_beschikbaarheid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`dagdelen_has_beschikbaarheid` (
  `idnummer` INT(11) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  `Semester` DATE NOT NULL,
  `Jaar` TIME NOT NULL,
  `Blok` INT(11) NOT NULL,
  PRIMARY KEY (`idnummer`, `idGebruiker`, `Semester`, `Jaar`, `Blok`),
  INDEX `fk_Dagdelen_has_Beschikbaarheid_Beschikbaarheid1_idx` (`idGebruiker` ASC, `Semester` ASC, `Jaar` ASC, `Blok` ASC) VISIBLE,
  INDEX `fk_Dagdelen_has_Beschikbaarheid_Dagdelen1_idx` (`idnummer` ASC) VISIBLE,
  CONSTRAINT `fk_Dagdelen_has_Beschikbaarheid_Beschikbaarheid1`
    FOREIGN KEY (`idGebruiker` , `Semester` , `Jaar` , `Blok`)
    REFERENCES `mijninzet`.`beschikbaarheid` (`idGebruiker` , `Semester` , `Jaar` , `Blok`),
  CONSTRAINT `fk_Dagdelen_has_Beschikbaarheid_Dagdelen1`
    FOREIGN KEY (`idnummer`)
    REFERENCES `mijninzet`.`dagdelen` (`idnummer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`incident`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`incident` (
  `idIncidenten` INT(11) NOT NULL,
  `idnummer` INT(11) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  `Semester` DATE NOT NULL,
  `Jaar` TIME NOT NULL,
  `Blok` INT(11) NOT NULL,
  PRIMARY KEY (`idIncidenten`),
  INDEX `fk_Incidenten_Dagdelen_has_Beschikbaarheid1_idx` (`idnummer` ASC, `idGebruiker` ASC, `Semester` ASC, `Jaar` ASC, `Blok` ASC) VISIBLE,
  CONSTRAINT `fk_Incidenten_Dagdelen_has_Beschikbaarheid1`
    FOREIGN KEY (`idnummer` , `idGebruiker` , `Semester` , `Jaar` , `Blok`)
    REFERENCES `mijninzet`.`dagdelen_has_beschikbaarheid` (`idnummer` , `idGebruiker` , `Semester` , `Jaar` , `Blok`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`rollen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`rollen` (
  `Rol_id` INT(11) NOT NULL,
  `Rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Rol_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `rollen`(`Rol_id`,`Rol`) VALUES ('1','Docent');
INSERT INTO `rollen`(`Rol_id`,`Rol`) VALUES ('2','Administrateur');
INSERT INTO `rollen`(`Rol_id`,`Rol`) VALUES ('3','Systeem');
INSERT INTO `rollen`(`Rol_id`,`Rol`) VALUES ('4','Manager');
INSERT INTO `rollen`(`Rol_id`,`Rol`) VALUES ('5','Roosteraar');

-- -----------------------------------------------------
-- Table `mijninzet`.`rollen_gebruiker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`rollen_gebruiker` (
  `idGebruiker` INT(11) NOT NULL,
  `Rol_id` INT(11) NOT NULL,
  PRIMARY KEY (`idGebruiker`, `Rol_id`),
  INDEX `fk_Gebruiker_has_Rollen_Rollen1_idx` (`Rol_id` ASC) VISIBLE,
  INDEX `fk_Gebruikerollenr_has_Rollen_Gebruiker1_idx` (`idGebruiker` ASC) VISIBLE,
  CONSTRAINT `fk_Gebruiker_has_Rollen_Gebruiker1`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`gebruiker` (`idGebruiker`),
  CONSTRAINT `fk_Gebruiker_has_Rollen_Rollen1`
    FOREIGN KEY (`Rol_id`)
    REFERENCES `mijninzet`.`rollen` (`Rol_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`taak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`taak` (
  `Titel` VARCHAR(45) NOT NULL,
  `Duur(uren)` DOUBLE NOT NULL,
  `Geldigheidsduur` INT(11) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  `Vak` VARCHAR(45) NULL DEFAULT NULL,
  `Onderwijstaak ja/nee` TINYINT(4) NOT NULL,
  PRIMARY KEY (`Titel`, `idGebruiker`),
  INDEX `fk_Taak_Docent1_idx` (`idGebruiker` ASC) VISIBLE,
  CONSTRAINT `fk_Taak_Docent1`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`docent` (`idGebruiker`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`vacature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`vacature` (
  `Titel` VARCHAR(45) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  `Ingangsdatum` DATETIME NOT NULL,
  `Einddatum` DATETIME NOT NULL,
  `Volgnummer` INT(11) NOT NULL,
  `idGebruiker1` INT(11) NOT NULL,
  PRIMARY KEY (`Volgnummer`),
  INDEX `fk_Vacature_Taak1_idx` (`idGebruiker1` ASC) VISIBLE,
  CONSTRAINT `fk_Vacature_Taak1`
    FOREIGN KEY (`idGebruiker1`)
    REFERENCES `mijninzet`.`taak` (`idGebruiker`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`vak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`vak` (
  `Vakcode` CHAR(25) NOT NULL,
  `Vaknaam` VARCHAR(45) NOT NULL,
  `Kennisgebied` VARCHAR(45) NOT NULL,
  `Opleiding` VARCHAR(45) NOT NULL,
  `Activiteitstype` VARCHAR(45) NOT NULL,
  `Titel` VARCHAR(45) NOT NULL,
  `idGebruiker` INT(11) NOT NULL,
  `Titel1` VARCHAR(45) NOT NULL,
  `idGebruiker1` INT(11) NOT NULL,
  PRIMARY KEY (`Vakcode`),
  INDEX `fk_Vak_Taak1_idx` (`Titel1` ASC, `idGebruiker1` ASC) VISIBLE,
  CONSTRAINT `fk_Vak_Taak1`
    FOREIGN KEY (`Titel1` , `idGebruiker1`)
    REFERENCES `mijninzet`.`taak` (`Titel` , `idGebruiker`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mijninzet`.`dagdeel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`dagdeel` (
  `werkdag` INT(1) NOT NULL,
  `dagdeel` INT(1) NOT NULL,
  PRIMARY KEY (`werkdag`, `dagdeel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mijninzet`.`docentt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`docentt` (
  `idGebruiker` INT NOT NULL,
  PRIMARY KEY (`idGebruiker`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mijninzet`.`globale_beschikbaarheid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`globale_beschikbaarheid` (
  `werkdag` INT(1) NOT NULL,
  `dagdeel` INT(1) NOT NULL,
  `idGebruiker` INT NOT NULL,
  `beschikbaar` TINYINT NOT NULL,
  INDEX `fk_globale_beschikbaarheid_dagdeel1_idx` (`werkdag` ASC, `dagdeel` ASC) VISIBLE,
  INDEX `fk_globale_beschikbaarheid_docent1_idx` (`idGebruiker` ASC) VISIBLE,
  PRIMARY KEY (`werkdag`, `dagdeel`, `idGebruiker`),
  CONSTRAINT `fk_globale_beschikbaarheid_dagdeel1`
    FOREIGN KEY (`werkdag` , `dagdeel`)
    REFERENCES `mijninzet`.`dagdeel` (`werkdag` , `dagdeel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_globale_beschikbaarheid_docent1`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`docentt` (`idGebruiker`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mijninzet`.`incidentele_beschikbaarheid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mijninzet`.`incidentele_beschikbaarheid` (
  `incidentId` INT NOT NULL,
  `datum` DATE NOT NULL,
  `dagdeel` INT NOT NULL,
  `idGebruiker` INT NOT NULL,
  PRIMARY KEY (`incidentId`),
  INDEX `fk_incidentele_beschikbaarheid_docent1_idx` (`idGebruiker` ASC) VISIBLE,
  CONSTRAINT `fk_incidentele_beschikbaarheid_docent1`
    FOREIGN KEY (`idGebruiker`)
    REFERENCES `mijninzet`.`docentt` (`idGebruiker`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('1', '4');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('2', '1');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('3', '1');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('3', '2');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('3', '3');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('3', '4');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('3', '5');
INSERT INTO `mijninzet`.`rollen_gebruiker` (`idGebruiker`, `Rol_id`) VALUES ('4', '1');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
