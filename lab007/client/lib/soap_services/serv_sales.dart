import 'package:front07/messages/toast_message.dart';
import 'package:http/http.dart' as http;
import 'package:xml/xml.dart' as xml;

Future<String> requestSale(List<String> selected) async {

  const url = 'http://localhost:8080/WSServices/SalesService';

  String params = "";
  selected.forEach((p){
    params = params + "<productsList>${p}</productsList>";
  });

  print(params);

  var request = '''
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services/">
      <soapenv:Header/>
      <soapenv:Body>
          <ser:sale>
            $params
          </ser:sale>
      </soapenv:Body>
    </soapenv:Envelope>
  ''';
  try {
    var response = await http.post( 
      Uri.parse(url),
      headers: {
        'Content-Type': 'text/xml; charset=utf-8',
        'SOAPAction': '""',
      },
      body: request
    );
    
    final document = xml.XmlDocument.parse(response.body);
    final returnElement = document.findAllElements('return').length;

    print("estatus");
    print(response.statusCode);
    print("responseeee");
    print(document);
    return "Se proceso la compra con exito";
  } catch (e) {
    return "Se produjo un error al procesar su compra";
  }
  
}