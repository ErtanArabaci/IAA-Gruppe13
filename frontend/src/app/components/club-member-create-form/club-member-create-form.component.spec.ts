import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubMemberCreateFormComponent } from './club-member-create-form.component';

describe('ClubMemberCreateFormComponent', () => {
  let component: ClubMemberCreateFormComponent;
  let fixture: ComponentFixture<ClubMemberCreateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubMemberCreateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubMemberCreateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
