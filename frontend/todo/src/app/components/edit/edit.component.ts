import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  todo: Todo ={
    title: '',
    description: '',
    finishDate: new Date(),
    finished: false
  }
  constructor(private router: Router, private service: TodoService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.todo.id).subscribe((response) => {
      this.todo = response;
    })
  }

  edit(): void {
    this.formatDate();
    this.service.update(this.todo).subscribe((response) => {
      this.service.sendMessage('To-do atualizado com sucesso!');
      this.goHome();
    }, err => {
      this.service.sendMessage('Falha ao atualizar to-do');
    })
  }

  formatDate(): void {
    let date = new Date(this.todo.finishDate)
    this.todo.finishDate = `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`
  }

  goHome(): void {
    this.router.navigate(['']);
  }

}
