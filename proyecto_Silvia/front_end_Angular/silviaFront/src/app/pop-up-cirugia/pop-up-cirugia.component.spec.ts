import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpCirugiaComponent } from './pop-up-cirugia.component';

describe('PopUpCirugiaComponent', () => {
  let component: PopUpCirugiaComponent;
  let fixture: ComponentFixture<PopUpCirugiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpCirugiaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpCirugiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
