import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
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
   
  save(formData: FormData): Observable<Installment> {
    // console.log('- ' + installment.file);
    return this.http.post<Installment>(this.installmentUrl, formData);
  }
 

  delete(id?: string): Observable<void> {
    const url = `${this.installmentUrl}/${id}`;

    return this.http.delete<void>(url)
      .pipe(
        catchError(error => {
          console.error('Error deleting installment:', error);
          return throwError(error);
        })
      );
  }

  uploadImage(formData: FormData): Observable<any> {
    const headers = new HttpHeaders(); 
    return this.http.post(`${this.installmentUrl}/upload`, formData, { headers });
  }

}
