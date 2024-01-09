import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentDialogConfirmComponent } from './component-dialog-confirm.component';

describe('ComponentDialogConfirmComponent', () => {
  let component: ComponentDialogConfirmComponent;
  let fixture: ComponentFixture<ComponentDialogConfirmComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComponentDialogConfirmComponent]
    });
    fixture = TestBed.createComponent(ComponentDialogConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
