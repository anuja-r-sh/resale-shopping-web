import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import {HttpClient} from '@angular/common/http';
import { CarList } from '../model/car';
import { __classPrivateFieldSet } from 'tslib';

@Injectable({
  providedIn: 'root'
})
export class ResaleService {

  constructor(private http: HttpClient) { }

  getAllCarsOfWareHouse(): Observable<CarList> {

  return this.http.get<CarList>(environment.urls.getAllCars);

   
  }
}
