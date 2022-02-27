# Student Scheduler Application
This is a simple full stack development practice project using Spring, PostgreSQl and React

## List of Routes to Test your API

### CRUD Routes

**api/person GET:** Gets the list of people in the database \
**api/person/id GET:** Gets the person with ID requested in the path \
**api/person/login GET:** Gets the person with the email and password provided as params \
**api/person POST:** Inserts a person in the database and requests JSON body \
**api/person POST:** Registers a person with the provided parameters \
**api/person/id PUT:** Updates person table with requested ID and requests JSON body \
**api/person/id DELETE:** Deletes a person with the requested ID \
**api/todo GET:** Gets the list of todo in the database \
**api/todo/id GET:** Gets the todo with ID requested in the path \
**api/todo POST:** Inserts a todo in the database and requests JSON body \
**api/todo/id PUT:** Updates a person in the database with requested ID and requests JSON body \
**api/todo/id DELETE:** Deletes a person with the requested ID

### Custom Routes

**api/person/id/todos GET:** Get Todos for the person with requested ID \
**api/person/id/todos/date GET:** Gets todos before a certain date (form input) for the person with requested ID
