import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { StorageService } from 'src/app/shared/services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(private storageService : StorageService, private router:Router) { }

  canActivate() : boolean {
    let usuario = this.storageService.getLocalUser();

<<<<<<< HEAD
    if (usuario.scopes && usuario.scopes.includes('ROLE_ADMIN')){
      return true;
    
    }else{
=======
    const helper = new JwtHelperService();
    let decodedToken = helper.decodeToken ( usuario.token );

    if (decodedToken.scopes && decodedToken.scopes.includes('ROLE_ADMIN')){
      return true;
    }
    else{
>>>>>>> 12af9422d34615860a26f56e88c533f6c0000436
      this.router.navigate(['auth/login']);
    }
    
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 12af9422d34615860a26f56e88c533f6c0000436
