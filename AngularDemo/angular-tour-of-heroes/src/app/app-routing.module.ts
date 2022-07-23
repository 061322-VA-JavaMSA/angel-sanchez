import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent },
  { path: 'heroes', component: HeroesComponent } // tells the router to match the url path and display the HeroesComponent
  // Angular route properties: Path -A string that matches the url in the browser address bar
  // Component- the component that the router should create when navigating to this route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forRoot() configures the router at the app's root level, supplies the service providers and directives needed for routing and performs the initial navigation based on the current browser url
  // imports: [CommonModule],
  exports: [RouterModule] // Available throughout the app
})
export class AppRoutingModule { }
