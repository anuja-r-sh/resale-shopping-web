import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Car } from '../model/car';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {

  private _addedCartItem = new Subject<Car>();
  private _removedCartItem = new Subject<Car>();
  

  addedCartItem$ = this._addedCartItem.asObservable();
  removedCartItem$ = this._removedCartItem.asObservable();

  constructor() { }

  addToCart(car){
    this._addedCartItem.next(car);
  }

  removeFromCart(car){
    this._removedCartItem.next(car);
  }

}
