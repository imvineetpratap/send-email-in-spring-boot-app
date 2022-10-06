import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  data={
    recipient:"",
    subject:"",
    msgBody:""
  }

  flag=false;
  constructor(private email:EmailService,private snak:MatSnackBar) { }

  ngOnInit(): void {
  }
//submit form
  doSubmitForm(){
    console.log("try to submit form");
    console.log("data",this.data);
    if(this.data.recipient==''||this.data.subject==''||this.data.msgBody=='')
    {
this.snak.open("fields can not be empty","ok");
return;
    }
    


this.flag=true;



//sending data to baceknd    
    this.email.sendEmail(this.data).subscribe(

response=>{
  console.log(response);
  this.flag=false;
  this.snak.open("Send Success ","OK")  
},
error=>{
  console.log(error);
  this.flag=false;
  this.snak.open("Send Success ","OK")   
}


    )
  }

}
