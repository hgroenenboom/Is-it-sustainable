import { Component, OnInit } from '@angular/core';
import {MatSlideToggleChange} from '@angular/material/slide-toggle';
import {Globals} from '../../globals';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private globals: Globals) { }

  ngOnInit(): void {
  }

  changeEdit(mattoggle: MatSlideToggleChange) {
    this.globals.checked.next(mattoggle.checked);
  }
}
