import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstallmentsComponent } from './installments-list.component';

describe('InstallmentsComponent', () => {
  let component: InstallmentsComponent;
  let fixture: ComponentFixture<InstallmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstallmentsComponent]
    });
    fixture = TestBed.createComponent(InstallmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
