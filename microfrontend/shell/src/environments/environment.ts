// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  /**
   * Sets production true
   */
  production: false,
  /**
   * The Backend api URL
   */
  api_url: 'http://localhost:8181/lifemanagement/api',
  /**
   * The base href of the frontend application
   */
  base_href: '/',
  /**
   * Flag if errors are shown
   */
  show_errors: false,
  /**
   * Flag if url routes are shown
   */
  hide_url_routes: false,
  /**
   * Url to backend swagger
   */
  swagger_url: 'http://localhost:8181/lifemanagement/api/swagger-ui/index.html?configUrl=/lifemanagement/api/api-docs/swagger-config&filter=Endpoints'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
import 'zone.js/dist/zone-error';  // Included with Angular CLI.
