import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { ComprarComicDTO } from 'src/app/semillero/dto/comprar-comic.dto';
import { MultiLanguage } from 'src/app/semillero/multiLanguage/multiLanguage';
import { ComicServicio } from 'src/app/semillero/servicios/comic.servicio.service';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';

@Component({
  selector: 'comprar-comic',
  templateUrl: './comprar-comic.component.html'
})
export class ComprarComicComponent extends MultiLanguage implements OnInit {

  public comicDTO: ComicDTO;
  public comprarComicForm: FormGroup;
  public validoFormulario: boolean;

  public tituloComplemento: any;
  public mostrarItem: boolean;
  public mensajeError: string;

  constructor(public translate: TranslateService, private router: Router, private formBuilder: FormBuilder, private activeRoute: ActivatedRoute, private gestionarComicService: GestionarComicService, private comicService: ComicServicio) {
    super(translate);
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.comicDTO = new ComicDTO();
    this.comicDTO = <ComicDTO>this.activeRoute.snapshot.params;
    this.comprarComicForm = this.formBuilder.group({
      id: [this.comicDTO.id],
      nombre: [this.comicDTO.nombre],
      cantidad: [0, [Validators.required, Validators.min(1), Validators.max(999), Validators.pattern("^[0-9]*$")]],
    });

  }

  public regresar(): void {
    this.router.navigate(['gestionar-comic']);
  }

  get f() {
    return this.comprarComicForm.controls;
  }

  public comprar(): void {
    this.mostrarItem = false;
    if (this.comprarComicForm.invalid) {
      this.validoFormulario = true;
      return;
    }
    let compracomicDTO: ComprarComicDTO = <ComprarComicDTO>this.comprarComicForm.value;
    this.gestionarComicService.comprarComic(String(compracomicDTO.id), String(compracomicDTO.cantidad)).subscribe(resultado => {
      if (resultado.exitoso) {
        this.compraExitosa(resultado.mensajeEjecucion);
      }
      this.mensajeError = resultado.mensajeEjecucion;
      this.mostrarItem = true;
      this.validoFormulario = false;
    });
  }

  public compraExitosa(mensaje: string): void {
    this.comicService.setMensaje(mensaje);
    this.router.navigate(['gestionar-comic'], { skipLocationChange: true });
  }

}
