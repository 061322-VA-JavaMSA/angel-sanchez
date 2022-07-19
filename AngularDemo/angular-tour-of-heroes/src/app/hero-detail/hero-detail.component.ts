import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../heroes/hero';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  @Input() hero?: Hero; //added hero property so it must be an Input() property because the external HeroesComponent binds to it like this
  // this componenet only received a hero object through the hero property and displays it

  constructor() { }

  ngOnInit(): void {
  }

}
