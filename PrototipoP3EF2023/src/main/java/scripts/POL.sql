-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2020 a las 07:19:11
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_polideportivo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campeonato`
--

CREATE TABLE `campeonato` (
  `ID_CAMPEONATO` int(11) NOT NULL,
  `NOMBRE_CAMPEONATO` varchar(60) DEFAULT NULL,
  `CANTIDAD_EQUIPOS` int(11) DEFAULT NULL,
  `ID_SEDE_POLI_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_partido`
--

CREATE TABLE `detalle_partido` (
  `ID_PARTIDO` int(11) NOT NULL,
  `ID_CAMPEONATO_FK` int(11) NOT NULL,
  `FECHA_PARTIDO` datetime DEFAULT NULL,
  `ID_LOCAL` int(11) NOT NULL,
  `ID_VISITANTE` int(11) NOT NULL,
  `MARCADOR` varchar(9) DEFAULT NULL,
  `ID_MEJOR_JUGADOR_FK` int(11) NOT NULL,
  `FALTAS` varchar(45) DEFAULT NULL,
  `ID_ESTADO_PARTIDO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID_EMPLEADO` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `CORREO` varchar(60) DEFAULT NULL,
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `DIRECCION` varchar(100) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `NIT` varchar(30) DEFAULT NULL,
  `DPI` varchar(20) DEFAULT NULL,
  `ID_USUARIO_FK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID_EMPLEADO`, `NOMBRE1`, `NOMBRE2`, `APELLIDO1`, `APELLIDO2`, `CORREO`, `ID_TIPO_PUESTO`, `DIRECCION`, `FECHA_NACIMIENTO`, `NIT`, `DPI`, `ID_USUARIO_FK`) VALUES
(0, 'Mario', 'Raul', 'Lopez', 'Sierra', 'falso@gmail.com', 0, 'CIUDAD', '0000-00-00', '45874154', '4856214785', 'Trey'),
(1, 'asdq', 'qwesad', 'qwerf', 'asdf', 'falso@gmail.com', 2, 'ciudad', '1997-02-05', '2459741-5', '147854620101', 'A'),
(2, 'Luis', 'Eduardo', 'Lopez', 'Obrador', 'System.Windows.Forms.TextBox, Text: real@gmail.com', 2, 'System.Windows.Forms.TextBox, Text: CIUDAD', '0000-00-00', '2458741-5', '257413250101', 'caster');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_ENTRENADOR` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_USUARIO_FK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `ID_EQUIPO` int(11) NOT NULL,
  `NOMBRE_EQUIPO` varchar(50) DEFAULT NULL,
  `ID_ENTRENADOR_FK` int(11) NOT NULL,
  `ID_TIPO_DEPORTE__FK` int(11) NOT NULL,
  `TORNEOS_GANADOS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_partido`
--

CREATE TABLE `estado_partido` (
  `ID_ESTADO` int(11) NOT NULL,
  `NOMBRE_ESTADO` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `ID_JUGADOR` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_EQUIPO_FK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede_polideportivo`
--

CREATE TABLE `sede_polideportivo` (
  `ID_SEDE` int(11) NOT NULL,
  `NOMBRE_SEDE` varchar(100) DEFAULT NULL,
  `CAPACIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono`
--

CREATE TABLE `telefono` (
  `ID_TELEFONO` int(11) NOT NULL,
  `ID_EMPLEADO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `telefono`
--

INSERT INTO `telefono` (`ID_TELEFONO`, `ID_EMPLEADO_FK`) VALUES
(24579632, 0),
(24857415, 0),
(0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_deporte`
--

CREATE TABLE `tipo_deporte` (
  `ID_TIPO_DEPORTE` int(11) NOT NULL,
  `NOMBRE_DEPORTE` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_puesto`
--

CREATE TABLE `tipo_puesto` (
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `NOMBRE_PUESTO` varchar(60) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_puesto`
--

INSERT INTO `tipo_puesto` (`ID_TIPO_PUESTO`, `NOMBRE_PUESTO`, `SALARIO`) VALUES
(0, 'Jefe', 14000),
(1, 'Jefe Ventas', 14587),
(2, 'Jefe Compras', 25147),
(3, 'Gerencia', 25412),
(4, 'Admin', 15478);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `ID_TIPO_USUARIO` int(11) NOT NULL,
  `NOMBRE_TIPO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`ID_TIPO_USUARIO`, `NOMBRE_TIPO`) VALUES
(1, 'Administrador'),
(2, 'Entrenador'),
(3, 'Gerencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `ID_TIPO_USUARIO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `PASSWORD`, `ID_TIPO_USUARIO_FK`) VALUES
('A', '88', 1),
('caster', '12345', 2),
('Man', '88', 1),
('Tefa21', '100', 3),
('Trey', '3', 3),
('Yisus', '123', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `campeonato`
--
ALTER TABLE `campeonato`
  ADD PRIMARY KEY (`ID_CAMPEONATO`),
  ADD KEY `FK_SEDE` (`ID_SEDE_POLI_FK`);

--
-- Indices de la tabla `detalle_partido`
--
ALTER TABLE `detalle_partido`
  ADD PRIMARY KEY (`ID_PARTIDO`),
  ADD KEY `FK_CAMPEONATO` (`ID_CAMPEONATO_FK`),
  ADD KEY `FK_ESTADO_PARTIDO` (`ID_ESTADO_PARTIDO_FK`),
  ADD KEY `FK_EQUIPO_LOCAL` (`ID_LOCAL`),
  ADD KEY `FK_EQUIPO_VISITANTE` (`ID_VISITANTE`),
  ADD KEY `FK_JUGADOR` (`ID_MEJOR_JUGADOR_FK`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID_EMPLEADO`),
  ADD KEY `FK_TIPO_PUESTO` (`ID_TIPO_PUESTO`),
  ADD KEY `FK_USUARIO` (`ID_USUARIO_FK`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_ENTRENADOR`),
  ADD KEY `FK_USUARIO_ENTRENADOR` (`ID_USUARIO_FK`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`ID_EQUIPO`),
  ADD KEY `FK_ENTRENADOR` (`ID_ENTRENADOR_FK`),
  ADD KEY `FK_TIPO_DEPORTE` (`ID_TIPO_DEPORTE__FK`);

--
-- Indices de la tabla `estado_partido`
--
ALTER TABLE `estado_partido`
  ADD PRIMARY KEY (`ID_ESTADO`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`ID_JUGADOR`);

--
-- Indices de la tabla `sede_polideportivo`
--
ALTER TABLE `sede_polideportivo`
  ADD PRIMARY KEY (`ID_SEDE`);

--
-- Indices de la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD PRIMARY KEY (`ID_TELEFONO`),
  ADD KEY `FK_EMPLEADO` (`ID_EMPLEADO_FK`);

--
-- Indices de la tabla `tipo_deporte`
--
ALTER TABLE `tipo_deporte`
  ADD PRIMARY KEY (`ID_TIPO_DEPORTE`);

--
-- Indices de la tabla `tipo_puesto`
--
ALTER TABLE `tipo_puesto`
  ADD PRIMARY KEY (`ID_TIPO_PUESTO`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`ID_TIPO_USUARIO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `FK_TIPO_USUARIO` (`ID_TIPO_USUARIO_FK`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `campeonato`
--
ALTER TABLE `campeonato`
  ADD CONSTRAINT `FK_SEDE` FOREIGN KEY (`ID_SEDE_POLI_FK`) REFERENCES `sede_polideportivo` (`ID_SEDE`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_partido`
--
ALTER TABLE `detalle_partido`
  ADD CONSTRAINT `FK_CAMPEONATO` FOREIGN KEY (`ID_CAMPEONATO_FK`) REFERENCES `campeonato` (`ID_CAMPEONATO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_EQUIPO_LOCAL` FOREIGN KEY (`ID_LOCAL`) REFERENCES `equipo` (`ID_EQUIPO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_EQUIPO_VISITANTE` FOREIGN KEY (`ID_VISITANTE`) REFERENCES `equipo` (`ID_EQUIPO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ESTADO_PARTIDO` FOREIGN KEY (`ID_ESTADO_PARTIDO_FK`) REFERENCES `estado_partido` (`ID_ESTADO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_JUGADOR` FOREIGN KEY (`ID_MEJOR_JUGADOR_FK`) REFERENCES `jugador` (`ID_JUGADOR`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_TIPO_PUESTO` FOREIGN KEY (`ID_TIPO_PUESTO`) REFERENCES `tipo_puesto` (`ID_TIPO_PUESTO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USUARIO` FOREIGN KEY (`ID_USUARIO_FK`) REFERENCES `usuario` (`ID_USUARIO`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD CONSTRAINT `FK_USUARIO_ENTRENADOR` FOREIGN KEY (`ID_USUARIO_FK`) REFERENCES `usuario` (`ID_USUARIO`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `FK_ENTRENADOR` FOREIGN KEY (`ID_ENTRENADOR_FK`) REFERENCES `entrenador` (`ID_ENTRENADOR`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TIPO_DEPORTE` FOREIGN KEY (`ID_TIPO_DEPORTE__FK`) REFERENCES `tipo_deporte` (`ID_TIPO_DEPORTE`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD CONSTRAINT `FK_EMPLEADO` FOREIGN KEY (`ID_EMPLEADO_FK`) REFERENCES `empleado` (`ID_EMPLEADO`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_TIPO_USUARIO` FOREIGN KEY (`ID_TIPO_USUARIO_FK`) REFERENCES `tipo_usuario` (`ID_TIPO_USUARIO`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
