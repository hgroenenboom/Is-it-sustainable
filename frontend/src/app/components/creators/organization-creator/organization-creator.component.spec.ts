import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizationCreatorComponent } from './organization-creator.component';

describe('OrganizationCreatorComponent', () => {
  let component: OrganizationCreatorComponent;
  let fixture: ComponentFixture<OrganizationCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrganizationCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganizationCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
