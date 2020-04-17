export interface Car {
  id:Number,
  make: string;
  model: string;
  price: string;
  licensed:boolean;
  yearModel:string;
  dateAdded:Date;
  location: string;
}

export interface CarList{
  carDetailsList: Car[];

}

