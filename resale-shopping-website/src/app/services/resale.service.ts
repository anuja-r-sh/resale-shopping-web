import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { HttpClient } from '@angular/common/http';
import { Car } from '../model/car';
import { __classPrivateFieldSet } from 'tslib';
import { WareHouse } from '../model/wareHouse';

@Injectable({
  providedIn: 'root'
})
export class ResaleService {

  constructor(private http: HttpClient) { }

  getAllCarsOfWareHouse(): Observable<Car[]> {

    return this.http.get<Car[]>(environment.urls.getAllCars);

  }

  getWareHouseDetails(carId): Observable<WareHouse> {
    return this.http.get<WareHouse>(`${environment.urls.getWareHouseDetails}/${carId}`);
  }

}
