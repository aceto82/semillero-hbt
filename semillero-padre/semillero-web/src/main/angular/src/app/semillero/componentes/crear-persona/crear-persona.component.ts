import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { ComicTallerDTO } from '../../dto/comic-taller.dto';
import { ComicDTO } from '../../dto/comic.dto';
import { EstadoEnum } from '../../enums/estado.enum';
import { TematicaEnum } from '../../enums/tematica.enum';


@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  public saludo: any;
  public saludo2: any;

  public comics: Array<any>;
  public comicsTematicaHorror: Array<ComicDTO>;
  public comicsTematicaHumoristico: Array<ComicDTO>;

  public imagen: any;


  //Taller angular

  public comicsTaller: Array<ComicTallerDTO>
  public comicBorrado: ComicDTO;
  public mostrarMensajeBorrado: boolean = false;
  public mostrarMensajeError: boolean = false;

  constructor(public translate: TranslateService) {
    translate.addLangs(['es', 'en']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  ngOnInit() {
    this.saludo = "Hola semillero 2022";
    this.saludo2 = {mensaje: "DIEGO ORTIZ"};
    this.comics = this.crearComics();
    let url = "https://apod.nasa.gov/apod/image/2202/AuroraPillars_Correia_960.jpg";
    let height: number = 400;
    let width: number = 300;
    this.imagen = this.asignarImagen(url, height, width);

    let comics = new Map<string, Array<ComicDTO>>();

    this.comicsTematicaHorror = new Array<ComicTallerDTO>()
    let comicBatman = new ComicTallerDTO("Batman", TematicaEnum.HORROR, 900);
    let comicDragonBall = new ComicTallerDTO("Dragon Ball", TematicaEnum.HORROR, 800);

    this.comicsTematicaHumoristico = new Array<ComicTallerDTO>()
    let comicChavo = new ComicTallerDTO("Chavo del 8", TematicaEnum.HUMORISTICO, 1900);
    let comicChapulin = new ComicTallerDTO("Chapulin colorado", TematicaEnum.HUMORISTICO, 600);

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


    //Taller Angular
    this.comicsTaller = this.crearComicsTallerAngular();
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

  //Taller Angular

  /**
   * Crea los comics para el taller de angular
   * @returns Array<ComicDTO>
   */
  private crearComicsTallerAngular(): Array<ComicTallerDTO> {
    let listaComics: Array<ComicTallerDTO> = new Array<ComicTallerDTO>();
    let onepiece: ComicTallerDTO = new ComicTallerDTO("One Piece", TematicaEnum.AVENTURA, 280);
    onepiece.id = 1;
    onepiece.editorial = "Shueisha";
    onepiece.coleccion = "Manga Shonen";
    onepiece.numeroPaginas = 103;
    onepiece.autores = "Eiichiro Oda";
    onepiece.color = false;
    onepiece.fechaVenta = new Date("2022-08-10");
    onepiece.estadoEnum = EstadoEnum.ACTIVO
    onepiece.cantidad = 54;

    let futari: ComicTallerDTO = new ComicTallerDTO("Futari Ecchi", TematicaEnum.HUMORISTICO, 89);
    futari.id = 2;
    futari.editorial = "Hakusensha";
    futari.coleccion = "Manga Seinen";
    futari.numeroPaginas = 45;
    futari.autores = "Katsu Aki";
    futari.color = false;
    futari.fechaVenta = new Date("2019-08-10");
    futari.estadoEnum = EstadoEnum.INACTIVO
    futari.cantidad = 0;

    let captainsubasa: ComicTallerDTO = new ComicTallerDTO("Captain Tsubasa", TematicaEnum.AVENTURA, 79);
    captainsubasa.id = 3;
    captainsubasa.editorial = "Shueisha";
    captainsubasa.coleccion = "Manga Shonen/Seinen";
    captainsubasa.numeroPaginas = 103;
    captainsubasa.autores = "Yoichi Takahashi";
    captainsubasa.color = false;
    captainsubasa.fechaVenta = null;
    captainsubasa.estadoEnum = EstadoEnum.INACTIVO
    captainsubasa.cantidad = 79;

    let gantz: ComicTallerDTO = new ComicTallerDTO("Gantz", TematicaEnum.CIENCIA_FICCION, 128);
    gantz.id = 4;
    gantz.editorial = "Shueisha";
    gantz.coleccion = "Manga Seinen";
    gantz.numeroPaginas = 83;
    gantz.autores = "Hiroya Oku";
    gantz.color = false;
    gantz.fechaVenta = new Date("2022-07-09");
    gantz.estadoEnum = EstadoEnum.ACTIVO
    gantz.cantidad = 241;

    let naruto: ComicTallerDTO = new ComicTallerDTO("Naruto", TematicaEnum.AVENTURA, 172);
    naruto.id = 5;
    naruto.editorial = "Shueisha";
    naruto.coleccion = "Manga Shonen";
    naruto.numeroPaginas = 73;
    naruto.autores = "Masashi Kishimoto";
    naruto.color = false;
    naruto.fechaVenta = new Date("2022-02-10");
    naruto.estadoEnum = EstadoEnum.ACTIVO
    naruto.cantidad = 189;

    listaComics.push(onepiece);
    listaComics.push(futari);
    listaComics.push(captainsubasa);
    listaComics.push(gantz);
    listaComics.push(naruto);

    return listaComics;

  }

  /**
   * Borra un comic de una lista, segun el numero de posicion dado
   * @param posicion 
   */
  public borraComic(posicion: number): void {
    this.mostrarMensajeBorrado = false;
    this.mostrarMensajeError = false;
    if (this.comicsTaller.length < posicion || posicion < 1) {
      this.mostrarMensajeError = true;
    } else {
      this.mostrarMensajeBorrado = true;
      this.comicBorrado = this.comicsTaller.splice(posicion - 1, 1)[0];
    }
  }

}
