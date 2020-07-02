$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("scroll.feature");
formatter.feature({
  "line": 2,
  "name": "Scroll Down",
  "description": "",
  "id": "scroll-down",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Playstore"
    }
  ]
});
formatter.before({
  "duration": 16326210200,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Scrolling Down Until Element Found",
  "description": "",
  "id": "scroll-down;scrolling-down-until-element-found",
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
  "name": "Playstore Opened",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Scrolling Down Until Element Found",
  "keyword": "Then "
});
formatter.match({
  "location": "ScrollStep.playstoreOpened()"
});
formatter.result({
  "duration": 21972312000,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.fail(Assert.java:95)\r\n\tat steps.ScrollStep.playstoreOpened(ScrollStep.java:33)\r\n\tat ✽.Given Playstore Opened(scroll.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ScrollStep.userScrollingDown()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1645789200,
  "status": "passed"
});
formatter.after({
  "duration": 12800,
  "status": "passed"
});
formatter.uri("search.feature");
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
  "duration": 10799765700,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Search Ezeelink App on Playstore",
  "description": "",
  "id": "playstore;search-ezeelink-app-on-playstore",
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
  "name": "Playstore Opened User Click Search Bar",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Fill the Search Bar with Ezeelink",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User Navigate to Ezeelink App",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.playstoreOpenedUserClickSearchBar()"
});
formatter.result({
  "duration": 5000459900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.userFillTheSearchBarWithEzeelink()"
});
formatter.result({
  "duration": 3352919500,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.userNavigateToEzeelinkApp()"
});
formatter.result({
  "duration": 3320943200,
  "status": "passed"
});
formatter.after({
  "duration": 27100,
  "status": "passed"
});
formatter.after({
  "duration": 8300,
  "status": "passed"
});
});