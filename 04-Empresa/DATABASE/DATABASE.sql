CREATE DATABASE `04-empresa`;
USE `04-empresa`;
CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    nombre VARCHAR(50),        
    apellido1 VARCHAR(50),    
    apellido2 VARCHAR(50),             
    fecha_nacimiento DATETIME, 
    salario DECIMAL(10, 2)
);
