import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { MultiLanguage } from 'src/app/semillero/multiLanguage/multiLanguage';
import { ComicServicio } from 'src/app/semillero/servicios/comic.servicio.service';

@Component({
  selector: 'editar-comic',
  templateUrl: './editar-comic.component.html'
})
export class EditarComicComponent extends MultiLanguage implements OnInit {

  public comicDTO: ComicDTO;
  private listComics: Array<ComicDTO>;

  public editarComicForm: FormGroup;
  public validoFormulario: boolean;
  public mostrarItem: boolean;

  constructor(public translate: TranslateService, private formBuilder: FormBuilder, private router: Router, private activeRoute: ActivatedRoute, private comicServicio: ComicServicio) {
    super(translate);
  }

  ngOnInit() {
    this.comicDTO = new ComicDTO();
    this.listComics = this.comicServicio.getListComics();
    this.comicDTO = <ComicDTO>this.activeRoute.snapshot.params;
    this.editarComicForm = this.formBuilder.group({
      id: [this.comicDTO.id],
      nombre: [this.comicDTO.nombre, Validators.required],
      editorial: [this.comicDTO.editorial, Validators.required],
      tematicaEnum: [this.comicDTO.tematicaEnum, Validators.required],
      coleccion: [this.comicDTO.coleccion],
      numeroPaginas: [this.comicDTO.numeroPaginas, Validators.required],
      precio: [this.comicDTO.precio, Validators.required],
      autores: [this.comicDTO.autores],
      fechaVenta: [this.comicDTO.fechaVenta],
      color: [<boolean>this.comicDTO.color],
      estadoEnum: [this.comicDTO.estadoEnum],
      cantidad: [this.comicDTO.cantidad],
    });
  }

  public regresar(): void {
    this.router.navigate(['gestionar-comic']);
  }

  public actualizar(): void {
    if (this.editarComicForm.invalid) {
      this.validoFormulario = true;
      return;
    }
    this.comicDTO = <ComicDTO>this.editarComicForm.value;
    this.validoFormulario = false;
    let index: number = -1;
    this.listComics.forEach((comic, indcomic) => {
      if (comic.id == this.comicDTO.id) {
        index = indcomic;
        return;
      }
    });
    if (index != - 1) {
      this.comicDTO.color = this.f.color.value=="true";
      this.listComics[index] = this.comicDTO;
    }
    //this.regresar();
    // this.listaComics.push(this.comicDTO);
    // //this.comicDTO = new ComicDTO();
    this.mostrarItem = true;
    // this.limpiarForm();
  }

  get f() {
    return this.editarComicForm.controls;
  }

}
