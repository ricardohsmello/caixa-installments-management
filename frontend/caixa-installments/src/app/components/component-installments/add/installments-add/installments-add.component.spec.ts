import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstallmentsAddComponent } from './installments-add.component';

describe('InstallmentsAddComponent', () => {
  let component: InstallmentsAddComponent;
  let fixture: ComponentFixture<InstallmentsAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstallmentsAddComponent]
    });
    fixture = TestBed.createComponent(InstallmentsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
