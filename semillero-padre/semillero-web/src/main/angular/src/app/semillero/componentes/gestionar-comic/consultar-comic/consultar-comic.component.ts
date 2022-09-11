import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { MultiLanguage } from 'src/app/semillero/multiLanguage/multiLanguage';

@Component({
  selector: 'app-consultar-comic',
  templateUrl: './consultar-comic.component.html'
  
})
export class ConsultarComicComponent extends MultiLanguage implements OnInit {

  public comicDTO: ComicDTO;  

  constructor(public translate: TranslateService,private router: Router, private activeRoute:ActivatedRoute) { 
    super(translate);
  }

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
