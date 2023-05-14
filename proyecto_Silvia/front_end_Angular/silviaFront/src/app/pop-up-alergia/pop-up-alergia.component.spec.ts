import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpAlergiaComponent } from './pop-up-alergia.component';

describe('PopUpAlergiaComponent', () => {
  let component: PopUpAlergiaComponent;
  let fixture: ComponentFixture<PopUpAlergiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpAlergiaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpAlergiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
