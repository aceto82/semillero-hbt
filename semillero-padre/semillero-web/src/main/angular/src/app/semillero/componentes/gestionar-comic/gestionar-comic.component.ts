import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from '../../dto/comic.dto';
import { TematicaEnum } from '../../enums/tematica.enum';
import { MultiLanguage } from '../../multiLanguage/multiLanguage';

@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent extends MultiLanguage implements OnInit {

  public gestionarComicForm: FormGroup;
  public comicDTO: ComicDTO;
  public comicDTOData: ComicDTO;
  public listaComics: Array<ComicDTO>;
  public mostrarItem: boolean;
  public tituloComplemento: any;
  public mostrarData: boolean;
  public validoFormulario: boolean;

  constructor(public translate: TranslateService, private formBuilder: FormBuilder) {
    super(translate);
    this.gestionarComicForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      editorial: [null, Validators.required],
      tematicaEnum: [null, Validators.required],
      coleccion: [null],
      numeroPaginas: [null, Validators.required],
      precio: [null, Validators.required],
      autores: [null],
      color: [true],
      cantidad: [null],
    });
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.listaComics = new Array<ComicDTO>();
    this.comicDTO = new ComicDTO();
  }

  public crearComic(): void {
    if (this.gestionarComicForm.invalid) {
      this.validoFormulario = true;
      return;
    }
    this.comicDTO = this.gestionarComicForm.value;
    this.validoFormulario = false;
    this.listaComics.push(this.comicDTO);
    //this.comicDTO = new ComicDTO();
    this.mostrarItem = true;
    this.limpiarForm();
  }

  private limpiarForm(): void {
    this.gestionarComicForm.reset(); // opcion 1 limpiar formulario

    // opcion 2 limpiar formulario
    //this.f.nombre.setValue(null);
    // ....
  }

  public cerrar(): void {
    this.mostrarItem = false;
    this.mostrarData = false;
  }

  public imprimirDataComic(indice: number): void {
    this.comicDTOData = this.listaComics[indice];
    this.mostrarData = true;
  }

  get f() {
    return this.gestionarComicForm.controls;
  }

  public agregarValidacionColeccion(): void {
    let tematiaEnumRequiereColeccion = [TematicaEnum.AVENTURA.toUpperCase(), TematicaEnum.HORROR.toUpperCase()];
    let tematicaSeleccionada = this.f.tematicaEnum.value;
    this.f.coleccion.clearValidators();
    this.f.coleccion.updateValueAndValidity();
    if (tematiaEnumRequiereColeccion.indexOf(tematicaSeleccionada) >= 0) {
      this.f.coleccion.setValidators(Validators.required);
      this.f.coleccion.updateValueAndValidity();
    }

  }

}
