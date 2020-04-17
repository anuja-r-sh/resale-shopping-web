import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  
  copyrightTemplate = "2020 Frank's Resale Car Shop"

  constructor() { }

  ngOnInit(): void {
  }

}
