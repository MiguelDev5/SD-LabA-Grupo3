import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:front07/soap_services/states.dart';

class TotalSelected extends ConsumerWidget {
  const TotalSelected({ Key? key }) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref){
    double total = ref.watch(totalSelected);

    return Text("Total: "+total.toString());
  }
}