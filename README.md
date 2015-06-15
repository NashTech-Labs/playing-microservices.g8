This is your new Play application
=================================

This file will be packaged with your application, when using `activator dist`.

### Scalastyle : Check the code quality

To check code quality of all the modules
```
$ ./activator clean compile scalastyle
```

### Scoverage : Check code coverage of test cases

To check code coverage of test cases for all modules
```
$ ./activator clean coverage test
```
By default, scoverage will generate reports for each project seperately. You can merge them into an aggregated report by invoking
```
$ ./activator coverageAggregate
```

### Deployment : dev environment

##### microservices
```
$ ./activator "project <service-name>" "run <PORT>"
```
