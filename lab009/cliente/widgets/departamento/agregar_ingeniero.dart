import 'package:flutter/material.dart';
import 'package:front08/widgets/forms/ingeniero_form.dart';

class AgregarIngeniero extends StatelessWidget {
  const AgregarIngeniero({super.key});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        showDialog(
          context: context,
          builder: (BuildContext context) {
            return AlertDialog(
              title: const Text('Formulario - Ingeniero'),
              content: IngenieroForm(fatherContext :context)
            );
          },
        );
      },
      child: const Text('Agregar Ingeniero'),
    );
  }
}