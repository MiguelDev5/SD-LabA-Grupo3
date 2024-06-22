package com.ocho.miguel.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ocho.miguel.models.Departamento;

public class DepartamentoRepository {
    private Connection connection;

    public DepartamentoRepository(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public int insertarDepartamento(Departamento departamento) throws SQLException {
        String query = "INSERT INTO Departamento (Nombre, Descripcion, Telefono, Fax) VALUES ( ?, ?, ?, ?)";
        int generatedId = 0;

        try (PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, departamento.getNombre());
            ps.setString(2, departamento.getDescripcion());
            ps.setString(3, departamento.getTelefono());
            ps.setString(4, departamento.getFax());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }
        }
        return generatedId;
    }

    // UPDATE
    public void actualizarDepartamento(Departamento departamento) throws SQLException {
        String query = "UPDATE Departamento SET Nombre = ?, Descripcion = ?, Telefono = ?, Fax = ? WHERE IDDpto = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, departamento.getNombre());
            ps.setString(2, departamento.getDescripcion());
            ps.setString(3, departamento.getTelefono());
            ps.setString(4, departamento.getFax());
            ps.setInt(5, departamento.getIdDpto());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminarDepartamento(int idDepartamento) throws SQLException {
        String query = "DELETE FROM Departamento WHERE IDDpto = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idDepartamento);
            ps.executeUpdate();
        }
    }

    // GET ALL
    public List<Departamento> obtenerTodosDepartamentos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String query = "SELECT IDDpto, Nombre, Descripcion, Telefono, Fax FROM Departamento";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("IDDpto");
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    String telefono = rs.getString("Telefono");
                    String fax = rs.getString("Fax");
                    Departamento departamento = new Departamento(id, nombre, descripcion, telefono, fax);
                    departamentos.add(departamento);
                }
            }
        }
        return departamentos;
    }

    // GET BY INDEX
    public Departamento obtenerDepartamentoPorId(int idDepartamento) throws SQLException {
        Departamento departamento = null;
        String query = "SELECT Nombre, Descripcion, Telefono, Fax FROM Departamento WHERE IDDpto = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idDepartamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    String telefono = rs.getString("Telefono");
                    String fax = rs.getString("Fax");
                    departamento = new Departamento(idDepartamento, nombre, descripcion, telefono, fax);
                }
            }
        }
        return departamento;
    }
}