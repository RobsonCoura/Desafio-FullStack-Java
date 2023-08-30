import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';
import { triggerFormValidators } from 'src/app/shared/util';

@Component({
  selector: 'app-cadastro-pontos-turisticos',
  templateUrl: './cadastro-pontos-turisticos.component.html',
  styleUrls: ['./cadastro-pontos-turisticos.component.css']
})
export class CadastroPontosTuristicosComponent implements OnInit {

  idPontoTuristico: string;
	formPontoTuristico: FormGroup;
	title: string = "Novo cadastro de Ponto Turístico"
	constructor(private formBuilder: FormBuilder,
		private poNotification: PoNotificationService,
		private route: ActivatedRoute,
		private router: Router,
		private http: HttpService
		) {

		this.formPontoTuristico = this.formBuilder.group({
			nome: ['', Validators.compose([Validators.required])],
			paisId: ['', Validators.compose([Validators.required])],
			cidade: ['', Validators.compose([Validators.required])],
			estacaoVisita: [, Validators.compose([Validators.required])]
		})
	}

	ngOnInit(): void {
		this.idPontoTuristico = this.route.snapshot.paramMap.get('idPontoTuristico');
		if (this.idPontoTuristico !== null && this.idPontoTuristico !== ""){
			this.buscaDadosPontoTuristico()
			this.title = "Alteração do Ponto Turístico"
		}
	}

	salvar(){
		if (this.validarRegistro()){
			if (this.idPontoTuristico === null || this.idPontoTuristico === ""){
				this.enviarPost()
			} else {
				this.enviarPut()
			}
		} else {
			this.poNotification.error("Preencha todos os campos antes de salvar as alterações!")
		}
	}

	voltar(){
		this.router.navigate(['/ponto-turistico'], { relativeTo: this.route })
	}

	validarRegistro(): boolean{
		return this.formPontoTuristico.valid;
	}

	enviarPost(){
		this.http.post('pontoturistico',this.formPontoTuristico.value).subscribe({
			next:(resposta) => {
				this.poNotification.success("Registro criado com sucesso!");
				this.voltar();
			},
			error:(erro) => {
				this.poNotification.error(erro)
			},
		})
	}

	enviarPut(){
		this.http.put('pontoturistico/' + this.idPontoTuristico,this.formPontoTuristico.value).subscribe({
			next:(resposta) => {
				this.poNotification.success("Registro atualizado com sucesso!");
				this.voltar();
			},
			error:(erro) => {
				this.poNotification.error(erro)
			},
		})
	}

	buscaDadosPontoTuristico(){
		this.http.get('pontoturistico/' + this.idPontoTuristico).subscribe({
			next: (resposta)=>{
				this.formPontoTuristico.patchValue({
	        id: resposta.id,
	        paisId: resposta.paisId,
	        cidade: resposta.cidade,
	        nome: resposta.nome,
	        estacaoVisita: resposta.estacaoVisita
				})
			},
			error: (erro)=>{
				this.poNotification.error(erro)
			}
		})
	}
}

