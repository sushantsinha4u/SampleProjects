import { Component, OnInit, Input } from '@angular/core';

import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

import { EmployeesListComponent } from '../employee-list/employees-list.component';

@Component({
  selector: 'employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  @Input() employee: Employee;

  constructor(private employeeService: EmployeeService, private listComponent: EmployeesListComponent) { }

  ngOnInit() {
  }

  updateActive(isActive: boolean) {
    this.employeeService.updateEmployee(this.employee.id,
      { name: this.employee.name, age: this.employee.age, active: isActive })
      .subscribe(
      data => {
        console.log(data);
        this.employee = data as Employee;
      },
      error => console.log(error));
  }

  deleteEmployee() {
    this.employeeService.deleteEmployee(this.employee.id)
      .subscribe(
      data => {
        console.log(data);
        this.listComponent.reloadData();
      },
      error => console.log(error));
  }

}
