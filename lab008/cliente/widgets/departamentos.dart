import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front08/provider/states.dart';

// Suponiendo que ya tienes importado el resto del código necesario

class DepartamentosList extends ConsumerWidget {
  const DepartamentosList({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final departamentos = ref.watch(departamentosProvider);
    final departamentosNotifier = ref.read(departamentosProvider.notifier);

    return Column(
      children: [
        Expanded(
          child: departamentos.isEmpty
              ? const Center(child: CircularProgressIndicator())
              : GridView.builder(
                  gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 3, // Número de columnas en la cuadrícula
                    crossAxisSpacing: 10.0,
                    mainAxisSpacing: 10.0,
                  ),
                  itemCount: departamentos.length,
                  itemBuilder: (context, index) {
                    return Card(
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
                        child: Stack(
                          children: [
                            Center(
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.center,
                                crossAxisAlignment: CrossAxisAlignment.center,
                                children: [
                                  Text(
                                    departamentos[index].nombre,
                                    style: const TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.bold,
                                    ),
                                  ),
                                  Text(
                                    departamentos[index].descripcion,
                                    style: const TextStyle(fontSize: 14),
                                  ),
                                  const SizedBox(height: 50), // Espacio para los botones flotantes
                                ],
                              ),
                            ),
                            Positioned(
                              bottom: 8.0,
                              right: 8.0,
                              child: FloatingActionButton(
                                onPressed: () {
                                  // Acción del botón de edición
                                },
                                mini: true,
                                child: const Icon(Icons.edit),
                              ),
                            ),
                            Positioned(
                              bottom: 8.0,
                              right: 72.0,
                              child: FloatingActionButton(
                                onPressed: () {
                                  departamentosNotifier.deleteDepartamento(departamentos[index].id);
                                },
                                mini: true,
                                child: const Icon(Icons.delete),
                              ),
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                  padding: const EdgeInsets.all(10.0),
                ),
        ),
        ElevatedButton(
          onPressed: () {
            // Acción del botón adicional debajo del FutureBuilder
          },
          child: const Text('Botón Adicional'),
        ),
      ],
    );
  }
}