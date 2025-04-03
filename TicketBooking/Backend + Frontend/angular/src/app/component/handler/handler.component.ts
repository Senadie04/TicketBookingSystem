import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-handler',
  imports: [CommonModule, FormsModule,HttpClientModule],
  templateUrl: './handler.component.html',
  styleUrl: './handler.component.css'
})

export class HandlerComponent {
  showVendorForm: boolean = false;
  showCustomerForm: boolean = false;

  constructor(private http: HttpClient) {}

  toggleVendorForm(){
    this.resetVendorForm();
    this.showVendorForm = !this.showVendorForm;
    if(this.showVendorForm){
      this.showCustomerForm = false;
    }
  }

  toggleCustomerForm() {
    this.showCustomerForm = !this.showCustomerForm;
    this.resetCustomerForm();
    if (this.showCustomerForm) {
      this.showVendorForm = false;
    }
  }
  
  vendorName: string = '';
  totalTickets: number = 0;
  ticketReleaseRate: number = 0;
  eventName: string = '';
  ticketPrice: number = 0;
  
  addVendor(){
    const params = new HttpParams()
      .set('vendorName', this.vendorName)
      .set('totalTickets', this.totalTickets.toString())
      .set('ticketReleaseRate', this.ticketReleaseRate.toString())
      .set('eventName',this.eventName)
      .set('ticketPrice', this.ticketPrice.toString())

  
    this.http.post('http://localhost:8080/api/tickets/vendors', {}, {params})
      .subscribe({
        next: (response) => {
          console.log('Vendor added successfully', response);
          
          this.resetVendorForm();
          this.toggleVendorForm();
        },
        error: (error) => {
          console.error('Error adding vendor: ', error);
        }
      });
  }

  customerName: string = '';
  customerRetrievalRate: number = 0;
  purchaseQuantity: number = 0;

  addCustomer(){
    const params = new HttpParams()
      .set('customerName', this.customerName)
      .set('customerRetrievalRate', this.customerRetrievalRate)
      .set('purchaseQuantity', this.purchaseQuantity)

    this.http.post('http://localhost:8080/api/tickets/customers', {}, {params})
      .subscribe({
        next: (response) => {
          console.log('Vendor added successfully', response);

          this.resetCustomerForm();
          this.toggleCustomerForm();
        },
        error: (error) => {
          console.error('Error adding vendor: ', error);
        }
      });
  }

  startProgram(){
    const confirmStart = window.confirm('Are you sure you want to start the system.');
    if (confirmStart){
      this.http.post('http://localhost:8080/api/tickets/start', {}).subscribe({
        next: (response) => {
          console.log('System started', response); 
        },
        error: (error) => {
          console.error('Error occurred when starting the system',error);
        }
      })
    }
  }

  stopProgram(){
    const confirmStop = window.confirm('Are you sure you want to stop the system.');
    if (confirmStop){
      this.http.post('http://localhost:8080/api/tickets/stop',{}).subscribe({
        next: (response) => {
          console.log('System stopped', response);
        },
        error: (error) => {
          console.error("An error occurred when stopping the system", error);
        }
      })
    }
  }

  resetVendorForm(){
    this.vendorName = '';
    this.totalTickets = 0;
    this.ticketReleaseRate = 0;
    this.eventName = '';
    this.ticketPrice = 0;
  }

  resetCustomerForm(){
    this.customerName = '';
    this.customerRetrievalRate = 0;
    this.purchaseQuantity = 0;
  }
}
