import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { EmployeesListComponent } from './employees/employee-list/employees-list.component';
import { EmployeeDetailsComponent } from './employees/employee-details/employee-details.component';
import { CreateEmployeeComponent } from './employees/create-employee/create-employee.component';

import { EmployeeService } from './employees/employee.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesListComponent,
    EmployeeDetailsComponent,
    CreateEmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})

export class AppModule { }
