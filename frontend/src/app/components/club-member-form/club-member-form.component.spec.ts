import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ClubMemberFormComponent} from './club-member-form.component';

describe('ClubMemberFormComponent', () => {
  let component: ClubMemberFormComponent;
  let fixture: ComponentFixture<ClubMemberFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClubMemberFormComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubMemberFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
