import { Injectable } from '@angular/core';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }
  itemToBeUpdated: Item=new Item();
  items: Item[]=[
    {id:1, name:"iphone", price:2000, quantity:0},
   { id:2, name:"iphone2", price:23000, quantity:0},
    {id:3, name:"iphone3", price:24000, quantity:0}
  ];

  getItems(): Item[]{
    return this.items;
  }
  setItems(item: Item[]){
    this.items=item;
  }

  setItemToBeUpdated(index:number): void {
    let item=this.items.at(index);
    if(item!=null){
      this.itemToBeUpdated=item;
    }
  }
  getItemToBeUpdated():Item{
    return this.itemToBeUpdated;
  }


}
