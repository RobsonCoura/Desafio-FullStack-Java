import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoTableAction, PoTableColumn } from '@po-ui/ng-components';
import { map, tap } from 'rxjs';
import { HttpService } from '../service/http-service.service';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {

  lsActions: Array<PoTableAction> = this.carregarActions();
	lsColumns: Array<PoTableColumn> = this.carregarColunas();
	lsPontosTuristicos: Array<PontosTuristicos> = []

	constructor(
		private httpService: HttpService,
		private poNotification: PoNotificationService,
		private router: Router,
		private activatedRoute: ActivatedRoute) { }

	ngOnInit(): void {
		this.carregarPontosTuristicos()
	}

	carregarActions(): Array<PoTableAction> {
		return [
			{
				label: 'Editar',
				icon: 'po-icon-edit',
				action: (row: PontosTuristicos)=>{ this.navegarParaCadastro(row.id) }
			},
			{
				label: 'Excluir',
				icon: 'po-icon-delete',
				action: (row: PontosTuristicos)=>{ this.deletarCadastro(row.id) }
			}
		]
	}

	deletarCadastro(id: string): void {
		this.httpService.delete('pontoturistico/' + id).subscribe({
			next: (response)=>{
				this.poNotification.success('Registro excluido com sucesso!');
				this.carregarPontosTuristicos();
			},
			error: (error)=>{
				this.poNotification.error(error);
			}
		})
	}

	navegarParaCadastro(codigoPontoTuristico: string = ""){
		console.log(this.router.url)
this.router.navigate(['cadastro', codigoPontoTuristico], { relativeTo: this.activatedRoute });
	}

	carregarPontosTuristicos(){
		return this.httpService.get('pontoturistico').subscribe({
			next: (resposta)=>{
			console.log(resposta)
				let registros: Array<PontosTuristicos> = []
				resposta.forEach(item => {
					let novoPontoTuristico: PontosTuristicos = {
							id: item.id,
            	paisId: item.paisId,
            	cidade: item.cidade,
            	nome: item.nome,
            	estacaoVisita: item.estacaoVisita
					}
					registros.push(novoPontoTuristico);
				});

				this.lsPontosTuristicos = [...registros]
			}
		})
	}

	carregarColunas(): Array<PoTableColumn>{
		return [
			{
				property: 'paisId',
				label: 'País'
			},
			{
				property: 'cidade',
				label: 'Cidade',
			},
			{
				property: 'nome',
				label: 'Nome'
			},
			{
				property: 'estacaoVisita',
				label: 'Estação Visita'
			}
		]
	}
}

interface PontosTuristicos{
	id: string,
	paisId: string,
	cidade: string,
	nome: string,
	estacaoVisita: string
}

