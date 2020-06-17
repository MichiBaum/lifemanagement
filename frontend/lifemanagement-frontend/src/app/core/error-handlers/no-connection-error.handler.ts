import {HttpErrorResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {ToastMessageService} from '../../toast-message/toast-message.service';
import {IHttpErrorResponseHandler} from './i-http-error-response.handler';
import {LogGenerator} from './log-generator.namespace';

@Injectable()
export class NoConnectionErrorHandler implements IHttpErrorResponseHandler {

  constructor(
    private toastMessageService: ToastMessageService
  ) { }

  matches(error: HttpErrorResponse): boolean {
    return true;
  }

  handle(error: HttpErrorResponse): Observable<any> {
    const message = LogGenerator.createToastError(error);
    this.toastMessageService.emit([
      message
    ]);
    return of([]);
  }

}
