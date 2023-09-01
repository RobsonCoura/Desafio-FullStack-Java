import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PoButtonModule, PoModule } from '@po-ui/ng-components';
import { RouterModule } from '@angular/router';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { ComentariosComponent } from './comentarios/comentarios.component';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';
import { PoTemplatesModule } from '@po-ui/ng-templates';
import { ReactiveFormsModule } from '@angular/forms';
import { VisualizarPontosTuristicosComponent } from './pontos-turisticos/visualizar-pontos-turisticos/visualizar-pontos-turisticos.component';

@NgModule({
  declarations: [
    AppComponent,
    PaisesComponent,
    CadastroPaisesComponent,
    PontosTuristicosComponent,
    CadastroPontosTuristicosComponent,
    ComentariosComponent,
    CadastroComentarioComponent,
    VisualizarPontosTuristicosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    PoModule,
    RouterModule.forRoot([]),
    PoTemplatesModule,
    PoButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
