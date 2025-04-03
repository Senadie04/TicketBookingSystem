import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HandlerComponent } from './component/handler/handler.component';
import { LogComponent } from './component/log/log.component';
import { StatisticsComponent } from './component/statistics/statistics.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HomeComponent, HandlerComponent, LogComponent, StatisticsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'CW-angular-attempt1';
}
