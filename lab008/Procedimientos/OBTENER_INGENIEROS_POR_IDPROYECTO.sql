CREATE PROCEDURE OBTENER_INGENIEROS_POR_IDPROYECTO(IN ID_PROY INT)
BEGIN
    SELECT 
        p.Nombre            AS 'Nombre',
        p.Descripcion       AS 'Descripcion',
        p.FecInicio         AS 'FecInicio',
        p.FecTermino        AS 'FecTermino',
        i.Nombres           AS 'NombreIng.',
        i.Especialidad      AS 'EspecialidadIng.',
        i.Cargo             AS 'CargoIng.'
    FROM proyecto AS p 
    JOIN asignacion AS a ON a.FIDProy = p.IDProy
    JOIN ingeniero AS i ON i.IDIng = a.FIDIng
    WHERE p.IDProy = ID_PROY;
END