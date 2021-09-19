import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  todo: Todo ={
    title: '',
    description: '',
    finishDate: new Date(),
    finished: false
  }
  constructor(private router: Router, private service: TodoService) { }

  ngOnInit(): void {
  }

  createTodo(): void {
    this.formatDate();
    this.service.create(this.todo).subscribe((response)=> {
      this.service.sendMessage('To-do criado com sucesso!');
      this.goHome();
    }, err => {
      this.service.sendMessage('Falha ao criar to-do');
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
