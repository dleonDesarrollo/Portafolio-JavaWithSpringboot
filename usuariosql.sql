CREATE TABLE usu_ario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR (100) NOT NULL,
    run INT NOT NULL,
    fecha_nac DATE NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_usuario)
);
/* INSERT DE DATOS*/
INSERT INTO usu_ario (nombre, run, fecha_nac)
values  ("Luis", 17809765 , "1991-12-25"),
		("Ana", 17633256, "1990-05-24"),
		("Claudia", 16980090, "1992-01-01"),
		("Raúl", 18123556, "1991-05-05"),
		("Mirta", 19863527,"1994-04-17");