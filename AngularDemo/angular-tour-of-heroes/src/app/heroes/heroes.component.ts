import { Component, OnInit } from '@angular/core';
import { Hero } from './hero';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';
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
  // selectedHero?: Hero; 
  heroes: Hero[] = [];

  // constructor(private heroService: HeroService, private messageService: MessageService) { }
  constructor(private heroService: HeroService) { }


  ngOnInit(): void { //lifestyle hook, put initialization logic
    this.getHeroes();
  }

  // onSelect(hero: Hero): void {
  //   this.selectedHero = hero; //assigns the clicker hero from template to component's selectedHero
  //   this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
  // }

  getHeroes(): void{
    this.heroService.getHeroes()
    .subscribe(heroes => this.heroes = heroes); //.subscribe() method passes the emitted array to the callback, which sets the component's heroes property
  }

}
