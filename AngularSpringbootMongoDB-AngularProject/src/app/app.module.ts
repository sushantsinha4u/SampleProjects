import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { EmployeesListComponent } from './employees/employee-list/employees-list.component';
import { CreateEmployeeComponent } from './employees/create-employee/create-employee.component';

import { EmployeeService } from './employees/employee.service';
import { EditEmployeeComponent } from './employees/edit-employee/edit-employee.component';
import { SharedComponent } from './shared/shared/shared.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesListComponent, 
    CreateEmployeeComponent,
    EditEmployeeComponent,
    SharedComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})

export class AppModule { }
