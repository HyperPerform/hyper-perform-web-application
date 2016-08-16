import {Component} from '@angular/core';
import {CORE_DIRECTIVES, FORM_DIRECTIVES} from '@angular/common';
import {CAROUSEL_DIRECTIVES, DROPDOWN_DIRECTIVES, AlertComponent} from 'ng2-bootstrap/ng2-bootstrap';
import {Routes, ROUTER_PROVIDERS} from '@angular/router';
import { ROUTER_DIRECTIVES } from '@angular/router';
import {Http, HTTP_PROVIDERS, Response} from '@angular/http';
import {build$} from "protractor/built/element";
import {Observable} from "rxjs";



@Component({
  moduleId: module.id,
  selector: 'github-cmp',
  templateUrl: 'github.html',
  // styleUrls: ['home.css'],
})
class GithubComponent { }

@Routes([
  { path: '/github', component: GithubComponent }
])


@Component({
	moduleId: module.id,
	selector: 'notifications-cmp',
	templateUrl: 'notifications.html',
	styleUrls: ['home.css'],
})
class NotificationComponent { }


@Component({
	moduleId: module.id,
	selector: 'home-cmp',
	templateUrl: 'home.html',
	styleUrls: ['home.css'],
	providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS],
	directives: [
		AlertComponent,
		NotificationComponent,
		CAROUSEL_DIRECTIVES,
		CORE_DIRECTIVES,
		FORM_DIRECTIVES ]
})

export class HomeComponent {
	public commit : any;
	public buildStatus : any;
	public issuesO : any;
	public issuesC : any;
	public summary : string;

	constructor( private http: Http)
	{
		this.http.get('http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary').map(res => res.json()).subscribe(
			data => this.summary = data);
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
