import {Component, EventEmitter, inject, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Customer} from '../../../shared/models/customer.model';

@Component({
  selector: 'app-add-customer',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-customer.html',
  styleUrl: './add-customer.css'
})

export class AddCustomer {
  fb: FormBuilder = inject(FormBuilder);
  customerForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    avatar: ['default.png',[Validators.required]],
    city: ['', Validators.required],
    address: ['', Validators.required],
    country: ['', Validators.required],
    vat: ['', [Validators.required, Validators.min(0)]]
  });
  @Output() addCustomer = new EventEmitter<Customer>();

  onSubmit() {
    const newCustomer: Customer = {
      ...this.customerForm.value
    };
    this.addCustomer.emit(newCustomer);
  }
}


