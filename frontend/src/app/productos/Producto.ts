export class Producto{
  id: number;
  description: string;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }

}
