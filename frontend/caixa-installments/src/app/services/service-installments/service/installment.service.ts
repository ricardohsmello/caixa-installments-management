import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Installment } from '../../../models/installments';
  

@Injectable({
  providedIn: 'root'
})
export class InstallmentService {

  private installmentUrl: string;
  status: string | undefined;


  constructor(private http: HttpClient) {
    this.installmentUrl = 'http://localhost:8080/api/installments';
  }

  findAll(): Observable<Installment[]> {
    return this.http.get<Installment[]>(this.installmentUrl);
  }
   
  save(installment: Installment): Observable<Installment> {
    console.log('- ' + installment.paid);
    return this.http.post<Installment>(this.installmentUrl, installment);
  }

  delete(id?: string) {
    const url = `${this.installmentUrl}/${id}`;

    this.http.delete(url)
    .subscribe(() => this.status = 'Delete successful');
    
  }


}
