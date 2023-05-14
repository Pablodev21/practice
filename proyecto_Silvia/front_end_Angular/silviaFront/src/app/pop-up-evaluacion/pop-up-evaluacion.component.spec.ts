import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpEvaluacionComponent } from './pop-up-evaluacion.component';

describe('PopUpEvaluacionComponent', () => {
  let component: PopUpEvaluacionComponent;
  let fixture: ComponentFixture<PopUpEvaluacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpEvaluacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpEvaluacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
