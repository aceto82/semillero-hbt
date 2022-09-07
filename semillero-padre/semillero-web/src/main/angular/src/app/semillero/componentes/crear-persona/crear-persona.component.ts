import { Component, OnInit } from '@angular/core';
import { EstadoEnum } from './Enums/estado.enum';
import { TematicaEnum } from './Enums/tematica.enum';


@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  public saludo: string;

  public comics: Array<any>;

  public imagen: any;

  constructor() { }

  ngOnInit() {
    this.saludo = "Hola semillero 2022";
    this.comics = this.crearComics();
    let url = "https://apod.nasa.gov/apod/image/2202/AuroraPillars_Correia_960.jpg";
    let height: number = 400;
    let width: number = 300;
    this.imagen = this.asignarImagen(url, height, width);
  }

  private asignarImagen(url: string, height: number, width: number): any {
    return {
      url: url,
      height: height,
      width: width,
    };
  }

  private crearComics(): Array<any> {
    let listaComics: Array<any>;
    let comicSuperman: any = {
      nombre: "Superman",
      estado: EstadoEnum.ACTIVO,
      precio: 120,
      tematica: TematicaEnum.AVENTURA,
      fechaVenta: null
    }

    let comicThor: any = {
      nombre: "Thor",
      estado: EstadoEnum.ACTIVO,
      precio: 120,
      tematica: TematicaEnum.AVENTURA,
      fechaVenta: null
    }

    let comicSpiderman: any = {
      nombre: "Spiderman",
      estado: EstadoEnum.ACTIVO,
      precio: 120,
      tematica: TematicaEnum.AVENTURA,
      fechaVenta: null
    }

    let comicHulk: any = {
      nombre: "Hulk",
      estado: EstadoEnum.ACTIVO,
      precio: 120,
      tematica: TematicaEnum.AVENTURA,
      fechaVenta: null
    }
    listaComics = new Array<any>();
    listaComics.push(comicSpiderman);
    listaComics.push(comicThor);
    listaComics.push(comicSpiderman);
    listaComics.push(comicHulk);
    return listaComics;
  }

  public mostrarDescripcionimagen(): void {
    console.log(JSON.stringify(this.imagen));
    alert("Info imagen " + JSON.stringify(this.imagen));
  }

}
