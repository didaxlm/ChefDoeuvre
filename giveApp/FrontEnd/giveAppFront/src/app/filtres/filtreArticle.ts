/*import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TypeService} from '../../service/type.service';
import {take} from 'rxjs/operators';
import {Type} from '../../model/type';

@Component({
  selector: 'app-filtre-projets',
  templateUrl: './filtre-projets.component.html',
  styleUrls: ['./filtre-projets.component.css']
})
export class FiltreProjetsComponent implements OnInit {
  // public types = new FormControl();
  typeList: Type[] = [];
  @Output() typesChangeEmitter = new EventEmitter<any>();
  readonly ITEM_ALL = 'Tous les projets';

  // private subscription: Subscription = null;

  constructor(private typeService: TypeService) {
  }

  // public ngOnDestroy(): void {
  //   this.subscription.unsubscribe();
  // }

  public ngOnInit(): void {
    this.typeService.getAllTypes().pipe(take(1)).subscribe(
      {
        next: data => {
          this.typeList = data;
        },
        error: (data) => {
          console.log(data);
        },
        complete: () => {
        }
      });
    this.typesChangeEmitter.emit('Tous');
  }
}*/
