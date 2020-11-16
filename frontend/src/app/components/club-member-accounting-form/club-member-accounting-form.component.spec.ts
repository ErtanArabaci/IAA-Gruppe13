import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubMemberAccountingFormComponent } from './club-member-accounting-form.component';

describe('ClubMemberAccountingFormComponent', () => {
  let component: ClubMemberAccountingFormComponent;
  let fixture: ComponentFixture<ClubMemberAccountingFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubMemberAccountingFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubMemberAccountingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
