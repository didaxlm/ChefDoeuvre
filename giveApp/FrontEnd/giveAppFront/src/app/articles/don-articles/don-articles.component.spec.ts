import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonArticlesComponent } from './don-articles.component';

describe('DonArticlesComponent', () => {
  let component: DonArticlesComponent;
  let fixture: ComponentFixture<DonArticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonArticlesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
