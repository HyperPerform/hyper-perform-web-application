/**
 * Created by avinash on 2016/08/12.
 */

import {Component, OnInit} from '@angular/core';
import {Http, HTTP_PROVIDERS} from '@angular/http';
import { ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router';

@Component({
  selector : 'travis-cmp',
  templateUrl : './pages/travis/component/travis.html',
  providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS],
  directives: [ROUTER_DIRECTIVES],

})

export class TravisComponent implements OnInit {
  ngOnInit() {
    var travisGraph: any = $('#travis-graph');
    travisGraph.highcharts({
      chart: {
        type: 'spline'
      },
      title: {
        text: 'Travis Graph Summary'
      },
      subtitle: {
        text: 'Data Comprises from x to y'
      },
      xAxis: {
        type: 'datetime',
        dateTimeLabelFormats: { // don't display the dummy year
          month: '%e. %b',
          year: '%b'
        },
        title: {
          text: 'Date'
        }
      },
      yAxis: {
        title: {
          text: 'Rate'
        },
        min: 0
      },
      tooltip: {
        headerFormat: '<b>{series.name}</b><br>',
        pointFormat: '{point.x:%e. %b}: {point.y:.2f} %'
      },

      plotOptions: {
        spline: {
          marker: {
            enabled: true
          }
        }
      },

      series: [{
        name: 'Passed',
        data: [
          [Date.UTC(1970, 9, 21), 1],
          [Date.UTC(1970, 10, 4), 0],
          [Date.UTC(1970, 10, 9), 0],
          [Date.UTC(1970, 10, 27), 1],

        ]
      }, {
        name: 'Failed',
        data: [
          [Date.UTC(1970, 9, 29), 0],
          [Date.UTC(1970, 10, 9), 1],
          [Date.UTC(1970, 11, 1), 0],
          [Date.UTC(1971, 0, 1), 1],
          [Date.UTC(1971, 0, 10), 0],
        ]
      }]
    });

  }

   public summary : any;

  constructor( private http: Http)  {

    this.http.get('http://localhost:8080/hyperperform-system-1.0-SNAPSHOT/rs/report/geTravisDetails').map(res => res.json()).subscribe(
      data => {this.summary = data; });

  }


}

