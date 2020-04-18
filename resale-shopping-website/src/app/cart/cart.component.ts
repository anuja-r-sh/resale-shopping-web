import { Component, OnInit } from '@angular/core';
import { Car } from '../model/car';
import { InteractionService } from '../services/interaction.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: Car[] = [];
  totalPrice: number = 0;
  constructor(private interactionService: InteractionService) { }

  ngOnInit(): void {
    this.interactionService.addedCartItem$.subscribe(car => {
      this.cart.push(car);
      this.totalPrice += Number(car.price);
    });
    this.interactionService.removedCartItem$.subscribe(car => {
      this.cart.push(car);
      this.totalPrice -= Number(car.price);
      this.cart = this.cart.filter((item) => {
        return item.id != car.id;
      });
    });

  }

}
