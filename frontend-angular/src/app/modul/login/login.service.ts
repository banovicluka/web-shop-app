import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { timestamp } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  token: any;

  
  constructor(private http: HttpClient) {
  }

  findUser(username: string,password: string){
    const body = { username, password};
    return this.http.post("http://localhost:9000/api/login",body);
  }

  getUserIdByUsername(username: string){
    this.token = localStorage.getItem("token");
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}` );
    return this.http.get("http://localhost:9000/users/" + username + "/id", {headers})
  }

  getUserInformation(userId: number) {
    this.token = localStorage.getItem("token");
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}` );
    return this.http.get("http://localhost:9000/users/" + userId, {headers});
  }

  resendEmail(user: any){
    this.token = localStorage.getItem("token");
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}` );
    return this.http.post("http://localhost:9000/users/email", user, {headers});
  }

  insertInLogs(username:string){
    const currentDate = new Date();

    const body = {
      date: currentDate.toISOString(),
      action: 'login',
      username: username
    };
    return this.http.post("http://localhost:9000/logs",body, {responseType:'text'});
  }
}
