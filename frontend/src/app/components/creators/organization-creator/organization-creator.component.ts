import {AfterViewInit, Component, ElementRef, OnInit, QueryList, ViewChild, ViewChildren} from '@angular/core';
import {OrganizationDto} from '../../../dto/organizationDto';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {OrganizationApi} from '../../../api/organizationApi';
import {Globals} from '../../../globals';
import {MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {map, startWith} from 'rxjs/operators';
import {OrganizationTagDto} from '../../../dto/OrganizationTagDto';

export enum OrganizationCreatorComponentType {
  New,
  Update
}

@Component({
  selector: 'app-organization-creator',
  templateUrl: './organization-creator.component.html',
  styleUrls: ['./organization-creator.component.css']
})
export class OrganizationCreatorComponent implements OnInit, AfterViewInit  {
  panelOpenState: boolean;
  init = true;
  public type: OrganizationCreatorComponentType = OrganizationCreatorComponentType.New;

  org: OrganizationDto;
  orgForm: FormGroup;

  nameControl = new FormControl();
  nameOptions: string[] = [];

  visible = true;
  selectable = true;
  removable = true;
  tagOptionsObjects: OrganizationTagDto[] = [];
  tagOptions: string[] = [];
  separatorKeysCodes: number[] = [ENTER, COMMA];
  tagControl = new FormControl();
  selectedTags: string[] = [];

  public onSubmission: (caller: OrganizationCreatorComponent) => void = null;

  constructor(private organizationService: OrganizationApi, private globals: Globals) { }

  ngOnInit(): void {
    this.resetForm();
  }

  ngAfterViewInit(): void {
    this.organizationService.getTagNames().subscribe((names) => {
      this.tagOptionsObjects = names;
      names.forEach((tagObj) => {
        this.tagOptions.push(tagObj.tagName);
      });
    });
  }

  isChecked(): boolean { return this.globals.checked.getValue(); }

  resetForm(): void {
    this.org = new OrganizationDto(null, null, null, null, null);
    this.orgForm = new FormGroup({
      name: new FormControl(this.org.name, [
        Validators.required,
        Validators.minLength(1)
      ]),
      website: new FormControl(this.org.website, [
        Validators.required,
        Validators.minLength(1)
      ]),
      tags: new FormControl(this.org.organizationTags, [
        Validators.required,
        Validators.minLength(1)
      ])
    });

    this.init = true;
  }

  setFormElements(organization: OrganizationDto): void {
    organization.organizationTags = organization.organizationTags ? organization.organizationTags : null;
    this.selectedTags = [];
    organization.organizationTags.forEach((tag) => {
      this.selectedTags.push(tag.tagName);
    });

    this.orgForm.setValue({
      name: organization.name,
      website: organization.website,
      tags: ''
    });

    this.org.id = organization.id;
  }

  // tslint:disable-next-line:typedef
  get name() { return this.orgForm.get('name'); }
  // tslint:disable-next-line:typedef
  get website() { return this.orgForm.get('website'); }
  // tslint:disable-next-line:typedef
  get tags() { return this.orgForm.get('tags'); }

  submitForm(): void {
    this.init = false;
    this.org.name = this.name.value;
    this.org.website = this.website.value;

    this.org.organizationTags = [];
    for (const item of this.selectedTags) {
      let id = null;
      this.tagOptionsObjects.forEach((tag) => {
        if (tag.tagName === item) {
          id = tag.id;
        }
      });
      this.org.organizationTags.push(new OrganizationTagDto(id, item));
    }
    console.log(this.org);

    this.organizationService.addOrganization(this.org).subscribe(event => {
      if (this.onSubmission != null) {
        this.onSubmission(this);
      }
    });
  }

  findOrganizationsByName(): void {
    this.organizationService.getOrganizationsByName(this.name.value).subscribe(event => {
      const names = [];
      for (let i = 0; i < Math.min(20, event.length); i++) {
        names[i] = event[i].name;
      }
      this.nameOptions = names;
    });
  }

  findOrganizationTagsByName(caller): void {
    this.organizationService.getTagsByName( (caller.target as HTMLInputElement).value ).subscribe(event => {
      const names = [];
      for (let i = 0; i < Math.min(20, event.length); i++) {
        names[i] = event[i].tagName;
      }
      console.log(names);
      this.tagOptionsObjects = event;
      this.tagOptions = names != null ? names : [];
    });
  }

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    if (this.selectedTags.indexOf(value) < 0) {
      console.log(this.selectedTags);
      if ((value || '').trim()) {
        this.selectedTags.push(value.trim());
      }
      console.log(this.selectedTags);
    }

    if (input) {
      input.value = '';
    }

    this.tagControl.setValue(null);
  }

  remove(fruit: string): void {
    const index = this.selectedTags.indexOf(fruit);

    if (index >= 0) {
      this.selectedTags.splice(index, 1);
      this.tags.setValue(this.selectedTags);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    if(this.selectedTags.indexOf(event.option.viewValue) < 0) {
      this.selectedTags.push(event.option.viewValue);
    }
    (document.getElementById('tagInput') as HTMLInputElement).value = '';
    this.tagControl.setValue(null);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.tagOptions.filter(tag => tag.toLowerCase().indexOf(filterValue) === 0);
  }
}
