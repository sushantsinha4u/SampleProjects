import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

   email: string;
  password: string;

  constructor(private userService: UserService, private _route: Router) { }

  ngOnInit() {
  }


   onLoginSubmit() {
    const user = {
     email : this.email,
     password : this.password
     }
             console.log('before calling login in login com ts  -->'+user);
             console.log('email  -->'+user.email);
             console.log('password  -->'+ user.password);

    this.userService.login(user).subscribe(data=>{
                   console.log('data  -->  '+data);

        console.log('data._body--->' + data["_body"]);
    if (data["_body"] == "" ) {
    alert('Login or password is incorrect !!');
    } else {
sessionStorage.setItem('user', JSON.stringify(data));
      this._route.navigate(['/profile']);
      }
    });
  }
 }
