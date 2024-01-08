import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { KomponentaComponent } from './modul/komponenta/komponenta.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ip2023';

  constructor(private router : Router){}

  // loginClicked(){
  //   this.router.navigate(['/login']);
  // }
}
