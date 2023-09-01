import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const api = 'http://localhost:8080/'

@Injectable({
  providedIn: 'root'
})
export class HttpService {

	constructor(private http: HttpClient) { }

	get(url: string): Observable<any>{
		return this.http.get(api + url)
	}

	post(url: string, body: any): Observable<any>{
		return this.http.post(api + url, body)
	}

	put(url: string, body: any): Observable<any>{
		return this.http.put(api + url, body)
	}

	delete(url: string): Observable<any>{
		return this.http.delete(api + url)
	}

	getCountry(): Observable<any> {
		return this.http.get(api + '/pais')
	}

	getComentario(idComentario: string | number): Observable<any> {
		return this.http.get(`${api}/pontoturistico/${idComentario}`)
	}
}
