import 'package:http/http.dart' as http;
import 'package:front08/models/departamento.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'dart:convert';

class DepartamentoNotifier extends StateNotifier<List<Departamento>> {
  DepartamentoNotifier() : super([]) {
    fetchDepartamentos();
  }

  Future<void>  fetchDepartamentos() async {
    const url = 'http://localhost:8080/departamento/get_all';
    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        final List<dynamic> jsonData = json.decode(response.body);
        state = jsonData.map((item) => Departamento.fromJson(item)).toList();
      }
    } catch (e) {
      // Manejo de errores
    }
  }

  Future<void>  createDepartamentos(Departamento dept) async {
    const url = 'http://localhost:8080/departamento/create';
    try {
      final response = await http.post(
        Uri.parse(url),
        headers: <String, String>{'Content-Type': 'application/json; charset=UTF-8'},
        body: jsonEncode(dept.toJson()),
      );

      if (response.statusCode == 200) {
        final dynamic jsonData = json.decode(response.body);
        state = [...state, Departamento.fromJson(jsonData)];
      }
    } catch (e) {
      // Manejo de errores
    }
  }

  Future<void> deleteDepartamento(int? id) async {
    final url = 'http://localhost:8080/departamento/delete/$id';
    try {
      final response = await http.delete(Uri.parse(url));

      if (response.statusCode == 200) {
        state = state.where((departamento) => departamento.id != id).toList();
      }
    } catch (e) {
      // Manejo de errores
    }
  }
}