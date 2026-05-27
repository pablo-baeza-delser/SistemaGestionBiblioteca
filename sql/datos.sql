USE biblioteca;

INSERT INTO libros (titulo, autor, genero, disponible) VALUES
('El Quijote', 'Miguel de Cervantes', 'Clásico', true),
('1984', 'George Orwell', 'Distopía', true),
('El Hobbit', 'J.R.R. Tolkien', 'Fantasía', true),
('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', true),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', true),
('El señor de los anillos', 'J.R.R. Tolkien', 'Fantasía', false),
('Crimen y castigo', 'Fiódor Dostoyevski', 'Novela psicológica', true),
('La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio', false),
('El nombre de la rosa', 'Umberto Eco', 'Histórica', true),
('Sapiens', 'Yuval Noah Harari', 'No ficción', true);

INSERT INTO usuarios (nombre, email) VALUES
('Juan García', 'juan@email.com'),
('María López', 'maria@email.com'),
('Carlos Ruiz', 'carlos@email.com'),
('Ana Martínez', 'ana@email.com'),
('Pedro Sánchez', 'pedro@email.com');

INSERT INTO prestamos (id_libro, id_usuario, fecha_prestamo, fecha_devolucion) VALUES
(6, 1, '2025-01-10', '2025-01-25'),
(8, 2, '2025-02-05', NULL),
(1, 3, '2025-02-10', '2025-02-20'),
(3, 4, '2025-03-01', NULL),
(5, 5, '2025-03-15', '2025-03-30'),
(2, 1, '2025-04-01', NULL),
(7, 2, '2025-04-10', '2025-04-20'),
(4, 3, '2025-05-01', NULL);