package com.ocho.miguel.services;

import com.ocho.miguel.DBConnect;
import com.ocho.miguel.models.Ingeniero;
import com.ocho.miguel.repository.IngenieroRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/ingeniero")
public class IngenieroService {

    @GetMapping("/get_all")
    public List<Ingeniero> getAllIngenieros(){
        DBConnect dbConnect  = new DBConnect();

        List<Ingeniero> ingenieros = null;
        try (Connection connection = dbConnect.getDBConnection()) {
            IngenieroRepository ingenieroRepo = new IngenieroRepository(connection);
            ingenieros = ingenieroRepo.obtenerTodosIngenieros();

        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return ingenieros;
    }

    @PostMapping("/create")
    public Ingeniero createDepartment(@RequestBody Ingeniero ingeniero){
        DBConnect dbConnect  = new DBConnect();

        try (Connection connection = dbConnect.getDBConnection()) {
            IngenieroRepository ingenieroRepo = new IngenieroRepository(connection);
            ingenieroRepo.insertarIngeniero(ingeniero);

        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return ingeniero;
    }

    @PutMapping("/update")
    public Ingeniero updateDepartment(@RequestBody Ingeniero ingeniero){
        DBConnect dbConnect  = new DBConnect();
        Ingeniero ingenieroExistente = null;

        try (Connection connection = dbConnect.getDBConnection()) {
            IngenieroRepository ingenieroRepo = new IngenieroRepository(connection);
            ingenieroExistente = ingenieroRepo.obtenerIngenieroPorId(ingeniero.getIdIng());

            if (ingenieroExistente != null) {
                ingenieroExistente.setNombres(ingeniero.getNombres());
                ingenieroExistente.setApellidos(ingeniero.getApellidos());
                ingenieroExistente.setEspecialidad(ingeniero.getEspecialidad());
                ingenieroExistente.setCargo(ingeniero.getCargo());
                ingenieroRepo.actualizarIngeniero(ingenieroExistente);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return ingenieroExistente;
    }

    @DeleteMapping("/delete/{id}")
    public int deleteDepartment(@PathVariable("id") int idDpto){
        DBConnect dbConnect  = new DBConnect();

        try (Connection connection = dbConnect.getDBConnection()) {
            IngenieroRepository ingenieroRepo = new IngenieroRepository(connection);
            ingenieroRepo.eliminarIngeniero(idDpto);

        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return idDpto;
    }
}
