import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front07/soap_services/states.dart';

class ProductSelected extends ConsumerWidget {
  const ProductSelected({ super.key });

  @override
  Widget build(BuildContext context, WidgetRef ref){
    final names = ref.watch(productsSelected);

    return SizedBox(
      height: 350,
      child: ListView.builder(
        itemCount: names.length,
        itemBuilder: (context, index) {
          final name = names[index];
          return ListTile(
            title: Text(name),
          );
        },
      ),
    );
  }
}