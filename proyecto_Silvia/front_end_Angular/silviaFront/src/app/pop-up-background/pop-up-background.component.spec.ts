import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpBackgroundComponent } from './pop-up-background.component';

describe('PopUpBackgroundComponent', () => {
  let component: PopUpBackgroundComponent;
  let fixture: ComponentFixture<PopUpBackgroundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpBackgroundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpBackgroundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
