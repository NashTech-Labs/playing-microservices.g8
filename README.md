[playing-microservices](http://blog.knoldus.com/2015/06/15/play-microservice-architecture/)
=================================

This repository describes a basic Microservice architecture design using Play 2.4.X and Scala. The big idea behind microservices is to architect large, complex and long-lived applications as a set of cohesive services that evolve over time. The term microservices strongly suggests that the services should be small.

In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API.

#### Single node microservice architecture

![alt tag](/web/public/images/microservices-arch.png)

#### Multiple node microservice architecture with load balancer

![alt tag](/web/public/images/microservices-arch-with-elb.png)


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

### Deployment : microservices
```
$ ./activator "project <service-name>" "run <PORT>"
```

-----------------------------------------------------------------------
### References
-----------------------------------------------------------------------
* [Play Framework](http://www.playframework.com/)
* [Microservices](http://martinfowler.com/articles/microservices.html)
* [Microservices: Decomposing Applications](http://www.infoq.com/articles/microservices-intro)
