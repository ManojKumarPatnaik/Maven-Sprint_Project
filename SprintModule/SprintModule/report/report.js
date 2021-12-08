$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyTest.feature");
formatter.feature({
  "line": 1,
  "name": "Validating Sprint module",
  "description": "",
  "id": "validating-sprint-module",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Creating a sprint with valid data",
  "description": "",
  "id": "validating-sprint-module;creating-a-sprint-with-valid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "Open the Browser and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "enter the homepage",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "click on Add Sprint",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "enter valid data",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "click on save",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "close the Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.open_the_Browser_and_launch_the_application()"
});
formatter.result({
  "duration": 3190289500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_the_homepage()"
});
formatter.result({
  "duration": 56604971000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_Sprint()"
});
formatter.result({
  "duration": 2317255300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_valid_data()"
});
formatter.result({
  "duration": 4387825100,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_save()"
});
formatter.result({
  "duration": 5819148500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.close_the_Browser()"
});
formatter.result({
  "duration": 847674400,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Creating a sprint with invalid data",
  "description": "",
  "id": "validating-sprint-module;creating-a-sprint-with-invalid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Open the Browser and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "enter the homepage",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "click on Add Sprint",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "enter invalid data",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "click on save",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "close the Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.open_the_Browser_and_launch_the_application()"
});
formatter.result({
  "duration": 2906773000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_the_homepage()"
});
formatter.result({
  "duration": 37888885300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_Sprint()"
});
formatter.result({
  "duration": 2462080600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_invalid_data()"
});
formatter.result({
  "duration": 3152885900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_save()"
});
formatter.result({
  "duration": 5250281700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.close_the_Browser()"
});
formatter.result({
  "duration": 805108400,
  "status": "passed"
});
});