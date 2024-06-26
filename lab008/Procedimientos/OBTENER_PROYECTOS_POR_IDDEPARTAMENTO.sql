CREATE PROCEDURE OBTENER_PROYECTOS_POR_IDDEPARTAMENTO(IN ID_DPTO INT)
BEGIN
    SELECT 
        p.Nombre            AS 'Nombre del proyecto',
        p.Descripcion       AS 'Descripción',
        p.FecInicio         AS 'Fecha de inicio',
        p.FecTermino        AS 'Fecha de finalización',
        d.IDDpto	        AS 'Nombre Ing.',
        d.Nombre		    AS 'Especialidad Ing.',
    FROM proyecto AS p 
    JOIN departamento AS d ON d.IDDpto = p.FIDDpto
    WHERE p.FIDDpto = ID_DPTO;
END