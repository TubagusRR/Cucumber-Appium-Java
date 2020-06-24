$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("scenario.feature");
formatter.feature({
  "line": 2,
  "name": "Playstore",
  "description": "",
  "id": "playstore",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Playstore"
    }
  ]
});
formatter.before({
  "duration": 10228734300,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Search Ezeelink App",
  "description": "",
  "id": "playstore;search-ezeelink-app",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@LaunchingPlaystore"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User Navigate to Ezeelink App",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.userNavigateToEzeelinkApp()"
});
formatter.result({
  "duration": 6741001900,
  "status": "passed"
});
formatter.after({
  "duration": 21100,
  "status": "passed"
});
});