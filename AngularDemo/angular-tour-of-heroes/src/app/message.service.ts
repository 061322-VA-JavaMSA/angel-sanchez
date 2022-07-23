import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  messages: string[] = [];

  add(message: string){ //add() method to add a message
    this.messages.push(message);
  }

  clear(){ //clear() method to clear the cache
    this.messages = [];
  }

  // constructor() { }
}
