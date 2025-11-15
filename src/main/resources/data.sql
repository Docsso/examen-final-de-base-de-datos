CREATE TABLE proveedor ( id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100), contacto VARCHAR(100), telefono VARCHAR(20) );

  CREATE TABLE producto ( id_producto INT PRIMARY KEY AUTO_INCREMENT, nombre
  VARCHAR(100), descripcion VARCHAR(255), cantidad_actual INT,
  precio_unitario DECIMAL(10,2), id_proveedor INT, FOREIGN KEY (id_proveedor)
  REFERENCES proveedor(id_proveedor) );

  CREATE TABLE movimiento ( id_movimiento INT PRIMARY KEY AUTO_INCREMENT,
  tipo ENUM('ENTRADA','SALIDA'), fecha DATETIME, cantidad INT, id_producto
  INT, FOREIGN KEY (id_producto) REFERENCES producto(id_producto) );

  INSERT INTO proveedor(nombre,contacto,telefono) VALUES ('Proveedor A',
  'Maria Lopez', '555-1234'), ('Proveedor B', 'Carlos Diaz', '555-9876'),
  ('Proveedor C', 'Ana Perez', '555-7788');

  INSERT INTO
  producto(nombre,descripcion,cantidad_actual,precio_unitario,id_proveedor)
  VALUES ('Monitor 24”', 'Monitor de oficina', 10, 900.00, 1), ('Mouse
  Óptico', 'Mouse USB', 50, 45.00, 2), ('Teclado Mecánico', 'RGB', 20,
  350.00, 3);

  INSERT INTO movimiento(tipo,fecha,cantidad,id_producto) VALUES
  ('ENTRADA','2024-01-01 10:00:00',5,1), ('SALIDA','2024-01-02
  11:30:00',2,1), ('ENTRADA','2024-01-05 09:00:00',10,2),
  ('SALIDA','2024-01-06 15:00:00',3,2);