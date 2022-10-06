import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseurl:string="http://localhost:9091"
  constructor(private http:HttpClient) { }

  sendEmail(data:any){
return this.http.post(`${this.baseurl}/sendemail`,data)
  }
}
