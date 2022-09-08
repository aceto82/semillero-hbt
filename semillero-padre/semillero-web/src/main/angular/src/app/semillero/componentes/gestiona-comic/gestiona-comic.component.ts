import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestiona-comic.component.html'  
})
export class GestionaComicComponent implements OnInit {

  public listaComic:any;
  public mostrarItem:boolean;

  constructor() { }

  ngOnInit() {
  }

}
