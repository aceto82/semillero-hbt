import { ComicDTO } from "./comic.dto";
import { ResultadoDTO } from "./resultado-dto";

export class ObtenerComicsDTO extends ResultadoDTO {
    
    public comicsList:Array<ComicDTO>

    constructor() {
        super()
    }
}