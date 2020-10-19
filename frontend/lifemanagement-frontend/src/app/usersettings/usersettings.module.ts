import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TranslateModule} from '@ngx-translate/core';
import {
  ButtonModule,
  DialogModule,
  DropdownModule,
  FieldsetModule,
  InputTextModule,
  PasswordModule,
  PickListModule,
  ToggleButtonModule
} from 'primeng';
import {PipeModule} from '../core/pipes/pipe.module';
import {LoginModule} from '../login/login.module';
import {UserDateFormatComponent} from './userDateFormat/userDateFormat.component';
import {UserdetailsComponent} from './userdetails/userdetails.component';
import { UsersettingsComponent } from './usersettings.component';

@NgModule({
  declarations: [
    UsersettingsComponent,
    UserdetailsComponent,
    UserDateFormatComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    FieldsetModule,
    TranslateModule,
    DropdownModule,
    FormsModule,
    ToggleButtonModule,
    PasswordModule,
    DialogModule,
    LoginModule,
    PipeModule,
    ButtonModule,
    PickListModule,
  ],
  exports: [
    UsersettingsComponent,
  ]
})
export class UsersettingsModule { }