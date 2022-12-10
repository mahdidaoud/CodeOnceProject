import { Component } from '@angular/core';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-new-category',
  templateUrl: './new-category.component.html',
  styleUrls: ['./new-category.component.css']
})
export class NewCategoryComponent {

  constructor(private catService: CategoryService) { }
  ngOnInit() {

  }

  OnSaveCategory(data: any) {
    this.catService.addCategory(data).subscribe(res => {
      console.log(res);
    }, err => {
      console.log(err);
    })
  }
}
