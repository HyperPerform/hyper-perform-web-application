import {Component, ViewEncapsulation} from '@angular/core';
import { ROUTER_DIRECTIVES, Routes } from '@angular/router';

import {HomeComponent} from '../../../pages/home/components/home';
import {ChartComponent} from '../../../pages/charts/components/charts';
import {SidebarComponent} from '../../../shared/sidebar/sidebar';
import {GithubComponent} from "../../../pages/github/component/github";
import {TopNavComponent} from "../../../shared/topnav/topnav";


@Component({
  moduleId: module.id,
  selector: 'dashboard-cmp',
  templateUrl: 'dashboard.html',
  encapsulation: ViewEncapsulation.None,
  directives: [ROUTER_DIRECTIVES, TopNavComponent, SidebarComponent]
})

@Routes([
    { path: '/home', component: HomeComponent },
    { path: '/chart', component: ChartComponent },
    { path: '/github', component: GithubComponent}
])

export class DashboardComponent { }
