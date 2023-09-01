import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { PoMenuItem } from '@po-ui/ng-components';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private router: Router){}

  readonly menus: Array<PoMenuItem> = [
    { label: 'Países', shortLabel: 'Países', icon: 'po-icon-folder', action: this.onClick.bind(this, '/pais') },
    { label: 'Pontos Turísticos', shortLabel: 'P. Turísticos', icon: 'po-icon-finance-secure', action: this.onClick.bind(this, '/ponto-turistico') },
    { label: 'Comentários', shortLabel: 'Comentários', icon: 'po-icon po-icon-chat', action: this.onClick.bind(this, '/comentario') }
  ];

  private onClick(rota: string) {
    this.router.navigateByUrl(rota)
  }

}
