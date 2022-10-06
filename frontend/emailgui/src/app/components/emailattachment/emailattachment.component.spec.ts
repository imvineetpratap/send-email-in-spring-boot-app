import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailattachmentComponent } from './emailattachment.component';

describe('EmailattachmentComponent', () => {
  let component: EmailattachmentComponent;
  let fixture: ComponentFixture<EmailattachmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmailattachmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmailattachmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
