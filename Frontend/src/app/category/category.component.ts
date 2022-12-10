import { Component } from '@angular/core';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {

  public Category: any = undefined;

  constructor(private catService: CategoryService) { }

  ngOnInit() { }

  onGetCategory() {
    this.catService.getCategory().subscribe(data => {
      this.Category = data;
    }, err => {
      console.log(err);
    })
  }
  onDeleteCategory(data: any) {
    this.catService.DeleteCategory(data).subscribe(data => {
      window.location.reload();


    }, err => {
      console.log(err);
    });;

  }



}
