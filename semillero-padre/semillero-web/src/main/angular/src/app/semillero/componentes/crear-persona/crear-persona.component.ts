import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';
import { EstadoEnum } from './enums/estado.enum';
import { TematicaEnum } from './enums/tematica.enum';


@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  public saludo: string;

  public comics: Array<any>;
  public comicsTematicaHorror: Array<ComicDTO>;
  public comicsTematicaHumoristico: Array<ComicDTO>;

  public imagen: any;
  
  constructor() { }

  ngOnInit() {
    this.saludo = "Hola semillero 2022";
    this.comics = this.crearComics();
    let url = "https://apod.nasa.gov/apod/image/2202/AuroraPillars_Correia_960.jpg";
    let height: number = 400;
    let width: number = 300;
    this.imagen = this.asignarImagen(url, height, width);

    let comics = new Map<string, Array<ComicDTO>>();

    this.comicsTematicaHorror = new Array<ComicDTO>()
    let comicBatman = new ComicDTO("Batman", TematicaEnum.HORROR, 900);
    let comicDragonBall = new ComicDTO("Dragon Ball", TematicaEnum.HORROR, 800);

    this.comicsTematicaHumoristico = new Array<ComicDTO>()
    let comicChavo = new ComicDTO("Chavo del 8", TematicaEnum.HUMORISTICO, 1900);
    let comicChapulin = new ComicDTO("Chapulin colorado", TematicaEnum.HUMORISTICO, 600);

    this.comicsTematicaHorror.push(comicBatman);
    this.comicsTematicaHorror.push(comicDragonBall);

    this.comicsTematicaHumoristico.push(comicChavo);
    this.comicsTematicaHumoristico.push(comicChapulin);

    comics.set(TematicaEnum.HORROR, this.comicsTematicaHorror);
    comics.set(TematicaEnum.HUMORISTICO, this.comicsTematicaHumoristico);

    let comicHumoristicos = comics.get(TematicaEnum.HUMORISTICO);
    console.log("Comics humoristicos " + JSON.stringify(comicHumoristicos));

    comics.forEach((value: Array<ComicDTO>, key: string) => {
      if (TematicaEnum.HORROR == key) {
        console.log("Lista comics horror: " + key + " " + JSON.stringify(value));
      } else {
        console.log("Lista comics humoristico: " + key + " " + JSON.stringify(value));
      }
    });
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

    //listaComics.splice(0,1);
    return listaComics;
  }

  public mostrarDescripcionimagen(): void {
    console.log(JSON.stringify(this.imagen));
    alert("Info imagen " + JSON.stringify(this.imagen));
  }  

}
