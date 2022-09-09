import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * @description Componente menu, el cual contiene la logica para direccionar a los modulos
 * desarrollados
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'menu-page',
  templateUrl: './menu-component.html',
})
export class MenuComponent implements OnInit {

  /**
   * Constructor de la clase
   * @param router permite direccionar a otros componentes
   */
  constructor(private router: Router) {

  }

  /**
   * Evento angular que se ejecuta al iniciar el componente
   */
  ngOnInit(): void {
    this.loadScript('assets/js/jquery.min.js');
    this.loadScript('assets/js/browser.min.js');
    this.loadScript('assets/js/breakpoints.min.js');
    this.loadScript('assets/js/util.js');
    this.loadScript('assets/js/main.js');
  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author 
   */
  public navegarGestionarComic(): void {
    this.router.navigate(['gestionar-comic']);
  }

  /**
   * @description Metodo encargado de direccionar al componente de gestionar comic
   * @author 
   */
  public navegarHome(): void {
    this.router.navigate(['bienvenida']);
  }

  public navegarGestionarCompra(): void {
    //WIP
  }

  public loadScript(url: string) {
    const body = <HTMLDivElement> document.body;
    const script = document.createElement('script');
    script.innerHTML = '';
    script.src = url;
    script.async = false;
    script.defer = true;
    body.appendChild(script);
  }
}