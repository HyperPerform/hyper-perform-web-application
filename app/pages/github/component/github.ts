/**
 * Created by avinash on 2016/08/12.
 */

import {Component, Injectable} from '@angular/core';
import {Http, Response, HTTP_PROVIDERS} from '@angular/http';
import { ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector : 'github-cmp',
  templateUrl : './pages/github/component/github.html',
  providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS],
  directives: [ROUTER_DIRECTIVES],

})
// @Injectable()
export class GithubComponent {

   title : Array;

  constructor( private http: Http)  {


    this.http.get('http://api.fixer.io/latest?base=USD').map(res => res.json()).subscribe(
      data => {this.title = data});

    // let jason = JSON.parse(this.title);
    // this.title = this.title.ZAR;

  }


  private handleError (error: any)  {
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }

  private extractData(res: Response)  {
    let body = res.json();
    return body.data;
  }

}

