import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpTratamientoComponent } from './pop-up-tratamiento.component';

describe('PopUpTratamientoComponent', () => {
  let component: PopUpTratamientoComponent;
  let fixture: ComponentFixture<PopUpTratamientoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpTratamientoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpTratamientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
