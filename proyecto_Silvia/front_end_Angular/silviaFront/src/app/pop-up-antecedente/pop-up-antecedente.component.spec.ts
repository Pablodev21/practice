import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpAntecedenteComponent } from './pop-up-antecedente.component';

describe('PopUpAntecedenteComponent', () => {
  let component: PopUpAntecedenteComponent;
  let fixture: ComponentFixture<PopUpAntecedenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpAntecedenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpAntecedenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
