import {Component} from '@angular/core';
import {CORE_DIRECTIVES, FORM_DIRECTIVES} from '@angular/common';
import {CAROUSEL_DIRECTIVES, AlertComponent} from 'ng2-bootstrap/ng2-bootstrap';
import {ROUTER_PROVIDERS} from '@angular/router';
import {Http, HTTP_PROVIDERS} from '@angular/http';




@Component({
  moduleId: module.id,
  selector: 'github-cmp',
  templateUrl: 'github.html',
  // styleUrls: ['home.css'],
})


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

	public summary : string;

	constructor( private http: Http)
	{
		this.http.get('http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/getSummary').map(res => res.json()).subscribe(
			data => this.summary = data);
	}

    // private handleError (error: any)  {
    //     let errMsg = (error.message) ? error.message :
    //         error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    //     console.error(errMsg); // log to console instead
    //     return Observable.throw(errMsg);
    // }
    //
    // private extractData(res: Response)  {
    //     let body = res.json();
    //     return body.data;
    // }

	// private buildStatus(travis: any)   {
    //
	// 		return "<div class='card card-success card-inverse'>"+
	// 			"<div class='card-header card-success'>" +
	// 				"<div class='row'>" +
	// 		  			"<div class='col-xs-3'>" +
	// 						"<i class='fa fa-gears fa-5x'></i>" +
	// 						"</div>" +
	// 							"<div class='col-xs-9 text-xs-right'>" +
	// 							"<div class='huge' *ngIf='summary'>{{ summary.travis }}%</div>" +
	// 							"<div>Build Ratio</div>" +
	// 						"</div>" +
	// 					"</div>" +
	// 				"</div>" +
	// 			"<div class='card-footer card-green'>" +
	// 				"<a class='text-success' href='javascript:void(0);'>" +
	// 				"<span class='pull-xs-left'>View Details</span>" +
	// 				"<span class='pull-xs-right'><i class='fa fa-arrow-circle-right'></i></span>" +
	// 				"<div class='clearfix'></div>" +
	// 				"</a>" +
	// 			"</div>" +
	// 	"</div>";
    //
    //
	// }


}
