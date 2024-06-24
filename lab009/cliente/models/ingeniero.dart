class Ingeniero {
  final int? id;
  final String nombres;
  final String apellidos;
  final String especialidad;
  final String cargo;

  Ingeniero({this.id, required this.nombres, required this.apellidos, required this.especialidad, required this.cargo});

  factory Ingeniero.fromJson(Map<String, dynamic> json) {
    return Ingeniero(
      id: json['idIng'],
      nombres: json['nombres'] as String,
      apellidos: json['apellidos'] as String,
      especialidad: json['especialidad'] as String,
      cargo: json['cargo'] as String,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'idIng': id,
      'nombres': nombres,
      'apellidos': apellidos,
      'especialidad': especialidad,
      'cargo': cargo,
    };
  }
}