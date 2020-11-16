import { TestBed } from '@angular/core/testing';

import { AnnualPaymentService } from './annual-payment.service';

describe('AnnualPaymentService', () => {
  let service: AnnualPaymentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnnualPaymentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
