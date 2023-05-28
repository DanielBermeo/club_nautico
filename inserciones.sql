USE club_nautico;
INSERT INTO amarres (num_amarres, fecha_registro, cuota, disponibilidad) VALUES
(101, '2023-05-25', 1000.00, true),
(102, '2023-05-25', 1500.00, true),
(103, '2023-05-25', 2000.00, true),
(104, '2023-05-25', 1750.00, true),
(105, '2023-05-25', 1200.00, true),
(106, '2023-05-25', 900.00, true),
(107, '2023-05-25', 1800.00, true),
(108, '2023-05-25', 2500.00, true),
(109, '2023-05-25', 3000.00, true),
(110, '2023-05-25', 1250.00, true),
(111, '2023-05-25', 17500.00, true),
(112, '2023-05-25', 2200.00, true),
(113, '2023-05-25', 1900.00, true),
(114, '2023-05-25', 2300.00, true),
(115, '2023-05-25', 1400.00, true),
(116, '2023-05-25', 1950.00, true),
(117, '2023-05-25', 2750.00, true),
(118, '2023-05-25', 3200.00, true),
(119, '2023-05-25', 1350.00, true),
(120, '2023-05-25', 1850.00, true);

INSERT INTO contactos (nombre, ap_paterno, ap_materno, telefono, email) VALUES
('Juan', 'López', 'García', '5572901234', 'juanlopez@gmail.com'),
('María', 'Gómez', 'Fernández', '5523412345', 'mariagomez@outlook.com'),
('Carlos', 'Rodríguez', 'Martínez', '8867823456', 'carlosr@gmail.com'),
('Laura', 'Hernández', 'Pérez', '7745634567', 'laurah@outlook.com'),
('Pedro', 'Torres', 'López', '5590845678', 'pedrol@gmail.com'),
('Ana', 'Sánchez', 'González', '5567356789', 'anas@outlook.com'),
('Luis', 'Ramírez', 'Jiménez', '5567367890', 'luisr@gmail.com'),
('Marta', 'Vargas', 'Castillo', '5590878901', 'martav@hotmail.com'),
('Fernando', 'Díaz', 'Rojas', '5567489012', 'fernandod@gmail.com'),
('Sofía', 'Guerrero', 'Silva', '5593901238', 'sofiags@hotmail.com'),
('Diego', 'Mendoza', 'Navarro', '5534501234', 'diegom@yahoo.com'),
('Isabel', 'Castro', 'Luna', '5565412345', 'isabelcl@yahoo.com'),
('Javier', 'Ríos', 'Ortega', '5576523456', 'javierr@gmail.com'),
('Carolina', 'Núñez', 'Vega', '8876534567', 'carolinan@yahoo.com'),
('Andrés', 'Fuentes', 'Soto', '7734245678', 'andresf@hotmail.com'),
('Daniela', 'Paz', 'Cortés', '5587656789', 'danielap@yahoo.com'),
('Roberto', 'Solís', 'Miranda', '7723167890', 'robertos@gmail.com'),
('Patricia', 'Lara', 'Olivares', '5534178901', 'patricial@hotmail.com'),
('Mario', 'Mejía', 'López', '9987890123', 'mariom@yahoo.com'),
('Elena', 'Paredes', 'Ruiz', '5512990123', 'elenapr@gmail.com');

INSERT INTO socios(id_cto) VALUES
(2),
(5),
(9),
(12),
(15),
(17),
(20);

INSERT INTO patrones(id_sco, id_cto) VALUES
(1, 1),
(2, 3),
(3, 5),
(4, 7),
(5, 13),
(6, 15),
(7, 19);

INSERT INTO duenos(id_cto) VALUES
(2),
(3),
(5),
(6),
(8),
(9),
(12),
(13),
(18),
(20);

INSERT INTO barcos (num_matricula, nombre, id_ptn, id_dno) VALUES
('1234', 'Thousand Sunny', 2, 5),
('5678', 'Going Merry', 3, 9),
('9101', 'Saber of Xebec', 1, 8),
('2345', 'Red Force', 4, 3),
('6789', 'Oro Jackson', 7, 6),
('1020', 'Queen Mama Chanter', 5, 1),
('3456', 'Moby Dick', 6, 7),
('7890', 'Flying Dutchman', 7, 2),
('1122', 'Striker', 1, 10),
('4546', 'Thriller Bark', 7, 5),
('7889', 'Kaido\'s Battleship', 2, 4),
('7878', 'Noah', 6, 10),
('2323', 'Shark Submerge III', 3, 1),
('8787', 'Rocket Man', 5, 2),
('5675', 'Sexy Foxy', 4, 6),
('9977', 'Shiro Mokuba I', 1, 3),
('6655', 'Shiro Mokuba II', 3, 7),
('3221', 'Shiro Mokuba III', 7, 9),
('3366', 'Polar Tang', 2, 10),
('4411', 'Snapper Head', 6, 4);

-- Insertar registros en la tabla "salidas"
INSERT INTO salidas (fecha_salida, destino, num_mta) VALUES
('2023-01-01', 'Isla de los Condenados', '1234'),
('2023-02-15', 'Arabasta', '5678'),
('2023-03-10', 'Enies Lobby', '9101'),
('2023-04-22', 'Water 7', '2345'),
('2023-05-05', 'Fishman Island', '6789'),
('2023-06-20', 'Skypiea', '1020'),
('2023-07-12', 'Marineford', '3456'),
('2023-08-28', 'Thriller Bark', '7890'),
('2023-09-10', 'Wano', '1122'),
('2023-10-18', 'Dressrosa', '4546'),
('2023-11-11', 'Zou', '7889'),
('2023-12-25', 'Punk Hazard', '7878'),
('2024-01-07', 'Amazon Lily', '2323'),
('2024-02-19', 'Alabasta', '8787'),
('2024-03-15', 'Sabaody', '5675'),
('2024-04-30', 'Skypiea', '9977'),
('2024-05-10', 'Punk Hazard', '6655'),
('2024-06-22', 'Whole Cake Island', '3221'),
('2024-07-18', 'Dressrosa', '3366'),
('2024-08-30', 'Fishman Island', '4411');

INSERT INTO entradas (fecha_llegada, num_ams, num_mta) VALUES
('2023-01-01', 101, '1234'),
('2023-02-15', 102, '5678'),
('2023-03-10', 103, '9101'),
('2023-04-22', 104, '2345'),
('2023-05-05', 105, '6789'),
('2023-06-20', 106, '1020'),
('2023-07-12', 107, '3456'),
('2023-08-28', 108, '7890'),
('2023-09-10', 109, '1122'),
('2023-10-18', 110, '4546'),
('2023-11-11', 111, '7889'),
('2023-12-25', 112, '7878'),
('2024-01-07', 113, '2323'),
('2024-02-19', 114, '8787'),
('2024-03-15', 115, '5675'),
('2024-04-30', 116, '9977'),
('2024-05-10', 117, '6655'),
('2024-06-22', 118, '3221'),
('2024-07-18', 119, '3366'),
('2024-08-30', 120, '4411');



