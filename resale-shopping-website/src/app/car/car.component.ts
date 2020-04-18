import { Component, OnInit, Input } from '@angular/core';
import { Car } from '../model/car'
import { WareHouse } from '../model/wareHouse';
import { ResaleService } from '../services/resale.service';
import { InteractionService } from '../services/interaction.service';


@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  @Input() car: Car;
  wareHouse: WareHouse;
  isCollapsed: boolean = true;
  isAddedToCart: boolean = false;

  constructor(private resaleService: ResaleService, private interactionService: InteractionService) { }

  ngOnInit(): void {
    this.interactionService.cartItems$.subscribe(car =>{

    });
  }

  getDateAdded(dateAdded) {
    console.log(dateAdded)
    const date = new Date(dateAdded);
    return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
  }
  getWareHouseDetails(carId) {
    this.resaleService.getWareHouseDetails(carId).subscribe(data => {
      this.isCollapsed = !this.isCollapsed;
      this.wareHouse = data;
    });

  }
  getLicenseStatus(flag) {
    return (flag) ? "Available" : "Not Available";

  }
  getMapLocation(lat, long) {
    return `http://www.google.com/maps/place/${lat},${long}`;
  }

  addToCart(car) {
    this.isAddedToCart = true;
    this.interactionService.addToCart(car);
  }

  removeFromCart(car) {
    this.interactionService.removeFromCart(car);
  }
}
