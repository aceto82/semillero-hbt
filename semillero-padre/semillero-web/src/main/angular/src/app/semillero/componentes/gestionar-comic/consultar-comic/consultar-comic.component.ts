import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { TematicaEnum } from 'src/app/semillero/enums/tematica.enum';
import { MultiLanguage } from 'src/app/semillero/multiLanguage/multiLanguage';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';

@Component({
  selector: 'app-consultar-comic',
  templateUrl: './consultar-comic.component.html'

})
export class ConsultarComicComponent extends MultiLanguage implements OnInit {

  public comicDTO: ComicDTO;
  public tituloComplemento: any;

  public tematicas: Map<string, string>;

  constructor(public translate: TranslateService, private router: Router, private activeRoute: ActivatedRoute, private gestionarComicService: GestionarComicService) {
    super(translate);
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.tematicas = new Map<string, string>();
    Object.keys(TematicaEnum).forEach(value => {
      this.tematicas.set(value, TematicaEnum[value]);
    });
    this.comicDTO = new ComicDTO();
    //let data:any = this.activeRoute.snapshot.params;
    //this.comicDTO = <ComicDTO> data.comic;
    //this.listaComics = <Array<ComicDTO>> data.lista;


    this.comicDTO = <ComicDTO>this.activeRoute.snapshot.params;
    //let idComic = this.activeRoute.snapshot.params;
    this.gestionarComicService.consultarComic(String(this.comicDTO.id)).subscribe(resultado => {
      if (resultado.exitoso) {
        this.comicDTO = resultado.comic;
      }
    });
  }

  public regresar(): void {
    this.router.navigate(['gestionar-comic']);
  }

}
