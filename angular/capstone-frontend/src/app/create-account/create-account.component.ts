import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CreateAccountService } from './create-account.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  formGroup: FormGroup;

  /**
   * we can add objs to the constructor that will automatically get injected 
   * (but only appropriate ones like @Injectable objs)
   * @param fb - formbuilder to create our form
   * @param createAccount - service to call the create account on the back end
   */
  constructor(private fb: FormBuilder,
              private createAccount: CreateAccountService,
              private router: Router) {
    //create the form that will be attacked to our inputs
    this.formGroup = fb.group({
      accountType: ['fan', [Validators.required]] ,
      firstName: [''],
      lastName: [''],
      bandName: [''],
      phone: [''],
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      recoveryQuestion: ['', [Validators.required]],
      recoveryAnswer: ['', [Validators.required]]
    })
   }


  ngOnInit() {
  }

  onCreateAccount() {
    if(!this.formGroup.valid) {
      this.formGroup.markAllAsTouched();
      this.formGroup.updateValueAndValidity();
      return;
    }
    //structure the data to what the back end is expecting
    let createData = {
      accountType: this.formGroup.get('accountType').value,
      firstName: this.formGroup.get('firstName').value,
      lastName: this.formGroup.get('lastName').value,
      bandName: this.formGroup.get('bandName').value,
      phone: this.formGroup.get('phone').value,
      userName: this.formGroup.get('userName').value,
      password: this.formGroup.get('password').value,
      recoveryQuestion: this.formGroup.get('recoveryQuestion').value,
      recoveryAnswer: this.formGroup.get('recoveryAnswer').value,
    }
    /* need to stand up the backend on the VM before I enable this
    
    //make the call to the backend
    this.createAccount.createAccount(createData).subscribe(response => {
      //success, we should route to the dashboard
      this.router.navigate(['/dashboard']);
    }, (error: HttpErrorResponse) => {
      //we got an error from the backend when trying to create the account
    });

*/
  }
}
