import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';
import { PontosTuristicos } from '../pontos-turisticos.component';

@Component({
  selector: 'app-visualizar-pontos-turisticos',
  templateUrl: './visualizar-pontos-turisticos.component.html',
  styleUrls: ['./visualizar-pontos-turisticos.component.css'],
})
export class VisualizarPontosTuristicosComponent implements OnInit {
  public list = [1,2]

  idPontoTuristico: string;
  pontoTuristico: PontosTuristicos;
  title: string;
  constructor(
    private poNotification: PoNotificationService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpService
  ) {}

  ngOnInit(): void {
    this.idPontoTuristico =
      this.route.snapshot.paramMap.get('idPontoTuristico');
    if (this.idPontoTuristico !== null && this.idPontoTuristico !== '') {
      this.buscaDadosPontoTuristico();
    }
  }

  voltar() {
    this.router.navigate(['/ponto-turistico'], { relativeTo: this.route });
  }

criaMensagem() {
	return `O ponto turístico ${this.title}, está localizado no(a) ${this.pontoTuristico.paisId} e a melhor estação para visitá-lo é no(a) ${this.pontoTuristico.estacaoVisita}.`;
}

  buscaDadosPontoTuristico() {
    this.http.get('pontoturistico/' + this.idPontoTuristico).subscribe({
      next: (resposta) => {
        this.pontoTuristico = resposta;
        this.title = resposta.nome;
      },
      error: (erro) => {
        this.poNotification.error(erro);
      },
    });
  }
}
