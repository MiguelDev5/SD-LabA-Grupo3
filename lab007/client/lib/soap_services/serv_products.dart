import 'package:front07/models/product.dart';
import 'package:http/http.dart' as http;
import 'package:xml/xml.dart' as xml;

Future<List<Product>> readProducts() async {

  const url = 'http://localhost:8080/WSServices/ProductService';

  var request = '''
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services/">
      <soapenv:Header/>
      <soapenv:Body>
          <ser:getAllProducts>
          </ser:getAllProducts>
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
    final returnElements = document.findAllElements('return');

    List<Product> products = [];
    for (var e in returnElements) {
      products.add(Product.fromXml(e));
    }

    return products;
  } catch (e) {
    return [];
  }
}