import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpObservacionComponent } from './pop-up-observacion.component';

describe('PopUpObservacionComponent', () => {
  let component: PopUpObservacionComponent;
  let fixture: ComponentFixture<PopUpObservacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpObservacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpObservacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
