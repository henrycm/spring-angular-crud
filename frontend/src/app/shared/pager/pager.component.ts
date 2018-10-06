import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PagerService } from './pager.service';

@Component({
  selector: 'app-pager',
  templateUrl: './pager.component.html',
  providers: [PagerService]
})
export class PagerComponent implements OnInit {
  @Input() url;
  @Input() data = {};
  @Output() callBack: EventEmitter<any> = new EventEmitter<any>();

  constructor(private pagerService: PagerService) { }

  ngOnInit() {
    console.log("Page for:" + this.url);
    this.navigate(0);
  }

  navigate(page) {
    if( (this.data["number"] == page) ){
      return false;
    }

    console.log("Page:" + page);
    this.pagerService
      .getPage(this.url, page)
      .subscribe(d => {
        this.data = d;
        this.callBack.emit(d.content);
      } );
  }

  getPagesArray(size){
    let res = [];
    for (let i = 0; i < size; i++) {
        res.push(i);
      }
    return res;
  }

}
