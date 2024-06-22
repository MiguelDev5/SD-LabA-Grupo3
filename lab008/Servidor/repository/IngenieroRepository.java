package com.ocho.miguel.repository;

import com.ocho.miguel.models.Ingeniero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngenieroRepository {
    private Connection connection;

    public IngenieroRepository(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void insertarIngeniero(Ingeniero ingeniero) throws SQLException {
        String query = "INSERT INTO Ingeniero (IDIng, Nombres, Apellidos, Especialidad, Cargo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ingeniero.getIdIng());
            ps.setString(2, ingeniero.getNombres());
            ps.setString(3, ingeniero.getApellidos());
            ps.setString(4, ingeniero.getEspecialidad());
            ps.setString(5, ingeniero.getCargo());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void actualizarIngeniero(Ingeniero ingeniero) throws SQLException {
        String query = "UPDATE Ingeniero SET Nombres = ?, Apellidos = ?, Especialidad = ?, Cargo = ? WHERE IdIng = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, ingeniero.getNombres());
            ps.setString(2, ingeniero.getApellidos());
            ps.setString(3, ingeniero.getEspecialidad());
            ps.setString(4, ingeniero.getCargo());
            ps.setInt(5, ingeniero.getIdIng());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminarIngeniero(int idIngeniero) throws SQLException {
        String query = "DELETE FROM Ingeniero WHERE IdIng = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idIngeniero);
            ps.executeUpdate();
        }
    }

    // GET ALL
    public List<Ingeniero> obtenerTodosIngenieros() throws SQLException {
        List<Ingeniero> ingenieros = new ArrayList<>();
        String query = "SELECT IDIng, Nombres, Apellidos, Especialidad, Cargo FROM Ingeniero";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("IdIng");
                    String nombres = rs.getString("Nombres");
                    String apellidos = rs.getString("Apellidos");
                    String especialidad = rs.getString("Especialidad");
                    String cargo = rs.getString("Cargo");
                    Ingeniero ingeniero = new Ingeniero(id, nombres, apellidos, especialidad, cargo);
                    ingenieros.add(ingeniero);
                }
            }
        }
        return ingenieros;
    }

    // GET BY INDEX
    public Ingeniero obtenerIngenieroPorId(int idIngeniero) throws SQLException {
        Ingeniero ingeniero = null;
        String query = "SELECT Nombres, Apellidos, Especialidad, Cargo FROM Ingeniero WHERE IDIng = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idIngeniero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombres = rs.getString("Nombres");
                    String apellidos = rs.getString("Apellidos");
                    String especialidad = rs.getString("Especialidad");
                    String cargo = rs.getString("Cargo");
                    ingeniero = new Ingeniero(idIngeniero, nombres, apellidos, especialidad, cargo);
                }
            }
        }
        return ingeniero;
    }
}
