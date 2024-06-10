import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

void mostrarMensaje(String mensaje) {
  try {
    Fluttertoast.showToast(
      msg: mensaje,
      toastLength: Toast.LENGTH_SHORT,
      gravity: ToastGravity.BOTTOM,
      timeInSecForIosWeb: 1,
      backgroundColor: Colors.green,
      textColor: Colors.white,
      fontSize: 16.0,
    );
  } catch (e) {
    print("Error al mostrar mensaje: $e");
  }
}