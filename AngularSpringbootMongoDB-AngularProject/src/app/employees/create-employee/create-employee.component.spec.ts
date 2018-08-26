import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateemployeeComponent } from './create-employee.component';

describe('CreateemployeeComponent', () => {
  let component: CreateemployeeComponent;
  let fixture: ComponentFixture<CreateemployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateemployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateemployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
