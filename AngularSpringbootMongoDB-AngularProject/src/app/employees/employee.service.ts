import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Employee } from './employee';

@Injectable()
export class EmployeeService {

  private baseUrl = 'http://localhost:7070/api/employees';

  constructor(private http: HttpClient) { }

  getEmployee(id: string): Observable<Object> {
   console.log('this.baseUrl---'+this.baseUrl);
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
       console.log('employee--'+employee);
    return this.http.post(`${this.baseUrl}/create`, employee);
  }

   updateEmployeeRecord(id: string,  employee: Employee): Observable<Object> {
     console.log(' url is ------>>>>>  '  +`${this.baseUrl}/updateRecord/${id}` + '--for---' + id);

    return this.http.put(`${this.baseUrl}/updateRecord/${id}`, employee);
  }

  updateEmployee(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  deleteEmployee(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getEmployeesList(query = {}): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete`, { responseType: 'text' });
  }
}
