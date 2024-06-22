import 'package:flutter/material.dart';

class MyPopup extends StatelessWidget {
  const MyPopup({super.key});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () {
        showDialog(
          context: context,
          builder: (BuildContext context) {
            return AlertDialog(
              title: const Text('Popup Title'),
              content: const Text('This is the content of the popup.'),
              actions: <Widget>[
                TextButton(
                  onPressed: () {
                    Navigator.of(context).pop();
                  },
                  child: const Text('Cancel'),
                ),
                TextButton(
                  onPressed: () {
                    // Perform some action
                    Navigator.of(context).pop();
                  },
                  child: const Text('OK'),
                ),
              ],
            );
          },
        );
      },
      child: const Text('Show Popup'),
    );
  }
}

void main() {
  runApp(const MaterialApp(
    home: MyPopup(),
  ));
}
