import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Employee } from '../employee';
import {Router} from '@angular/router';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

employee: Employee;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private employeeService: EmployeeService
  ) { }


  ngOnInit() {
    const employeeId = localStorage.getItem('editEmployeeId');
    console.log('employeeId----' + employeeId);


    if (!employeeId) {
      alert('Invalid action');
      this.router.navigate(['employee-list']);
      return ;
    }


    this.editForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
            age: ['', Validators.required],
              active: []

    });


 this.employeeService.getEmployee(employeeId).subscribe(data => {
    console.log('calling service ----' + employeeId);
          this.editForm.patchValue(data);
      });






  }

  onSubmit() {
     const employeeId = localStorage.getItem('editEmployeeId');
    console.log('employeeId----' + employeeId);
    this.employeeService.updateEmployeeRecord( employeeId ,this.editForm.value)
      .subscribe(
        data => {
          this.router.navigate(['employee-list']);
        },
        error => {
          alert(error);
        });
  }





  




}

