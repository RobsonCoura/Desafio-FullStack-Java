import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {
  PoNotificationService,
  PoTableAction,
  PoTableColumn,
} from '@po-ui/ng-components';
import { HttpService } from '../service/http-service.service';
import { Pais } from '../paises/paises.component';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css'],
})
export class PontosTuristicosComponent implements OnInit {
  lsActions: Array<PoTableAction> = this.carregarActions();
  lsColumns: Array<PoTableColumn> = this.carregarColunas();
  lsPontosTuristicos: Array<PontosTuristicos> = [];

  constructor(
    private httpService: HttpService,
    private poNotification: PoNotificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private http: HttpService
  ) {}

  ngOnInit(): void {
    this.carregarPontosTuristicos();
  }

  carregarActions(): Array<PoTableAction> {
    return [
      {
        label: 'Visualizar',
        icon: 'po-icon-eye',
        action: (row: PontosTuristicos) => {
          this.navegarParaVisualizar(row.id);
        },
      },
      {
        label: 'Editar',
        icon: 'po-icon-edit',
        action: (row: PontosTuristicos) => {
          this.navegarParaCadastro(row.id);
        },
      },
      {
        label: 'Excluir',
        icon: 'po-icon-delete',
        action: (row: PontosTuristicos) => {
          this.deletarCadastro(row.id);
        },
      },
    ];
  }

  deletarCadastro(id: string): void {
    this.httpService.delete('pontoturistico/' + id).subscribe({
      next: (response) => {
        this.poNotification.success('Registro excluido com sucesso!');
        this.carregarPontosTuristicos();
      },
      error: (error) => {
        this.poNotification.error(error);
      },
    });
  }

  navegarParaCadastro(codigoPontoTuristico: string = '') {
    this.router.navigate(['cadastro', codigoPontoTuristico], {
      relativeTo: this.activatedRoute,
    });
  }

  navegarParaVisualizar(codigoPontoTuristico: string = '') {
    this.router.navigate([codigoPontoTuristico], {
      relativeTo: this.activatedRoute,
    });
  }

  carregarPontosTuristicos() {
    return this.httpService.get('pontoturistico').subscribe({
      next: (resposta) => {
        let registros: Array<PontosTuristicos> = [];
        resposta.forEach((item) => {
          let novoPontoTuristico: PontosTuristicos = {
            id: item.id,
            pais: item.pais[0]?.nome ?? '',
            cidade: item.cidade,
            nome: item.nome,
            estacaoVisita: item.estacaoVisita,
          };
          registros.push(novoPontoTuristico);
        });

        this.lsPontosTuristicos = [...registros];
        console.log(this.lsPontosTuristicos);
      },
    });
  }

  carregarColunas(): Array<PoTableColumn> {
    return [
      {
        property: 'pais',
        label: 'País',
      },
      {
        property: 'cidade',
        label: 'Cidade',
      },
      {
        property: 'nome',
        label: 'Nome',
      },
      {
        property: 'estacaoVisita',
        label: 'Estação Visita',
      },
    ];
  }
}

export interface PontosTuristicos {
  id: string;
  paisId?: string;
  pais: Pais[];
  cidade: string;
  nome: string;
  estacaoVisita: string;
}
