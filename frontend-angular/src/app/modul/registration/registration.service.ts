import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  token:any;
  private pin: string | undefined;
  
  constructor(private http: HttpClient) { }

  postUser(user:any) {
    // this.token = localStorage.getItem("token");
    // const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}` );
    return this.http.post("http://localhost:9000/users",user);
    //console.log(user);
  }

  getPin(){
    return this.pin;
  }

  setPin(pin:string){
    this.pin = pin;
  }
}
