import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Rx';



@Injectable()
export class DataService {

  constructor(public http:Http) {
    console.log("Dataservice connected ");
  }

  
  getPosts(){
    return this.http.get("https://jsonplaceholder.typicode.com/posts")
    .map(response => response.json());  
  }
}
