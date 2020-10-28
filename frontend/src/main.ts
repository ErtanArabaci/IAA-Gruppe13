import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {environment} from './environments/environment';
import {ClubMemberAppModule} from "./app/club-member-app.module";

if (environment.production) {
  enableProdMode();
}



platformBrowserDynamic().bootstrapModule(ClubMemberAppModule)
  .catch(err => console.error(err));
