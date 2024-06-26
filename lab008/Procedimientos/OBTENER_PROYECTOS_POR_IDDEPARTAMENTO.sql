CREATE PROCEDURE OBTENER_PROYECTOS_POR_IDDEPARTAMENTO(IN ID_DPTO INT)
BEGIN
    SELECT 
        p.Nombre            AS 'Nombre',
        p.Descripcion       AS 'Descripcion',
        p.FecInicio         AS 'FecInicio',
        p.FecTermino        AS 'FecTermino',
        d.IDDpto	        AS 'IDDpto',
        d.Nombre		    AS 'Departamento'
    FROM proyecto AS p 
    JOIN departamento AS d ON d.IDDpto = p.FIDDpto
    WHERE p.FIDDpto = ID_DPTO;
END