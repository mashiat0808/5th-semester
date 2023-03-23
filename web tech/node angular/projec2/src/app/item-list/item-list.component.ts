import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from '../item';
import { ItemService } from '../item.service';
@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit{
  constructor (private itemService:ItemService, private router:Router) {}
  myItems: Item[]=[];
  ngOnInit(): void {

    console.log(this.itemService.getItems());
    this.myItems=this.itemService.getItems();

  }

  requestItem(index: number): void
{
  alert("item"+ this.myItems.at(index)?.name+"requested");
}

decrementCount(index:number){
  this.myItems[index].quantity--;
  this.itemService.setItems(this.myItems);
}

incrementCount(index: number){
  this.myItems[index].quantity++;
  this.itemService.setItems(this.myItems);
}


updateItem(index:number): void{
  this.itemService.setItemToBeUpdated(index);
  this.router.navigate(["update"]);

}

}
