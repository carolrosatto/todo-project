import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './components/create/create.component';
import { EditComponent } from './components/edit/edit.component';
import { FinishedTodosComponent } from './components/finished-todos/finished-todos.component';
import { ReadAllComponent } from './components/read-all/read-all.component';

const routes: Routes = [
  {path: '', component: ReadAllComponent},
  {path: 'finished', component: FinishedTodosComponent},
  {path: 'create', component: CreateComponent},
  {path: 'edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
