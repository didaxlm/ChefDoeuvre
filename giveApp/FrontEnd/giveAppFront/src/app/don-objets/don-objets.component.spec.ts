import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonObjetsComponent } from './don-objets.component';

describe('DonObjetsComponent', () => {
  let component: DonObjetsComponent;
  let fixture: ComponentFixture<DonObjetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonObjetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonObjetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
