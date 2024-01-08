import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PinInputService {

  token:any;

  constructor(private http:HttpClient) { }

  updateAccStatus(user:any){
    this.token = localStorage.getItem("token");
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}` );
    return this.http.put("http://localhost:9000/users/active", user, {headers} );
  }
}
