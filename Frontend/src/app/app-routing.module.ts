import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { NewCategoryComponent } from './new-category/new-category.component';
import { NewProductComponent } from './new-product/new-product.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  {
    path: "Category",
    component: CategoryComponent
  },

  {
    path: "new-category",
    component: NewCategoryComponent
  },
  {
    path: "Product",
    component: ProductComponent
  },
  {
    path: "new-product",
    component: NewProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
