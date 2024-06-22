import 'package:xml/xml.dart' as xml;

class Product {
  final String name;
  final double price;

  Product(this.name, this.price);

  factory Product.fromXml(xml.XmlElement element) {
    return Product(
      // ignore: deprecated_member_use
      element.findElements('name').single.text,
      // ignore: deprecated_member_use
      double.parse(element.findElements('price').single.text),
    );
  }
}