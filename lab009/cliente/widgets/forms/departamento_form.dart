import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front08/models/departamento.dart';
import 'package:front08/provider/states.dart';
import 'package:front08/services/serv_departamento.dart';

// ignore: must_be_immutable
class DepartamentoForm extends ConsumerStatefulWidget {
  BuildContext fatherContext;

  DepartamentoForm({super.key, required this.fatherContext});

  @override
  DepartamentoFormState createState() => DepartamentoFormState();
}

class DepartamentoFormState extends ConsumerState<DepartamentoForm> {
  final _formKey = GlobalKey<FormState>();
  final _nombreController = TextEditingController();
  final _descripcionController = TextEditingController();
  final _telefonoController = TextEditingController();
  final _faxController = TextEditingController();

  @override
  void dispose() {
    _nombreController.dispose();
    _descripcionController.dispose();
    _telefonoController.dispose();
    _faxController.dispose();
    super.dispose();
  }

  void _submitForm(DepartamentoNotifier departamentoNotifier) {
    if (_formKey.currentState!.validate()) {
      final nombre = _nombreController.text;
      final descripcion = _descripcionController.text;
      final telefono = _telefonoController.text;
      final fax = _faxController.text;

      Departamento newDepartamento = Departamento(nombre: nombre, descripcion: descripcion, telefono: telefono, fax: fax);

      departamentoNotifier.createDepartamentos(newDepartamento);

      Navigator.of(widget.fatherContext).pop();
    }
    
  }

  void closeForm() {
    Navigator.of(widget.fatherContext).pop();
  }

  @override
  Widget build(BuildContext context) {

    final departamentosNotifier = ref.read(departamentosProvider.notifier);

    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Form(
        key: _formKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            TextFormField(
              controller: _nombreController,
              decoration: const InputDecoration(
                labelText: 'Nombre',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese el nombre';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _descripcionController,
              decoration: const InputDecoration(
                labelText: 'Descripción',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese la descripción';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _telefonoController,
              decoration: const InputDecoration(
                labelText: 'Teléfono',
              ),
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Por favor, ingrese el teléfono';
                }
                return null;
              },
            ),
            TextFormField(
              controller: _faxController,
              decoration: const InputDecoration(
                labelText: 'Fax',
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
                      _submitForm(departamentosNotifier);
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