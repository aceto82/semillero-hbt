import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from '../../dto/comic.dto';
import { ObtenerComicsDTO } from '../../dto/obtener-comics.dto';
import { EstadoEnum } from '../../enums/estado.enum';
import { TematicaEnum } from '../../enums/tematica.enum';
import { MultiLanguage } from '../../multiLanguage/multiLanguage';
import { ComicServicio } from '../../servicios/comic.servicio.service';
import { GestionarComicService } from '../../servicios/gestionar-comic.service';

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

  public msjBorrar: string;
  public comicBorrar: ComicDTO;
  public mostrarItemBorrar: boolean;
  //public indexComicBorrado: number;  
  public mostrarMensajeError: boolean;

  public mensajeEjecucion: string;
  public mostrarMensajeFallido: boolean;

  public tematicas: Map<string, string>;

  public mostrarItemCompra: boolean;


  constructor(public translate: TranslateService, private formBuilder: FormBuilder, private router: Router, private gestionarComicService: GestionarComicService, private activeRoute: ActivatedRoute) {
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
      cantidad: [null, Validators.required],
    });
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.listaComics = new Array<ComicDTO>();
    this.obtenerComics();
    // if (this.activeRoute.snapshot.params ){
    //   this.listaComics = <Array<ComicDTO>> this.activeRoute.snapshot.params;
    // }
    this.comicDTO = new ComicDTO();
    this.tematicas = new Map<string, string>();
    Object.keys(TematicaEnum).forEach(value => {
      this.tematicas.set(value, TematicaEnum[value]);
    });
    let data = this.activeRoute.snapshot.params;
    if (data!=null && data!=undefined){
      this.mensajeEjecucion = String(data.mensaje);
      this.mostrarItemCompra = true;
    }
  }

  private obtenerComics(): void {
    this.gestionarComicService.obtenerComics().subscribe((resultado: ObtenerComicsDTO) => {
      if (resultado.exitoso) {
        this.listaComics = resultado.comicsList;
      } else {
        this.mensajeEjecucion = resultado.mensajeEjecucion;
        this.mostrarMensajeFallido = resultado.exitoso;
      }
    });
  }

  public crearComic(): void {
    this.mostrarMensajeFallido = false;
    if (this.gestionarComicForm.invalid) {
      this.validoFormulario = true;
      return;
    }
    this.comicDTO = this.gestionarComicForm.value;

    this.gestionarComicService.crearComic(this.comicDTO).subscribe(resultado => {
      if (resultado.exitoso) {
        this.obtenerComics();
        this.mostrarItem = true;
        this.limpiarForm();
      } else {
        this.mostrarMensajeFallido = !resultado.exitoso;
        this.mensajeEjecucion = resultado.mensajeEjecucion;
      }
      this.validoFormulario = false;
    }, error => {
      console.log(error);
    });
    //this.comicDTO.id = this.listaComics.length + 30;
    //this.validoFormulario = false;
    //this.listaComics.push(this.comicDTO);
    //this.comicDTO = new ComicDTO();
    //this.mostrarItem = true;
    //this.limpiarForm();
  }

  private limpiarForm(): void {
    this.gestionarComicForm.reset(); // opcion 1 limpiar formulario

    // this.gestionarComicForm.disable();
    // this.gestionarComicForm.enable();

    // opcion 2 limpiar formulario
    // this.f.nombre.setValue(null);
    // this.f.editorial.setValue(null); 
    // this.f.tematicaEnum.setValue(null); 
    // this.f.coleccion.setValue(null); 
    // this.f.numeroPaginas.setValue(null); 
    // this.f.precio.setValue(null); 
    // this.f.autores.setValue(null); 
    this.f.color.setValue(true);
    // this.f.cantidad.setValue(null); 
  }

  public cerrar(): void {
    this.mostrarItem = false;
    this.mostrarData = false;
    this.mostrarItemBorrar = false;
    this.mostrarItemCompra = false;
  }

  public imprimirDataComic(indice: number): void {
    this.comicDTOData = this.listaComics[indice];
    this.mostrarData = true;
  }

  get f() {
    return this.gestionarComicForm.controls;
  }

  public agregarValidacionColeccion(): void {
    let tematiaEnumRequiereColeccion = [TematicaEnum.AVENTURAS.toUpperCase(), TematicaEnum.HORROR.toUpperCase()];
    let tematicaSeleccionada = this.f.tematicaEnum.value;
    // this.f.coleccion.enable();
    this.f.coleccion.clearValidators();
    this.f.coleccion.updateValueAndValidity();
    if (tematiaEnumRequiereColeccion.indexOf(tematicaSeleccionada) >= 0) {
      // this.f.coleccion.disable();
      this.f.coleccion.setValidators(Validators.required);
      this.f.coleccion.updateValueAndValidity();
    }

  }

  public irAConsultarComic(comic: ComicDTO): void {
    this.router.navigate(['consultar-comic', comic], { skipLocationChange: true });
  }

  public getLabelColor(value: boolean): string {
    let labelkey: string = value ? "gestionarComic.color.si" : "gestionarComic.color.no";
    //let label: string = "";
    // this.translate.get(labelkey).subscribe((res: string) => {
    //   label = res;
    // });
    return labelkey;
  }

  public getLabelTematica(value: string): string {
    let labelkey: string = "";

    if (TematicaEnum[value] != undefined) {
      labelkey = TematicaEnum[value];
    }
    return labelkey;
  }

  public irAEditarComic(comic: ComicDTO): void {
    this.router.navigate(['editar-comic', comic], { skipLocationChange: true });
  }

  public confirmaBorrarComic(comic: ComicDTO): void {
    let label: string = "";
    this.comicBorrar = comic;
    this.translate.get('gestionarComic.modalBorrar.msj', { nombreComic: comic.nombre }).subscribe((res: string) => {
      label = res;
    });
    this.msjBorrar = label;
  }

  // public confirmaBorrarComic(index: number): void {
  //   let label: string = "";
  //   this.indexComicBorrado = index;
  //   this.translate.get('gestionarComic.modalBorrar.msj', { nombreComic: this.listaComics[index].nombre }).subscribe((res: string) => {
  //     label = res;
  //   });
  //   this.msjBorrar = label;
  // }

  public borrarComic(): void {
    this.mostrarItemBorrar = false;
    this.mostrarMensajeError = false;
    this.gestionarComicService.eliminarComic(String(this.comicBorrar.id)).subscribe(resultado => {
      if (resultado.exitoso) {
        this.mostrarItemBorrar = true;
        this.obtenerComics();
      }
      else {
        this.mostrarMensajeError = true;
      }
    });
    // if (this.listaComics.length < this.indexComicBorrado || this.indexComicBorrado < 1) {
    //   this.mostrarMensajeError = true;
    // } else {
    //   this.mostrarItemBorrar = true;
    //   this.comicBorrar = this.listaComics.splice(this.indexComicBorrado, 1)[0];
    // }
  }

  public irAComprarComic(comic: ComicDTO): void {
    this.router.navigate(['comprar-comic', comic], { skipLocationChange: true });
  }

  public getLabelEstado(value: string): string {
    let labelkey: string = "";

    if (EstadoEnum[value] != undefined) {
      labelkey = EstadoEnum[value];
    }
    return labelkey;
  }

}
