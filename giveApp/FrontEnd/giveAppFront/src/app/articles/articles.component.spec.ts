import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticlesComponent } from './articles.component';
import {ActivatedRoute} from "@angular/router";
import {ArticleServices} from "../partage/services/article.services";
import {JwtService} from "../partage/jwt/jwt.service";

describe('ArticlesComponent', () =>
{
  let component: ArticlesComponent;
  let fixture: ComponentFixture<ArticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticlesComponent ],
      imports: [],
      providers: [ActivatedRoute, ArticleServices, JwtService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

