import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { ComicServicio } from 'src/app/semillero/servicios/comic.servicio.service';

@Component({
  selector: 'app-consultar-comic',
  templateUrl: './consultar-comic.component.html'
  
})
export class ConsultarComicComponent implements OnInit {

  public comicDTO: ComicDTO;  

  constructor(private router: Router, private activeRoute:ActivatedRoute, private comicServicio:ComicServicio) { }

  ngOnInit() {
    this.comicDTO = new ComicDTO();    
    //let data:any = this.activeRoute.snapshot.params;
    //this.comicDTO = <ComicDTO> data.comic;
    //this.listaComics = <Array<ComicDTO>> data.lista;
    this.comicDTO = <ComicDTO> this.activeRoute.snapshot.params;
  }

  public regresar(): void{
    this.router.navigate(['gestionar-comic']);
  }

}
