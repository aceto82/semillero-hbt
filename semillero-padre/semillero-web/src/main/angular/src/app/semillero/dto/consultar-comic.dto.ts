import { ComicDTO } from "./comic.dto";
import { ResultadoDTO } from "./resultado-dto";

export class ConsultarComicDTO extends ResultadoDTO {

    public comic: ComicDTO

    constructor() {
        super()
    }
}