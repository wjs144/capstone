import { TestBed } from '@angular/core/testing';

import { CreateAccountService } from './create-account.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
//import {HttpClientModule} from '@angular/common/http';

describe('CreateAccountService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
  }));

  it('should be created', () => {
    const service: CreateAccountService = TestBed.get(CreateAccountService);
    expect(service).toBeTruthy();
  });
});
