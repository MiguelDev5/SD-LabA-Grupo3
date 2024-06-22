package com.ocho.miguel.services;

import org.springframework.web.bind.annotation.*;

import com.ocho.miguel.DBConnect;
import com.ocho.miguel.models.Departamento;
import com.ocho.miguel.repository.DepartamentoRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoService {

    @GetMapping("/get_all")
    public List<Departamento> getAllDepartments(){
        DBConnect dbConnect  = new DBConnect();

        List<Departamento> departamentos = null;
        try (Connection connection = dbConnect.getDBConnection()) {
            DepartamentoRepository departamentoRepo = new DepartamentoRepository(connection);
            departamentos = departamentoRepo.obtenerTodosDepartamentos();

        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return departamentos;
    }

    @PostMapping("/create")
    public Departamento createDepartment(@RequestBody Departamento departamento){
        DBConnect dbConnect  = new DBConnect();

        try (Connection connection = dbConnect.getDBConnection()) {
            DepartamentoRepository departamentoRepo = new DepartamentoRepository(connection);
            int newId = departamentoRepo.insertarDepartamento(departamento);
            departamento.setIdDpto(newId);
        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return departamento;
    }

    @PutMapping("/update")
    public Departamento updateDepartment(@RequestBody Departamento departamento){
        DBConnect dbConnect  = new DBConnect();
        Departamento departamentoExistente = null;

        try (Connection connection = dbConnect.getDBConnection()) {
            DepartamentoRepository departamentoRepo = new DepartamentoRepository(connection);
            departamentoExistente = departamentoRepo.obtenerDepartamentoPorId(departamento.getIdDpto());

            if (departamentoExistente != null) {
                departamentoExistente.setDescripcion(departamento.getDescripcion());
                departamentoExistente.setNombre(departamento.getNombre());
                departamentoExistente.setTelefono(departamento.getTelefono());
                departamentoExistente.setFax(departamento.getFax());
                departamentoRepo.actualizarDepartamento(departamentoExistente);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return departamentoExistente;
    }

    @DeleteMapping("/delete/{id}")
    public int deleteDepartment(@PathVariable("id") int idDpto){
        DBConnect dbConnect  = new DBConnect();

        try (Connection connection = dbConnect.getDBConnection()) {
            DepartamentoRepository departamentoRepo = new DepartamentoRepository(connection);
            departamentoRepo.eliminarDepartamento(idDpto);

        } catch (SQLException e) {
            System.out.println("Error de conexión o consulta SQL: " + e.getMessage());
        }
        return idDpto;
    }
}
