import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InstallmentsComponent } from './components/component-installments/list/installments-list.component';
// import { FinancingComponent } from './financing/financing.component';

const routes: Routes = [
  { path: 'installments', component: InstallmentsComponent },
  // { path: 'financing', component: FinancingComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
