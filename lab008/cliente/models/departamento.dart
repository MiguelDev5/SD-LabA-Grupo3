class Departamento {
  final int? id;
  final String nombre;
  final String descripcion;
  final String telefono;
  final String fax;

  Departamento(this.id, this.nombre, this.descripcion, this.telefono, this.fax);

  factory Departamento.fromJson(Map<String, dynamic> json) {
    return Departamento(
      json['idDpto'] as int?,
      json['nombre'] as String,
      json['descripcion'] as String,
      json['telefono'] as String,
      json['fax'] as String,
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