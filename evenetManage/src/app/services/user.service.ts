import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class UserService {

  constructor(private _http: Http) { }

  register(user){
  const headers = new Headers();
 headers.set("Access-Control-Allow-Origin", "*");
          headers.set("Access-Control-Allow-Headers", "*");
          headers.set("Access-Control-Allow-Methods", "*");
        return this._http.post('http://localhost:6565/user/register' , user, { headers: headers}).map(res => res.text());
   }

  login(user){
            console.log('in login user--->' + user);

  
  const headers = new Headers();

    headers.append('Content-type' , 'application/json');

          headers.set("Access-Control-Allow-Origin", "*");
          headers.set("Access-Control-Allow-Headers", "*");
          headers.set("Access-Control-Allow-Methods", "*");


                console.log(' in  login before return');
    return this._http.post('http://localhost:6565/user/login/' + user.email + '/' + user.password , {headers: headers});
 }
}
