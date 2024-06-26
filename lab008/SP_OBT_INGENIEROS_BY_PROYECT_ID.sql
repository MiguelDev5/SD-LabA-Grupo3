CREATE PROCEDURE OBTENER_INGENIEROS_POR_IDPROYECTO(IN ID_PROY INT)
BEGIN
    SELECT 
        p.Nombre            AS 'Nombre del proyecto',
        p.Descripcion       AS 'Descripción',
        p.FecInicio         AS 'Fecha de inicio',
        p.FecTermino        AS 'Fecha de finalización',
        i.Nombres           AS 'Nombre Ing.',
        i.Especialidad      AS 'Especialidad Ing.',
        i.Cargo             AS 'Cargo Ing.'
    FROM proyecto AS p 
    JOIN asignacion AS a ON a.FIDProy = p.IDProy
    JOIN ingeniero AS i ON i.IDIng = a.FIDIng
    WHERE p.IDProy = ID_PROY;
END