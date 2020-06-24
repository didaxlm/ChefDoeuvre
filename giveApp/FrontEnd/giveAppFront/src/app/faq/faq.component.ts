import { Component, OnInit } from '@angular/core';
import {FaqModel} from '../partage/models/faqModel';
import {FaqService} from '../partage/services/faq.service';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {

  faqDetails: FaqModel[];

  constructor(private faqService: FaqService) { }

  ngOnInit(): void {
    this.faqService.getAllFaq().subscribe(faqs => {
      this.faqDetails = faqs;
    });
  }

}
