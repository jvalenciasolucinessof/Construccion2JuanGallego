-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 12-03-2024 a las 18:37:27
-- Versión del servidor: 8.2.0
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinary`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mascota` int NOT NULL,
  `propietario` bigint NOT NULL,
  `producto` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `valor` double NOT NULL,
  `cantidad` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `factura_mascota` (`mascota`),
  KEY `factura_propietario` (`propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `mascota`, `propietario`, `producto`, `valor`, `cantidad`, `fecha`) VALUES
(1, 10, 4567, 'asvcdasd', 22, 12, '2024-03-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia`
--

DROP TABLE IF EXISTS `historia`;
CREATE TABLE IF NOT EXISTS `historia` (
  `fecha` bigint NOT NULL,
  `mascota` int NOT NULL,
  `medico` bigint NOT NULL,
  `motivo` text COLLATE utf8mb4_general_ci NOT NULL,
  `sintomatologia` text COLLATE utf8mb4_general_ci NOT NULL,
  `procedimiento` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `medicamento` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `orden` int DEFAULT NULL,
  `vacunacion` text COLLATE utf8mb4_general_ci NOT NULL,
  `alergia` text COLLATE utf8mb4_general_ci NOT NULL,
  `detalles_procedimiento` text COLLATE utf8mb4_general_ci NOT NULL,
  `diagnosis` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `medicationDosage` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `ordercancelation` tinyint(1) NOT NULL,
  PRIMARY KEY (`fecha`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historia`
--

INSERT INTO `historia` (`fecha`, `mascota`, `medico`, `motivo`, `sintomatologia`, `procedimiento`, `medicamento`, `orden`, `vacunacion`, `alergia`, `detalles_procedimiento`, `diagnosis`, `medicationDosage`, `ordercancelation`) VALUES
(1710206024015, 10, 12345, 'asdzgfhjk,h', 'EAWSRTDFHJB,M', 'N/A', 'adfsgdhfjgk', 14, 'N/A', 'N/A', 'SADFGHJBM', 'aersztdxyfcjh', 'ASDHGFJH', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

DROP TABLE IF EXISTS `mascota`;
CREATE TABLE IF NOT EXISTS `mascota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `propietario` bigint NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int NOT NULL,
  `peso` double NOT NULL,
  `raza` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `especie` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `caracteristicas` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `propietario` (`propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id`, `propietario`, `nombre`, `edad`, `peso`, `raza`, `especie`, `caracteristicas`) VALUES
(9, 4567, 'Lukas', 2, 5, 'cocker', 'Perro', 'rojo 1.30'),
(10, 4567, 'pako', 12, 6, 'nose', 'Gato', 'verde 130');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

DROP TABLE IF EXISTS `orden`;
CREATE TABLE IF NOT EXISTS `orden` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mascota` int NOT NULL,
  `propietario` bigint NOT NULL,
  `medico` bigint NOT NULL,
  `medicamento` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orden_mascota` (`mascota`),
  KEY `orden_propietario` (`propietario`),
  KEY `orden_veterinario` (`medico`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`id`, `mascota`, `propietario`, `medico`, `medicamento`, `fecha`) VALUES
(13, 10, 4567, 12345, 'ASDFSGFDVC - afdsv', '2024-03-11 00:00:00'),
(14, 10, 4567, 12345, 'adfsgdhfjgk - ASDHGFJH', '2024-03-11 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `cedula` bigint NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int NOT NULL,
  `rol` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `edad`, `rol`, `username`, `password`) VALUES
(123, 'Juan', 21, 'Admin', 'juan', '123'),
(767, 'Fran', 66, 'Owner', 'N/A', 'N/A'),
(3456, 'Vendedor', 25, 'Seller', 'pedro', '123'),
(4567, 'Paco', 82, 'Owner', 'N/A', 'N/A'),
(12345, 'pepito', 12, 'Vet', 'pep', '999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

DROP TABLE IF EXISTS `sesion`;
CREATE TABLE IF NOT EXISTS `sesion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `username`, `role`) VALUES
(44, 'pep', 'Vet'),
(45, 'pep', 'Vet'),
(46, 'pep', 'Vet'),
(47, 'pep', 'Vet'),
(48, 'pep', 'Vet'),
(49, 'pep', 'Vet'),
(50, 'pep', 'Vet'),
(51, 'pep', 'Vet'),
(52, 'pep', 'Vet'),
(53, 'pep', 'Vet'),
(54, 'pep', 'Vet'),
(55, 'pep', 'Vet'),
(58, 'pep', 'Vet'),
(62, 'pedro', 'Seller');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_mascota` FOREIGN KEY (`mascota`) REFERENCES `mascota` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_propietario` FOREIGN KEY (`propietario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orden_veterinario` FOREIGN KEY (`medico`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
