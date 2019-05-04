import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {MainViewComponent} from "./main-view/main-view.component";
import {OrdersViewComponent} from "./orders-view/orders-view.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'main', component: MainViewComponent},
  {path: 'orders', component: OrdersViewComponent},
  {path: '', redirectTo: '/main', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
