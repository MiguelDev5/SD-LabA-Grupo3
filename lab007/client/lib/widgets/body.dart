import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front07/models/product.dart';
import 'package:front07/soap_services/serv_products.dart';
import 'package:front07/soap_services/states.dart';

class MyBody extends ConsumerWidget {
  const MyBody({ super.key });

  @override
  Widget build(BuildContext context, WidgetRef ref) {

    return Center(  
      child: FutureBuilder<List<Product>>(
        future: readProducts(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('No products found'));
          } else {
            List<Product> products = snapshot.data!;
            return GridView.builder(
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3 , // Number of columns in the grid
                crossAxisSpacing: 10.0,
                mainAxisSpacing: 10.0,
              ),
              itemCount: products.length,
              itemBuilder: (context, index) {
                return  InkWell(
                  onTap: () {
                    // Acción a ejecutar cuando se presiona el Card
                    print('Tapped on ${products[index].name}');
                    ref.read(productsSelected.notifier).update( 
                      (state) { 
                        if (!state.contains(products[index].name)) {
                          return [...state, products[index].name];
                        } else {
                          return state;
                        }
                      }
                    );
                  },
                  child: Card(
                    child: Padding(
                      padding: const EdgeInsets.all(16.0),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            products[index].name,
                            style: const TextStyle(
                              fontSize: 16, fontWeight: FontWeight.bold),
                          ),
                          Text(
                            '\$${products[index].price}',
                            style: const TextStyle(fontSize: 14),
                          ),
                        ],
                      ),
                    ),
                  ),
                );
              },
              padding: const EdgeInsets.all(10.0),
            );
          }
        },
      ),
    );
  }
}

