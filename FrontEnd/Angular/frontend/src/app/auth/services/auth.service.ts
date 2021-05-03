import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthToken } from '../models/auth-token';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url : string = `${environment.API_URI}/autenticacao`;
  /**ele é o intermediário */
  public authSubject = new Subject<boolean>();

  constructor(private http: HttpClient) { }

  public login( credential : Credential ){
    return this.http.post<AuthToken>( this.url, credential );
  }

  public sendMessage(msg : boolean){
    this.authSubject.next(msg);
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 12af9422d34615860a26f56e88c533f6c0000436
