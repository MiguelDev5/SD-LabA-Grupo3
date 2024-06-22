import 'package:flutter/material.dart';
import 'package:front08/widgets/departamentos.dart';

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
                Tab(icon: Icon(Icons.work), text: "Pryectos"),
              ],
            ),
            // Contenido del TabBarView
            Expanded(
              child: TabBarView(
                children: [
                  DepartamentosList(),
                  Center(child: Text("Contenido de Transit")),
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