import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RouternavigationService {

  constructor(private router: Router) { }

  homeNavigate() {
    this.router.navigate(['/home'], {skipLocationChange: environment.show_url_routes}).then();
  }

  imprintNavigate() {
    this.router.navigate(['/imprint'], { skipLocationChange: environment.show_url_routes }).then();
  }

  usersettingsNavigate() {
    this.router.navigate(['/usersettings'], { skipLocationChange: environment.show_url_routes }).then();
  }

  logmanagementNavigate() {
    this.router.navigate(['/logmanagement'], { skipLocationChange: environment.show_url_routes }).then();
  }

  loginNavigate() {
    this.router.navigate(['/login'], { skipLocationChange: environment.show_url_routes }).then();
  }

  privacyPolicyNavigate() {
    this.router.navigate(['/privacy-policy'], { skipLocationChange: environment.show_url_routes }).then();
  }
}
