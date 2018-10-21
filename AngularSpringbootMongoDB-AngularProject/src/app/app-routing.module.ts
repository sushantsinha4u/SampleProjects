import { CreateEmployeeComponent } from './employees/create-employee/create-employee.component';
import { EditEmployeeComponent } from './employees/edit-employee/edit-employee.component';
import { EmployeesListComponent } from './employees/employee-list/employees-list.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees', component: EmployeesListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'edit-employee', component: EditEmployeeComponent },
  { path: 'employee-list', component: EmployeesListComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
