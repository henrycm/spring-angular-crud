export class Color{
  id: number;
  nombre: string;
  activo: boolean;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }

}
