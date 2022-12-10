import { Component } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent {
  constructor(private prodService: ProductService) { }
  ngOnInit() {

  }

  OnSaveProduct(data: any) {
    this.prodService.addProduct(data).subscribe(res => {
      console.log(res);
    }, err => {
      console.log(err);
    })
  }
}
