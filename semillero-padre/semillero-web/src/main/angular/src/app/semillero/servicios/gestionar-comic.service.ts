import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dto/comic.dto';
import { ConsultarComicDTO } from '../dto/consultar-comic.dto';
import { ObtenerComicsDTO } from '../dto/obtener-comics.dto';
import { ResultadoDTO } from '../dto/resultado-dto';

@Injectable({
  providedIn: 'root'
})
export class GestionarComicService {

  constructor(private httpClient: HttpClient) { }

  public obtenerComics(): Observable<ObtenerComicsDTO> {
    return this.httpClient.get<ObtenerComicsDTO>('http://localhost:8085/semillero-servicios/rest/gestionComicRest/obtenerComics');
  }

  public crearComic(comicDTO: ComicDTO): Observable<ResultadoDTO> {
    return this.httpClient.post<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/gestionComicRest/crearComic', comicDTO);
  }

  public consultarComic(idComic: string): Observable<ConsultarComicDTO> {
    let parametros = new HttpParams().set("idComic", idComic);
    return this.httpClient.get<ConsultarComicDTO>('http://localhost:8085/semillero-servicios/rest/gestionComicRest/consultarComic', { params: parametros });
  }

  public actualizarComic(comicDTO: ComicDTO): Observable<ResultadoDTO> {
    return this.httpClient.put<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/gestionComicRest/actualizarComic', comicDTO);
  }

  public eliminarComic(idComic: string): Observable<ResultadoDTO> {
    let parametros = new HttpParams().set("idComic", idComic);
    return this.httpClient.delete<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/gestionComicRest/eliminarComic', { params: parametros });
  }

  public consultarNombrePrecioComic(idComic: string): Observable<any> {
    let parametros = new HttpParams().set("idComic", idComic);

    //let parametros = new HttpParams().set("idComic", JSON.stringify(comicDTO));
    //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarNombrePrecioComic?idComic=' + idComic);
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionComicRest/consultarNombrePrecioComic', { params: parametros });
  }

  public comprarComic(idComic: string, cantidad: string): Observable<ResultadoDTO> {
    let parametros = new HttpParams().append('idComic', idComic).append('cantidad', cantidad);
    //let parametros = "?idComic="+idComic+"&cantidad="+cantidad;
    return this.httpClient.post<ResultadoDTO>('http://localhost:8085/semillero-servicios/rest/gestionarCompraComicRest/comprarComic', null, { params: parametros });
  }
}
