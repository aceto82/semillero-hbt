import { Injectable } from '@angular/core';
import { ComicDTO } from '../dto/comic.dto';

@Injectable({
  providedIn: 'root'
})
export class ComicServicio {

  private listaComics: Array<ComicDTO>;

  constructor() {
    this.listaComics = new Array<ComicDTO>();
    this.listaComics = this.crearComicsPrueba();
  }

  public getListComics(): Array<ComicDTO> {
    return this.listaComics;
  }

  public setListComics(listaComics: Array<ComicDTO>): void {
    this.listaComics = listaComics;
  }

  private crearComicsPrueba(): Array<ComicDTO> {
    let listaComics: Array<ComicDTO> = new Array<ComicDTO>();
    let onepiece: ComicDTO = new ComicDTO();
    onepiece.id = 1;
    onepiece.nombre = "One Piece";
    onepiece.tematicaEnum = "AVENTURAS";
    onepiece.precio = 280;
    onepiece.editorial = "Shueisha";
    onepiece.coleccion = "Manga Shonen";
    onepiece.numeroPaginas = 103;
    onepiece.autores = "Eiichiro Oda";
    onepiece.color = false;
    onepiece.fechaVenta = new Date("2022-08-10");
    onepiece.estadoEnum = "ACTIVO"
    onepiece.cantidad = 54;

    let futari: ComicDTO = new ComicDTO();
    futari.id = 2;
    futari.nombre = "Futari Ecchi";
    futari.tematicaEnum = "HUMORISTICO";
    futari.precio = 24;
    futari.editorial = "Hakusensha";
    futari.coleccion = "Manga Seinen";
    futari.numeroPaginas = 45;
    futari.autores = "Katsu Aki";
    futari.color = false;
    futari.fechaVenta = new Date("2019-08-10");
    futari.estadoEnum = "INACTIVO";
    futari.cantidad = 0;

    let captainsubasa: ComicDTO = new ComicDTO();
    captainsubasa.id = 3;
    captainsubasa.nombre = "Captain Tsubasa";
    captainsubasa.tematicaEnum = "AVENTURAS";
    captainsubasa.precio = 79;
    captainsubasa.editorial = "Shueisha";
    captainsubasa.coleccion = "Manga Shonen/Seinen";
    captainsubasa.numeroPaginas = 103;
    captainsubasa.autores = "Yoichi Takahashi";
    captainsubasa.color = false;
    captainsubasa.fechaVenta = null;
    captainsubasa.estadoEnum = "INACTIVO"
    captainsubasa.cantidad = 79;

    let gantz: ComicDTO = new ComicDTO();
    gantz.id = 4;
    gantz.nombre = "Gantz";
    gantz.tematicaEnum = "CIENCIA_FICCION";
    gantz.precio = 128;
    gantz.editorial = "Shueisha";
    gantz.coleccion = "Manga Seinen";
    gantz.numeroPaginas = 83;
    gantz.autores = "Hiroya Oku";
    gantz.color = false;
    gantz.fechaVenta = new Date("2022-07-09");
    gantz.estadoEnum = "ACTIVO"
    gantz.cantidad = 241;

    let naruto: ComicDTO = new ComicDTO();
    naruto.id = 5;
    naruto.nombre = "Naruto";
    naruto.tematicaEnum = "AVENTURAS";
    naruto.precio = 172;
    naruto.editorial = "Shueisha";
    naruto.coleccion = "Manga Shonen";
    naruto.numeroPaginas = 73;
    naruto.autores = "Masashi Kishimoto";
    naruto.color = false;
    naruto.fechaVenta = new Date("2022-02-10");
    naruto.estadoEnum = "ACTIVO"
    naruto.cantidad = 189;

    listaComics.push(onepiece);
    listaComics.push(futari);
    listaComics.push(captainsubasa);
    listaComics.push(gantz);
    listaComics.push(naruto);

    return listaComics;

  }

}
