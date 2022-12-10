import { Component } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  public Products: any = undefined;

  constructor(private prodService: ProductService) { }

  ngOnInit() { }

  onGetProdByCat(param: any) {
    this.prodService.getProdByCat(param).subscribe(data => {
      this.Products = data;
    }, err => {
      console.log(err);
    })
  }
  onDeleteProduct(data: any) {
    this.prodService.deleteproduct(data).subscribe(data => {
      window.location.reload();

    }, err => {
      console.log(err);
    });;

  }
}
