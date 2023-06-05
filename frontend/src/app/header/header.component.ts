import { Component } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService
    ) { }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public defaultUser() {
    window.alert(
      "Here are demo user for login :"+
      "\n -> Admin: \n username: admin123 \n password: Pass@123" +
      "\n -> Staff: \n username: staff123 \n   password: Pass@123" +
      "\n -> Customer: \n username: customer123 \n password: Pass@123" +
      "\n \n Click on login to view demo users again")
  }

  public logout() {
    this.userAuthService.clearLocalStorage();
    this.router.navigate(['/']);
  }
}
