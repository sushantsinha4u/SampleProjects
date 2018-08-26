import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private userService: UserService, private _route: Router) { }

  ngOnInit() {
  }

 onLogoutSubmit() {
  }
  
}
