import 'package:flutter/material.dart';
import 'package:front07/widgets/appbar.dart';
import 'package:front07/widgets/body.dart';
import 'package:front07/widgets/resume.dart';

class MainScreen extends StatelessWidget {
  MainScreen({super.key});

  final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context) {

    return Theme(
      data: ThemeData.dark(),
      child: Scaffold(
        key: _scaffoldKey,
        appBar: const MyAppBar(),
        body: const MyBody(),
        floatingActionButton: const MyResume(),
      ),
    );
  }
}
