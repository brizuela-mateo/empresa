-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema empresa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `empresa` ;

-- -----------------------------------------------------
-- Table `empresa`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`categoria` (
                                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `nombre` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `empresa`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`usuario` (
                                                   `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                   `nombre` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 25
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `empresa`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`pedido` (
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `usuario_id` BIGINT NULL DEFAULT NULL,
                                                  `fecha_pedido` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                                                  `total` DECIMAL(10,2) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `usuario_id` (`usuario_id` ASC) VISIBLE,
    CONSTRAINT `pedido_ibfk_1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `empresa`.`usuario` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `empresa`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`producto` (
                                                    `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                    `nombre` VARCHAR(255) NOT NULL,
    `descripcion` TEXT NULL DEFAULT NULL,
    `precio` DECIMAL(10,2) NOT NULL,
    `categoria_id` BIGINT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `categoria_id` (`categoria_id` ASC) VISIBLE,
    CONSTRAINT `producto_ibfk_1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `empresa`.`categoria` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `empresa`.`detalle_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`detalle_pedido` (
                                                          `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                          `pedido_id` BIGINT NULL DEFAULT NULL,
                                                          `producto_id` BIGINT NULL DEFAULT NULL,
                                                          `cantidad` INT NOT NULL,
                                                          `subtotal` DECIMAL(10,2) NULL DEFAULT NULL,
    `estado` VARCHAR(10) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `pedido_id` (`pedido_id` ASC) VISIBLE,
    INDEX `producto_id` (`producto_id` ASC) VISIBLE,
    CONSTRAINT `detalle_pedido_ibfk_1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `empresa`.`pedido` (`id`),
    CONSTRAINT `detalle_pedido_ibfk_2`
    FOREIGN KEY (`producto_id`)
    REFERENCES `empresa`.`producto` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `empresa`.`resena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`resena` (
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `usuario_id` BIGINT NULL DEFAULT NULL,
                                                  `producto_id` BIGINT NULL DEFAULT NULL,
                                                  `comentario` TEXT NULL DEFAULT NULL,
                                                  `calificacion` INT NULL DEFAULT NULL,
                                                  PRIMARY KEY (`id`),
    INDEX `usuario_id` (`usuario_id` ASC) VISIBLE,
    INDEX `producto_id` (`producto_id` ASC) VISIBLE,
    CONSTRAINT `resena_ibfk_1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `empresa`.`usuario` (`id`),
    CONSTRAINT `resena_ibfk_2`
    FOREIGN KEY (`producto_id`)
    REFERENCES `empresa`.`producto` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 7
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
