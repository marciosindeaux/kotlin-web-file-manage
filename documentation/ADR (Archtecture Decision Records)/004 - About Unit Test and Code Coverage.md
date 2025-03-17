# 003 - About Test and Code Coverage

|||
|---|---|
|`Participant`| Márico Alexandre Freire Sindeaux |
|`Date`| 17/03/2025 |


## 1.Index

 * 1.Index
 * 2.Context
 * 3.Justifications
   * 3.1 Code Quality
 * 4.Decision
   * 4.1 About Unit Tests
   * 4.2 About Arch Tests
   * 4.3 Code and Branch Coverage

## 2.Context

After understanding some needs regarding maintenance and quality, as it is a project that deals with private documents and people and with data from the simplest to the most complex, it was decided that all projects must follow a high level of delivery quality, and for this quality, unit and architecture tests are necessary.

## 3.Justifications 
### 3.1 Code Quality

As we all know, delivered code, even in non-critical situations, should always be tested, because valuing code quality is always a gain. Unit tests are extremely efficient in preventing new bugs from arising. Considering this point, it is important to propose a code coverage quality metric, as well as architectural tests.

## 4.Decision
### 4.1 About Unit Tests

After understanding the need for unit tests, it was decided that the projects would use two libraries to do so: [_JUnit_](https://docs.spring.io/spring-boot/reference/testing/index.html) which comes with the Spring platform and [_Mockk_](https://mockk.io/), which is the most interesting tool for working with mocks in Kotlin

### 4.2 About Arch Test

After understanding that the projects created must follow an architecture that will be specified in the future, so that no project can be destandardized, we will use [_ArchUnit_](https://www.archunit.org/) for architecture testing and separation of application layers.

### 4.3 Code and Branch Coverage

After understanding the application quality requirements, we established the following code coverage quality targets:

 * Code coverage: 90%
 * Branch coverage: 90%





