import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ClubMemberAccountingComponent} from './club-member-accounting.component';

describe('ClubMemberAccountingComponent', () => {
  let component: ClubMemberAccountingComponent;
  let fixture: ComponentFixture<ClubMemberAccountingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClubMemberAccountingComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubMemberAccountingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
