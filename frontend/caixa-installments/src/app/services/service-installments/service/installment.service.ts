import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Installment } from '../../../models/installments';
  

@Injectable({
  providedIn: 'root'
})
export class InstallmentService {

  private installmentUrl: string;


  constructor(private http: HttpClient) {
    this.installmentUrl = 'http://localhost:8080/api/installments';
  }

  public findAll(): Observable<Installment[]> {
    return this.http.get<Installment[]>(this.installmentUrl);
  }
   
  save(installment: Installment): Observable<Installment> {
    console.log('- ' + installment.paid);
    return this.http.post<Installment>(this.installmentUrl, installment);
  }

}
