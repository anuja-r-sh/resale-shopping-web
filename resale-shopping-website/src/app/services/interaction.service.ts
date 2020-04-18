import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Car } from '../model/car';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {

  private _cartItemsSource = new Subject<Car>();

  cartItems$ = this._cartItemsSource.asObservable();

  constructor() { }

  addToCart(car){
    this._cartItemsSource.next(car);
  }

  removeFromCart(car){
    this._cartItemsSource.next(car);
  }

}
