import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndivDataComponent } from './indiv-data.component';

describe('IndivDataComponent', () => {
  let component: IndivDataComponent;
  let fixture: ComponentFixture<IndivDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IndivDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IndivDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
