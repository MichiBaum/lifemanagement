import {Component, OnInit} from '@angular/core';
import {MessageService} from 'primeng';
import {ToastMessageService} from './toast-message.service';

@Component({
  selector: 'app-message-service',
  templateUrl: './toast-message.component.html',
  styleUrls: ['./toast-message.component.scss']
})
export class ToastMessageComponent implements OnInit {

  constructor(
    private toastMessageService: ToastMessageService,
    private messageService: MessageService
  ) {
    this.toastMessageService.toastMessageEmitter.subscribe((messages) => {
      this.messageService.addAll(messages);
    });
  }

  ngOnInit(): void { }

}