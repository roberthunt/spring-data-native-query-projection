A simple project to demonstrate the use of query projection with both JPA and native queries using Spring Data JPA.

* Spring Boot 1.4.1 RELEASE
* Spring Data JPA 1.10.3.RELEASE (Hopper SR3)

There is a simple **Person** entity with *id*, *name* and *age* and a **PersonSummary** interface with just *name* and *age*.

There are 6 tests, the tests which make use of native queries fail.