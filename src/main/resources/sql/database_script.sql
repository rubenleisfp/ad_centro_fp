-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ad_centro_fp
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ad_centro_fp` ;

-- -----------------------------------------------------
-- Schema ad_centro_fp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ad_centro_fp` DEFAULT CHARACTER SET utf8 ;
USE `ad_centro_fp` ;

-- -----------------------------------------------------
-- Table `ad_centro_fp`.`ALUMNO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ad_centro_fp`.`ALUMNO` ;

CREATE TABLE IF NOT EXISTS `ad_centro_fp`.`ALUMNO` (
  `matricula` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(75) NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ad_centro_fp`.`MODULO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ad_centro_fp`.`MODULO` ;

CREATE TABLE IF NOT EXISTS `ad_centro_fp`.`MODULO` (
  `cod_modulo` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_modulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ad_centro_fp`.`CALIFICACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ad_centro_fp`.`CALIFICACION` ;

CREATE TABLE IF NOT EXISTS `ad_centro_fp`.`CALIFICACION` (
  `ALUMNO_matricula` VARCHAR(20) NOT NULL,
  `MODULO_cod_modulo` VARCHAR(20) NOT NULL,
  `nota` DECIMAL(3,1) NOT NULL,
  PRIMARY KEY (`ALUMNO_matricula`, `MODULO_cod_modulo`),
  INDEX `fk_ALUMNO_has_MODULO_MODULO1_idx` (`MODULO_cod_modulo` ASC) VISIBLE,
  INDEX `fk_ALUMNO_has_MODULO_ALUMNO_idx` (`ALUMNO_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_ALUMNO_has_MODULO_ALUMNO`
    FOREIGN KEY (`ALUMNO_matricula`)
    REFERENCES `ad_centro_fp`.`ALUMNO` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ALUMNO_has_MODULO_MODULO1`
    FOREIGN KEY (`MODULO_cod_modulo`)
    REFERENCES `ad_centro_fp`.`MODULO` (`cod_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Insertar módulos
INSERT INTO MODULO (cod_modulo, nombre) VALUES
  ('PRG', 'Programación'),
  ('BDD', 'Bases de Datos');


-- Insertar calificaciones
INSERT INTO CALIFICACION (ALUMNO_matricula, MODULO_cod_modulo, nota) VALUES
  ('DAM2025-001', 'PRG', 8.5),
  ('DAM2025-001', 'BDD', 9.0),
  ('DAM2025-002', 'PRG', 6.0),
  ('DAM2025-002', 'BDD', 7.2),
  ('DAM2025-003', 'PRG', 9.1),
  ('DAM2025-003', 'BDD', 9.5),
  ('DAM2025-004', 'PRG', 5.0),
  ('DAM2025-004', 'BDD', 6.3),
  ('DAM2025-005', 'PRG', 8.2),
  ('DAM2025-005', 'BDD', 8.7),
  ('DAM2025-006', 'PRG', 4.5),
  ('DAM2025-006', 'BDD', 5.8),
  ('DAM2025-007', 'PRG', 7.3),
  ('DAM2025-007', 'BDD', 7.8),
  ('DAM2025-008', 'PRG', 6.9),
  ('DAM2025-008', 'BDD', 7.1),
  ('DAM2025-009', 'PRG', 9.8),
  ('DAM2025-009', 'BDD', 9.4),
  ('DAM2025-010', 'PRG', 6.4),
  ('DAM2025-010', 'BDD', 6.9);
