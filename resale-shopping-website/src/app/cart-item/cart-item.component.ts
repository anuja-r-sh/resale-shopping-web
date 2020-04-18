import { Component, OnInit, Input } from '@angular/core';
import { Car } from '../model/car';
import { InteractionService } from '../services/interaction.service';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {

  @Input() car: Car;
  constructor(private interactionService : InteractionService) { }

  ngOnInit(): void {
  }

  removeFromCart(car) {
    this.interactionService.removeFromCart(car);
  }

}
