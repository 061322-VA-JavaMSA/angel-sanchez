import { Component, OnInit } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from '../mock-heroes';

@Component({ //new component for heroes
  selector: 'app-heroes', //CSS element selector belonging to the component
  templateUrl: './heroes.component.html', //location
  styleUrls: ['./heroes.component.css'] //style location
})
export class HeroesComponent implements OnInit { //always export so you can import somewhere else
  // hero = 'Superman';
  // hero: Hero = {
  //   id: 1,
  //   name: 'Superman'
  // }
  heroes = HEROES;
  selectedHero?: Hero; 

  constructor() { }

  ngOnInit(): void { //lifestyle hook, put initialization logic
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero; //assigns the clicker hero from template to component's selectedHero
  }

}
