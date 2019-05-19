export class Propiedad {
  ID?: number;
  NOMBRE_OWNER?: string;
  CEDULA_OWNER?: number;
  NOMBRE?: string;
  DESCRIPCION?: string;
  TIPO_CEDULA?: string;
  TIPO?: string;
  DIRECCION?: string;
  LOCALIDAD?: string;
  NUM_CUARTOS?: number;
  PRECIO?: number;
  RENTADA?: boolean;

  constructor(
    ID,
    NOMBRE_OWNER,
    CEDULA_OWNER,
    TIPO_CEDULA,
    TIPO,
    DIRECCION,
    LOCALIDAD,
    NUM_CUARTOS,
    PRECIO,
    RENTADA
  ) {
      this.ID = ID;
      this.NOMBRE_OWNER = NOMBRE_OWNER;
      this.CEDULA_OWNER = CEDULA_OWNER,
      this.TIPO_CEDULA = TIPO_CEDULA,
      this.TIPO = TIPO,
      this. DIRECCION = DIRECCION;
      this.LOCALIDAD = LOCALIDAD;
      this.NUM_CUARTOS = NUM_CUARTOS;
      this.PRECIO = PRECIO;
      this.RENTADA = RENTADA;
  }
}
