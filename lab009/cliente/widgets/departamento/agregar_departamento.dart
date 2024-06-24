import 'package:flutter/material.dart';
import 'package:front08/widgets/forms/departamento_form.dart';

class AgregarDepartamento extends StatelessWidget {
  const AgregarDepartamento({super.key});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        showDialog(
          context: context,
          builder: (BuildContext context) {
            return AlertDialog(
              title: const Text('Formulario - Departamento'),
              content: DepartamentoForm(fatherContext :context)
            );
          },
        );
      },
      child: const Text('Agregar Departamento'),
    );
  }
}