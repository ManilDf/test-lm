import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,ProductFormComponent,ProductListComponent,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
  
})

export class AppComponent {
  title = 'front';
}
