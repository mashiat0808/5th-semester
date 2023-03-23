import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit{
  constructor(private itemService:ItemService, private router:Router){}
  myitem: Item= new Item;
  ngOnInit(): void {
    this.myitem=this.itemService.itemToBeUpdated;
      
  }
  update(): void
  {
    this.router.navigate(["items"]);
  }


}
