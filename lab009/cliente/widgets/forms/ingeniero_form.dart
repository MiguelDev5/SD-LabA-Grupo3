import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front08/models/ingeniero.dart';
import 'package:front08/provider/states.dart';
import 'package:front08/services/serv_ingeniero.dart';

// ignore: must_be_immutable
class IngenieroForm extends ConsumerStatefulWidget {
  BuildContext fatherContext;

  IngenieroForm({super.key, required this.fatherContext});

  @override
  IngenieroFormState createState() => IngenieroFormState();
}

class IngenieroFormState extends ConsumerState<IngenieroForm> {
  final _formKey = GlobalKey<FormState>();
  final _nombresController = TextEditingController();
  final _apellidosController = TextEditingController();
  final _especialidadController = TextEditingController();
  final _cargoController = TextEditingController();

  @override
  void dispose() {
    _nombresController.dispose();
    _apellidosController.dispose();
    _especialidadController.dispose();
    _cargoController.dispose();
    super.dispose();
  }

  void _submitForm(IngenieroNotifier ingenieroNotifier) {
    if (_formKey.currentState!.validate()) {
      final nombres = _nombresController.text;
      final apellidos = _apellidosController.text;
      final especialidad = _especialidadController.text;
      final cargo = _cargoController.text;

      Ingeniero newIngeniero = Ingeniero(nombres: nombres, apellidos: apellidos, especialidad: especialidad, cargo: cargo);

      ingenieroNotifier.createIngenieros(newIngeniero);

      Navigator.of(widget.fatherContext).pop();
    }
    
  }

  void closeForm() {
    Navigator.of(widget.fatherContext).pop();
  }

  @override
  Widget build(BuildContext context) {

    final ingenierosNotifier = ref.read(ingenierosProvider.notifier);

    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Form(
        key: _formKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            TextFormField(
              controller: _nombresController,
              decoration: const InputDecoration(
                labelText: 'Nombres',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese el nombre';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _apellidosController,
              decoration: const InputDecoration(
                labelText: 'apellidos',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese la descripción';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _especialidadController,
              decoration: const InputDecoration(
                labelText: 'especialidad',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese el teléfono';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _cargoController,
              decoration: const InputDecoration(
                labelText: 'cargo',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese el fax';
                }
                return null;
              },
            ),
            Row(
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 16.0),
                  child: ElevatedButton(
                    onPressed: closeForm,
                    child: const Text('Cancel'),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 16.0),
                  child: ElevatedButton(
                    onPressed: () {
                      _submitForm(ingenierosNotifier);
                    },
                    child: const Text('Enviar'),
                  ),
                )
              ],
            )
          ],
        ),
      ),
    );
  }
}