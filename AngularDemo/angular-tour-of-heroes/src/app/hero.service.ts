import { Injectable } from '@angular/core';
import { HEROES } from './mock-heroes';
import { Hero } from './heroes/hero';
import { Observable, of } from 'rxjs'; //Oberservable is one of the key classes in the RxJS library
import { MessageService } from './message.service';

// accepts metadata object for the service, same way as @Componenet() decorator did with component classes
@Injectable({providedIn: 'root'})
export class HeroService {
  constructor(private messageService: MessageService) { } 
  //service in service scenario, injected MessageService into the HeroService which is injected into the HeroesComponent

  getHeroes(): Observable<Hero[]> {
    const heroes = of(HEROES); //single value is the array of mock heroes list
    this.messageService.add('HeroService: fetched heroes');
    return heroes;
  }

  getHero(id: number): Observable<Hero> {
    // For now, assume that a hero with the specified `id` always exists.
  // Error handling will be added in the next step of the tutorial.
  const hero = HEROES.find(h => h.id === id)!;
  this.messageService.add(`HeroService: fetched hero id=${id}`);
  return of(hero);
  }
}
