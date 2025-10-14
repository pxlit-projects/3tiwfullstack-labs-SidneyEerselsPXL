import {Component, Input} from '@angular/core';
import {Customer} from '../../../shared/models/customer.model';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-customer-item',
  imports: [
    NgClass
  ],
  templateUrl: './customer-item.html',
  styleUrl: './customer-item.css'
})
export class CustomerItem {
  @Input() customer!: Customer;
  Customer = new Customer('John Doe', 'john@doe.com', 'Hasselt', 'elfdelinie 123', 'Belgium', 6);

  getDetails(): void{
    console.log(this.customer);
  }
}


