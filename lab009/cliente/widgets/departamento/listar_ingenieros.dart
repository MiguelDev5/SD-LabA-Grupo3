import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front08/provider/states.dart';
import 'package:front08/widgets/departamento/agregar_ingeniero.dart';

// Suponiendo que ya tienes importado el resto del código necesario

class IngenierosList extends ConsumerWidget {
  const IngenierosList({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final ingenieros = ref.watch(ingenierosProvider);
    final ingenierosNotifier = ref.read(ingenierosProvider.notifier);

    return Column(
      children: [
        Expanded(
          child: ingenieros.isEmpty
              ? const Center(child: CircularProgressIndicator())
              : GridView.builder(
                  gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 3, // Número de columnas en la cuadrícula
                    crossAxisSpacing: 10.0,
                    mainAxisSpacing: 10.0,
                  ),
                  itemCount: ingenieros.length,
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
                                    ingenieros[index].nombres,
                                    style: const TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.bold,
                                    ),
                                  ),
                                  Text(
                                    ingenieros[index].especialidad,
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
                                  ingenierosNotifier.deleteIngeniero(ingenieros[index].id);
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
        const AgregarIngeniero(),
      ],
    );
  }
}