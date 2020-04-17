export interface Car {
  id:Number,
  make: string;
  model: string;
  price: string;
  licensed:boolean;
  yearModel:string;
  dateAdded:Date
}

export interface CarList{
  carDetailsList: Car[];

}

