import { EstadoEnum } from "../enums/estado.enum";
import { TematicaEnum } from "../enums/tematica.enum";

export class ComicDTO {
    public id: number;
    public nombre: string;
    public editorial: string;
    public tematicaEnum: TematicaEnum;
    public coleccion: String;
    public numeroPaginas: number;
    public precio: number;
    public autores: string;
    public fechaVenta: Date;
    public color: boolean;
    public estadoEnum: EstadoEnum;
    public cantidad: number;

    // constructor(nombre:string, tematicaEnum:TematicaEnum, precio:number){
    //     this.nombre = nombre;
    //     this.tematicaEnum = tematicaEnum;
    //     this.precio = precio;
    // }   

    constructor() { }

}