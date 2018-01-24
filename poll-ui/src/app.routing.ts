import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/index/index.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  // otherwise redirect to home
  { path: '**', redirectTo: '' }

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
