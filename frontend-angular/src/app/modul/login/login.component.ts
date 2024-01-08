import { ThisReceiver } from '@angular/compiler';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { HomeComponent } from '../home/home.component';
import { RegistrationService } from '../registration/registration.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hide = true;
  password!: string ;
  username!: string ;
  loggedUser: any;

  constructor(private service: LoginService, private router:Router, private authService: AuthService, 
    private registrationService: RegistrationService){}

  public onSubmit(){
    console.log("sdsdsd");
     this.service.findUser(this.username,this.password).subscribe((data: any) =>{
        this.loggedUser = data;
        localStorage.setItem("token",this.loggedUser.token);
        
        
        this.authService.username = this.username;
        this.service.getUserIdByUsername(this.username).subscribe((data:any) =>{

          this.authService.userId = data;
          this.service.getUserInformation(this.authService.userId).subscribe((data:any)=>{

            this.authService.userInfomation=data;
            this.authService.setLoggedUser(this.loggedUser);
            if(this.authService.userInfomation?.active){
              this.authService.setLoggedIn(true);
              this.service.insertInLogs(this.authService.username).subscribe((response)=>{
                this.router.navigateByUrl('');
              });
             
            }else{
              this.service.resendEmail(this.authService.userInfomation).subscribe((data:any)=>{
    
              })
              this.registrationService.setPin(this.authService.userInfomation?.pin.toString());
              //console.log(this.registrationService.getPin());
              this.router.navigateByUrl('/pin');
            }
          });
          
        });
        
        
        
        
     });
     
  }

  navigateOnHome(){
    this.router.navigateByUrl('');
  }
}
