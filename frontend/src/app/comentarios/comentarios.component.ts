import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoTableColumn } from '@po-ui/ng-components';
import { map, tap } from 'rxjs';
import { HttpService } from '../service/http-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-comentarios',
  templateUrl: './comentarios.component.html',
  styleUrls: ['./comentarios.component.css'],
})
export class ComentariosComponent implements OnInit {
  public list = [1, 2];
  @Input() idPontoTuristico: string;

  inputComentarioVisivel: boolean = false;

	formComentario: FormGroup;
  lsComentarios: Array<Comentarios> = [];

  constructor(
    private httpService: HttpService,
    private poNotification: PoNotificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
  ) {
		this.formComentario = this.formBuilder.group({
      comentario: ['', Validators.compose([Validators.required])],
    });
	}

  ngOnInit(): void {
    this.carregarComentarios();
  }

  habilitarInputParaComentario(codigoComentario: string = '') {
    this.inputComentarioVisivel = true;
  }

  enviarPost() {
    this.httpService.post('comentario',this.formComentario.value).subscribe({
    	next:(resposta) => {
    		this.poNotification.success("Registro criado com sucesso!");
    		this.inputComentarioVisivel = false;
    	},
    	error:(erro) => {
    		this.poNotification.error(erro)
    	},
    })
  }

  carregarComentarios() {
    return this.httpService
      .get(`comentarios/${this.idPontoTuristico}/pontoTuristico`)
      .subscribe({
        next: (resposta) => {
          console.log(resposta);
          let registros: Array<Comentarios> = [];
          resposta.forEach((item) => {
            let novoComentario: Comentarios = {
              id: item.id,
              pontoTuristicoId: item.pontoTuristicoId,
              descricao: item.descricao,
              nomeDoAutor: item.nomeDoAutor,
              dataDaCriacao: item.dataDaCriacao,
            };
            registros.push(novoComentario);
          });

          this.lsComentarios = [...registros];
        },
      });
  }
}

interface Comentarios {
  id: string;
  pontoTuristicoId: string;
  descricao: string;
  nomeDoAutor: string;
  dataDaCriacao: string;
}
