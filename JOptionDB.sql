-- MySQL Script generated by MySQL Workbench
-- Tue May 16 09:25:41 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema JOptionpaneDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema JOptionpaneDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JOptionpaneDB` DEFAULT CHARACTER SET utf8 ;
USE `JOptionpaneDB` ;

-- -----------------------------------------------------
-- Table `JOptionpaneDB`.`empresas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JOptionpaneDB`.`empresas` ;

CREATE TABLE IF NOT EXISTS `JOptionpaneDB`.`empresas` (
  `id_empresas` INT NOT NULL AUTO_INCREMENT,
  `cnpj_empresas` CHAR(14) NOT NULL,
  `ie_empresas` CHAR(9) NOT NULL,
  `cep_empresas` CHAR(8) NOT NULL,
  `criacao_empresas` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nome_empresas` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empresas`),
  UNIQUE INDEX `cnpj_empresas_UNIQUE` (`cnpj_empresas` ASC) VISIBLE,
  UNIQUE INDEX `ie_empresas_UNIQUE` (`ie_empresas` ASC) VISIBLE,
  UNIQUE INDEX `id_empresas_UNIQUE` (`id_empresas` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JOptionpaneDB`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JOptionpaneDB`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `JOptionpaneDB`.`funcionarios` (
  `id_funcionarios` INT NOT NULL AUTO_INCREMENT,
  `rg_funcionarios` CHAR(9) NOT NULL,
  `cpf_funcionarios` VARCHAR(45) NOT NULL,
  `nome_funcionarios` VARCHAR(45) NULL,
  `criacao_funcionarios` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empresas_id_empresas` INT NOT NULL,
  PRIMARY KEY (`id_funcionarios`),
  UNIQUE INDEX `rg_funcionarios_UNIQUE` (`rg_funcionarios` ASC) VISIBLE,
  UNIQUE INDEX `cpf_funcionarios_UNIQUE` (`cpf_funcionarios` ASC) VISIBLE,
  INDEX `fk_funcionarios_empresas_idx` (`empresas_id_empresas` ASC) VISIBLE,
  UNIQUE INDEX `id_funcionarios_UNIQUE` (`id_funcionarios` ASC) VISIBLE,
  CONSTRAINT `fk_funcionarios_empresas`
    FOREIGN KEY (`empresas_id_empresas`)
    REFERENCES `JOptionpaneDB`.`empresas` (`id_empresas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `JOptionpaneDB`.`enderecos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JOptionpaneDB`.`enderecos` ;

CREATE TABLE `enderecos` (
  `idenderecos` int NOT NULL AUTO_INCREMENT,
  `cep` char(8) DEFAULT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `uf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenderecos`),
  UNIQUE KEY `idceps_UNIQUE` (`idenderecos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `joptionpanedb`.`empresas`
(`id_empresas`,
`cnpj_empresas`,
`ie_empresas`,
`cep_empresas`,
`criacao_empresas`,
`nome_empresas`)
VALUES
(default,
"12345678901234",
"123456789",
"12345678",
default,
"Senac");

INSERT INTO `joptionpanedb`.`empresas`
(`id_empresas`,
`cnpj_empresas`,
`ie_empresas`,
`cep_empresas`,
`criacao_empresas`,
`nome_empresas`)
VALUES
(default,
"43210987654321",
"987654321",
"87654321",
default,
"Makenzie");


INSERT INTO `joptionpanedb`.`funcionarios`
(`id_funcionarios`,
`rg_funcionarios`,
`cpf_funcionarios`,
`nome_funcionarios`,
`criacao_funcionarios`,
`empresas_id_empresas`)
VALUES
(default,
"123456789",
"12345678901",
"marcos",
default,
1);

INSERT INTO `joptionpanedb`.`funcionarios`
(`id_funcionarios`,
`rg_funcionarios`,
`cpf_funcionarios`,
`nome_funcionarios`,
`criacao_funcionarios`,
`empresas_id_empresas`)
VALUES
(default,
"987654321",
"10987654321",
"thomas",
default,
1);

INSERT INTO `joptionpanedb`.`funcionarios`
(`id_funcionarios`,
`rg_funcionarios`,
`cpf_funcionarios`,
`nome_funcionarios`,
`criacao_funcionarios`,
`empresas_id_empresas`)
VALUES
(default,
"127345689",
"15623478901",
"ivometter",
default,
1);

INSERT INTO `joptionpanedb`.`funcionarios`
(`id_funcionarios`,
`rg_funcionarios`,
`cpf_funcionarios`,
`nome_funcionarios`,
`criacao_funcionarios`,
`empresas_id_empresas`)
VALUES
(default,
"678912345",
"12390145678",
"matulis",
default,
1);

