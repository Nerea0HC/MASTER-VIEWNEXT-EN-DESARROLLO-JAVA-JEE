CREATE SCHEMA IF NOT EXISTS bddhotel;
CREATE TABLE `bddhotel`.`hoteles` (
  `id_hotel` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `categoria` VARCHAR(45) NULL,
  `precio` DOUBLE NULL,
  `disponible` TINYINT NULL,
  PRIMARY KEY (`id_hotel`));

CREATE SCHEMA IF NOT EXISTS bddvuelo;
CREATE TABLE `bddvuelo`.`vuelos` (
  `id_vuelo` INT NOT NULL AUTO_INCREMENT,
  `compania` VARCHAR(45) NULL,
  `fecha_vuelo` DATE NULL,
  `precio` DOUBLE NULL,
  `plazas_disponibles` INT NULL,
  PRIMARY KEY (`id_vuelo`));

CREATE SCHEMA IF NOT EXISTS bddreservas;
CREATE TABLE `bddreservas`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NULL,
  `id_hotel` INT NULL,
  `id_vuelo` INT NULL,
  PRIMARY KEY (`id_reserva`),
  INDEX `id_hotel_idx` (`id_hotel` ASC) VISIBLE,
  INDEX `id_vuelo_idx` (`id_vuelo` ASC) VISIBLE,
  CONSTRAINT `id_hotel`
    FOREIGN KEY (`id_hotel`)
    REFERENCES `bddhotel`.`hoteles` (`id_hotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_vuelo`
    FOREIGN KEY (`id_vuelo`)
    REFERENCES `bddvuelo`.`vuelos` (`id_vuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    ALTER TABLE `bddreservas`.`reservas` 
ADD COLUMN `personas` INT NULL AFTER `id_vuelo`;