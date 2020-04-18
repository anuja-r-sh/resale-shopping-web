import { Component, OnInit } from '@angular/core';
import { Car } from '../model/car';
import { InteractionService } from '../services/interaction.service';
import { ResaleService } from '../services/resale.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: Car[] = [];
  totalPrice: number = 0;
  isCheckedOut = false;
  constructor(private interactionService: InteractionService, private resaleService: ResaleService) { }

  ngOnInit(): void {

    // saving the session in the local storage
    const cart = localStorage.getItem("resale-shopping-car-cart");
    if (cart) {
      this.cart = JSON.parse(cart);
      this.cart.forEach(car => {
        this.addToTotalPrice(car.price);
      });
    }


    this.interactionService.addedCartItem$.subscribe(car => {
      this.cart.push(car);
      this.addToTotalPrice(car.price);
      localStorage.setItem("resale-shopping-car-cart", JSON.stringify(this.cart));
    });

    this.interactionService.removedCartItem$.subscribe(car => {
      this.subtractTotalPrice(car.price);
      this.cart = this.cart.filter((item) => {
        return item.id != car.id;
      });
      localStorage.setItem("resale-shopping-car-cart", JSON.stringify(this.cart));
    });

  }

  private addToTotalPrice(price) {
    this.totalPrice += Number(price);
    this.totalPrice = Number(this.totalPrice.toFixed(3));
  }

  private subtractTotalPrice(price) {
    this.totalPrice -= Number(price);
    this.totalPrice = Number(this.totalPrice.toFixed(3));
  }

  checkout() {
    this.isCheckedOut = true;
    let sessionId = localStorage.getItem("sessionId");
    if (!sessionId) {
      sessionId = "" + new Date().getTime() + Math.random() * 100;
      localStorage.setItem("sessionId", sessionId);
    }
    this.resaleService.checkout(this.cart, sessionId).subscribe((data) => {
    });
  }

}
