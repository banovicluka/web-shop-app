import { Component, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { throwToolbarMixedModesError } from '@angular/material/toolbar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { ContentService } from 'src/app/content/content.service';
import { PublishAdModalComponent } from 'src/app/content/publish-ad-modal/publish-ad-modal.component';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  //longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog`;
  loggedUser: any;
  products:any[] = [];
  loggedIn: boolean = false;
  isSideNavigationOpen:boolean=false;
  
  // suggestions:string[]=[];
  // searchText:string="";
  
  constructor(private service: HomeService, private authService: AuthService, private router: Router, private contentService: ContentService
    ,private dialog: MatDialog){
    
    this.loggedUser = this.authService.getLoggedUser();
  }

  isLoggedIn(){
    return this.authService.isLoggedIn();
  }

  toggleSideNavigation(){
    this.isSideNavigationOpen = !this.isSideNavigationOpen;
  }

  profileNavigator(tabIndex: number){
      this.contentService.activeTab = tabIndex;
  }

  logout(){
    this.authService.setLoggedUser(null);
    this.authService.setLoggedIn(false);
    this.authService.userId=0;
    this.authService.userInfomation=null;
    this.authService.username="";
    this.router.navigateByUrl("/login");
    localStorage.clear();
  }

  goOnHomepage(){
    this.router.navigateByUrl("");
  }

  navigateOnHome(){
    this.router.navigateByUrl("");
  }

  onUserSuportIconClick(){
    this.router.navigateByUrl("/user-support");
  }

  // openPublishModal(){
  //   const dialogRef = this.dialog.open(PublishAdModalComponent,{
  //     // width:'400px'
  //   });
  // }

  // getSuggestions(){
  //   this.service.getSuggestions(this.searchText).subscribe((data:any)=>{
  //     this.suggestions=data;
  //   })
  // }


  // onCardClick(id:any){
  //   this.router.navigate(['/product', id]);
  // }


  // ngOnInit(){
  //   this.getAllProducts();
  // }
 
  // getAllProducts(){
  //   this.service.getAllProducts().subscribe((data: any) => {
  //   this.products=data;
  // });


  
}
