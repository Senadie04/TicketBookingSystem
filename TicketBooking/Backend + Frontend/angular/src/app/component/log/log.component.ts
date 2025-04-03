import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component } from '@angular/core';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-log',
  imports: [],
  templateUrl: './log.component.html',
  styleUrl: './log.component.css'
})
export class LogComponent {
  logs: string = '';
  private logSubscription: Subscription | undefined;

  constructor(private http: HttpClient, private cdRef: ChangeDetectorRef){}

  ngOnInit(){
    this.logSubscription = interval(500).subscribe(() => {
      this.getLogs();
    })

    this.getLogs();
  }

  getLogs(){
    this.http.get('http://localhost:8080/api/tickets/logs', {responseType: 'text'}).subscribe(
      (data) => {
        this.logs = data;
        this.cdRef.detectChanges;
      },
      (error) => {
        console.error('Error fetching logs', error);
      }
    );
  }

  ngOnDestroy(){
    if(this.logSubscription){
      this.logSubscription.unsubscribe();
    }
  }
}
