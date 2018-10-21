import { Component, OnInit,Input } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Router} from "@angular/router";
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'employee-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {
    @Input() employee: Employee;

  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService, private router: Router) {

  }

  ngOnInit() {
    this.reloadData();
  }

  deleteEmployees() {
    this.employeeService.deleteAll()
      .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log('ERROR: ' + error));
  }


  deleteEmployee(employee: Employee): void {
    this.employeeService.deleteEmployee(employee.id)
      .subscribe( data => {
 console.log(data);
        this.reloadData();
            },
            error => console.log(error));
  }


updateActive(employee: Employee, isActive: boolean) {
    this.employeeService.updateEmployee(employee.id,
      { name: employee.name, age: employee.age, active: isActive })
      .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

 editEmployee(employee: Employee): void {
           console.log('In editEmployee methiod');
       localStorage.removeItem("editEmployeeId");

    localStorage.setItem("editEmployeeId", employee.id.toString());
    this.router.navigate(['edit-employee']);
  };


  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }
}
