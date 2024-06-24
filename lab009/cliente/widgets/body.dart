import 'package:flutter/material.dart';
import 'package:front08/widgets/departamento/listar_departamentos.dart';
import 'package:front08/widgets/departamento/listar_ingenieros.dart';

class MyBody extends StatelessWidget {
const MyBody({ super.key });

  @override
  Widget build(BuildContext context){
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Modulo de administración'),
        ),
        body: const Column(
          children: <Widget>[
            TabBar(
              tabs: [
                Tab(icon: Icon(Icons.home), text: "Departamentos"),
                Tab(icon: Icon(Icons.person_3_sharp), text: "Ingenieros"),
                Tab(icon: Icon(Icons.work), text: "Proyectos"),
              ],
            ),
            // Contenido del TabBarView
            Expanded(
              child: TabBarView(
                children: [
                  DepartamentosList(),
                  IngenierosList(),
                  Center(child: Text("Contenido de Bike")),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}