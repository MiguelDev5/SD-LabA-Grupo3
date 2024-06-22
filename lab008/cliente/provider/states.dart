import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front08/models/departamento.dart';
import 'package:front08/services/serv_departamento.dart';

final productsSelected = StateProvider <List<String>>((ref) => []);

final totalSelected = StateProvider <double>((ref) => 0.0);
final departamentosState = StateProvider <List<Departamento>>((ref) => []);

final departamentosProvider = StateNotifierProvider<DepartamentoNotifier, List<Departamento>>((ref) {
  return DepartamentoNotifier();
});