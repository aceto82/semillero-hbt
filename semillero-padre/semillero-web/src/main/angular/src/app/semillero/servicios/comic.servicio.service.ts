import { Injectable } from '@angular/core';
import { ComicDTO } from '../dto/comic.dto';

@Injectable({
  providedIn: 'root'
})
export class ComicServicio {

  private listaComics:Array<ComicDTO>;

  constructor() { 
    this.listaComics = new Array<ComicDTO>();
  }

  public getListComics():Array<ComicDTO>{
    return this.listaComics;
  }

  public setListComics(listaComics:Array<ComicDTO>):void{
    this.listaComics = listaComics;
  }

}
