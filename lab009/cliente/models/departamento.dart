class Departamento {
  final int? id;
  final String nombre;
  final String descripcion;
  final String telefono;
  final String fax;

  Departamento({this.id, required this.nombre, required this.descripcion, required this.telefono, required this.fax});

  factory Departamento.fromJson(Map<String, dynamic> json) {
    return Departamento(
      id: json['idDpto'],
      nombre: json['nombre'] as String,
      descripcion: json['descripcion'] as String,
      telefono: json['telefono'] as String,
      fax: json['fax'] as String,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'idDpto': id,
      'nombre': nombre,
      'descripcion': descripcion,
      'telefono': telefono,
      'fax': fax,
    };
  }
}