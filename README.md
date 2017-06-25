
# Calculator Challenge

>This Assignment consist of implementation of simple command line calculator in Java by creating nested expression evaluator and implementing continous integration 

Problem Statement [Link](https://github.com/Haricharanpanjwani/calculator-challenge/blob/master/assignment.docx).

Documentation [Link](https://github.com/Haricharanpanjwani/calculator-challenge/blob/master/Documentation.docx).

## Clone the Directory

git clone [Link to directory](https://github.com/Haricharanpanjwani/calculator-challenge.git)


## Clean and Build the code
```
mvn clean install
```
## Compile the code
```
mvn compile

```

## Run the code
```
mvn -X exec:java -Dexec.mainClass="com.codiscope.calculator.App" -Dexec.args="let(a,5,let(b,mult(a,10),add(b,a)))"

```
