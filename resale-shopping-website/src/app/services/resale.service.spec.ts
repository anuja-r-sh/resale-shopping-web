import { TestBed } from '@angular/core/testing';

import { ResaleService } from './resale.service';

describe('CarService', () => {
  let service: ResaleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResaleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
