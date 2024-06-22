import 'package:flutter_riverpod/flutter_riverpod.dart';
final productsSelected = StateProvider <List<String>>((ref) => []);

final totalSelected = StateProvider <double>((ref) => 0.0);