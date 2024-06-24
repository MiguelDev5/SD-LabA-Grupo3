import 'package:http/http.dart' as http;
import 'package:front08/models/ingeniero.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'dart:convert';

class IngenieroNotifier extends StateNotifier<List<Ingeniero>> {
  IngenieroNotifier() : super([]) {
    fetchIngenieros();
  }

  Future<void>  fetchIngenieros() async {
    const url = 'http://localhost:8080/ingeniero/get_all';
    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        final List<dynamic> jsonData = json.decode(response.body);
        state = jsonData.map((item) => Ingeniero.fromJson(item)).toList();
      }
    } catch (e) {
      // Manejo de errores
    }
  }

  Future<void>  createIngenieros(Ingeniero dept) async {
    const url = 'http://localhost:8080/ingeniero/create';
    try {
      final response = await http.post(
        Uri.parse(url),
        headers: <String, String>{'Content-Type': 'application/json; charset=UTF-8'},
        body: jsonEncode(dept.toJson()),
      );

      if (response.statusCode == 200) {
        final dynamic jsonData = json.decode(response.body);
        state = [...state, Ingeniero.fromJson(jsonData)];
      }
    } catch (e) {
      // Manejo de errores
    }
  }

  Future<void> deleteIngeniero(int? id) async {
    final url = 'http://localhost:8080/ingeniero/delete/$id';
    try {
      final response = await http.delete(Uri.parse(url));

      if (response.statusCode == 200) {
        state = state.where((ingeniero) => ingeniero.id != id).toList();
      }
    } catch (e) {
      // Manejo de errores
    }
  }
}