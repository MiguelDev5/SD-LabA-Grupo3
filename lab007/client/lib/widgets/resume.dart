import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front07/messages/toast_message.dart';
import 'package:front07/soap_services/serv_sales.dart';
import 'package:front07/soap_services/states.dart';
import 'package:front07/widgets/product_selected.dart';

class MyResume extends ConsumerStatefulWidget {
  const MyResume({super.key});

  @override
  MyResumeState createState() => MyResumeState();
}

class MyResumeState extends ConsumerState<MyResume> {
  OverlayEntry? _overlayEntry;
  bool _isMaximized = false;

  void _toggleOverlay() {
    if (_overlayEntry == null) {
      _showOverlay();
    } else {
      _removeOverlay();
    }
  }

  void _showOverlay() {
    _overlayEntry = _createOverlayEntry();
    Overlay.of(context).insert(_overlayEntry!);
  }

  void _removeOverlay() {
    _overlayEntry?.remove();
    _overlayEntry = null;
  }

  OverlayEntry _createOverlayEntry() {
    return OverlayEntry(
      builder: (context) => Positioned(
        bottom: 50,
        right: 50,
        child: Draggable(
          feedback: _buildFloatingWidget(),
          childWhenDragging: Container(),
          child: _buildFloatingWidget(),
          onDragEnd: (details) {
            setState(() {
              _overlayEntry = _createOverlayEntry();
              Overlay.of(context).insert(_overlayEntry!);
            });
          },
        ),
      ),
    );
  }

  void mostrarSnackBar(BuildContext context, String mensaje) {
    final snackBar = SnackBar(
      content: Text(mensaje),
      backgroundColor: Colors.green,
      duration: Duration(seconds: 3),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  Widget _buildFloatingWidget() {
    return GestureDetector(
      onTap: () {
        setState(() {
          _isMaximized = !_isMaximized;
        });
      },
      child: Material(
        elevation: 8.0,
        borderRadius: BorderRadius.circular(16),
        child: Container(
          width: _isMaximized ? 400 : 300,
          height: _isMaximized ? 400 : 400,
          decoration: BoxDecoration(
            color: Colors.blue,
            borderRadius: BorderRadius.circular(16),
          ),
          child: Center(
            child: Column(
              children: [
                const ProductSelected(), 
                ElevatedButton(
                  onPressed: () async {
                    String message = await requestSale(ref.watch(productsSelected));
                    mostrarSnackBar(context, message);
                  }, 
                  child: const Text("Comprar")
                ) 
              ],
            ),
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(
      onPressed: _toggleOverlay,
      tooltip: 'Toggle Overlay',
      child: const Icon(Icons.widgets),
    );
  }
}