import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-finished-todos',
  templateUrl: './finished-todos.component.html',
  styleUrls: ['./finished-todos.component.css']
})
export class FinishedTodosComponent implements OnInit {

  listFinished: Todo[] = [];

  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.forEach(todo => {
        if(todo.finished) {
          this.listFinished.push(todo);
        }
      })
    })
  }

  returnHome(): void {
    this.router.navigate(['']);
  }

}
