import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ClubMemberAppComponent} from './club-member-app.component';

describe('ClubMemberAppComponent', () => {
  let component: ClubMemberAppComponent;
  let fixture: ComponentFixture<ClubMemberAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubMemberAppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubMemberAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
