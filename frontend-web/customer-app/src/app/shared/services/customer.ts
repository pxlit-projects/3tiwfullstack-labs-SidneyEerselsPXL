import { Injectable } from '@angular/core';
import {Customer} from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [
    new Customer('Dries Swinnen', 'dries@pxl.be', 'Pelt', 'mystreet', 'Belgium', 21),
    new Customer('John Doe', 'john@doe.be', 'New York', '5th Avenue', 'USA', 6),
    new Customer('Jane Doe', 'jane@doe.be', 'Los Angeles', 'Sunset Boulevard', 'USA', 6)
  ];
}

