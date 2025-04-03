import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component } from '@angular/core';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-statistics',
  imports: [],
  templateUrl: './statistics.component.html',
  styleUrl: './statistics.component.css'
})
export class StatisticsComponent {
  ticketPoolSize: number = 0;
  activeCustomers: number = 0;
  activeVendors: number = 0;
  totalSales: number = 0;

  private SubscriptionStatus: Subscription | undefined;

  constructor(private http: HttpClient, private cdRef: ChangeDetectorRef){}

  ngOnInit() {
    this.SubscriptionStatus = interval(500).subscribe(() => {
      this.getStats();
    });

    this.getStats();
  }

  getStats(){
    this.http.get<any>('http://localhost:8080/api/tickets/statistics').subscribe(
      (status) => {
        this.ticketPoolSize = status.ticketPoolSize;
        this.activeCustomers =status.activeCustomers;
        this.activeVendors = status.activeVendors;
        this.totalSales = status.totalSales;
      }
    );
  }

  ngOnDestroy(){
    if(this.SubscriptionStatus){
      this.SubscriptionStatus.unsubscribe();
    }
  }
}
