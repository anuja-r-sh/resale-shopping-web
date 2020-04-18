import { Component, OnInit, Input } from '@angular/core';
import { Car } from '../model/car';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {

  @Input() car: Car;
  constructor() { }

  ngOnInit(): void {
  }

  removeFromCart(car) {

  }

}
