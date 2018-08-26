import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Address } from './user';
import { Post } from './post';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
name: string ;
  age: number ;
  address: Address;
  posts: Post[];
  isEdit:boolean=false;
  hobbies: string[];

  constructor(private dataService:DataService) { 
  console.log('In constructor');
  }

  ngOnInit() {
      console.log('In ngOnInit');
    this.name = 'Sushant';
    this.age = 36;
    this.address = {
  streetno: 12,
  streetname: 'Rue du laboratoire',
  pincode: 1911,
  city: 'Luxembourg',
   country: 'Luxembourg'
    };
    this.hobbies = ['playing cricket', 'watching marvel movies'];
    
    
    this.dataService.getPosts().subscribe((posts) => {
            console.log('In getpost');

    console.log(posts);
      this.posts=posts;
    });
    
    
   
  }
  
 onClick(){
    this.name = 'Ravi'
   this.hobbies.push('playing football');
   
  }
  
  addHobby(hobby){
   this.hobbies.unshift(hobby);
    return false; 
      }
  
  toggleEdit(){
    this.isEdit =!this.isEdit
  }
    

     deleteHobby(hobby){
       for(let i=0 ;i<this.hobbies.length;i++){
       if(this.hobbies[i]==hobby){
       this.hobbies.splice(i,1);
      
       }
     }
 }
  
}