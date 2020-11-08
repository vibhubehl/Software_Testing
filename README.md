# JPacman


## About

Pacman-like game used for teaching software testing.
It exposes students to the use of git, Gradle, JUnit, and mockito.

Parts of the code are well tested, whereas others are left untested intentionally. As a student in software testing, you can extend the test suite, or use the codebase to build extensions in a test-driven way. As a teacher, you can use JPacman to create your own testing exercises.

## Getting Started

### IntelliJ
1. Git clone the project
2. Open IntelliJ and create new project "from existing sources"
3. Select 'Gradle' in the following screen as external model, and click 'Next'
4. In the next screen, optionally adjust the Gradle options and click 'Finish'
5. To see JPacman in action: run `Launcher`
5. To run the test suite in IntelliJ: right click on a test or directory -> `Run` or `Run ...Test`

### Command line
1. Git clone the project
2. To see JPacman in action: `./gradlew run`
3. To run the test suite and static analysis tools: `./gradlew check`
    1. For tests only run `./gradlew test`
    2. For static analysis tools only run `./gradlew staticAnalysis`
	 

#### Questions 

1. Why can’t we exhaustively test our entire software project? What should we do instead? (max 100 words)

    A program can have a range of inputs and outputs. Its not possible to map all of them. Even if it would be
    the money and time it would take will be huge. Also such a system would be complex. 

2. What is the pesticide paradox about and what does it imply to software testers? (max 100 words)
    
    Pesticide Paradox is when we test a software and we are able to find bugs in it. But when we resolve these bugs.
    we introduce new bugs that our old test cases can no longer find. Thus, testers need to keep updating their test
    cases with time. 
    
3.  Why should we automate, as much as possible, the test execution? (max 100 words)
    
    By automating tests, we decrease the execution time. We are also able to cover a large array of 
    tests with depth and scope impossible to achieve via manual testing. Automating tests results in 
    imporved software quality. 
    
LAB Smoke Test Excercise 

4) DefaultPlayerInteractionMap and collissionInteractionMap have the least coverage at 0%.

5) Game class is covered, at 85%
    Yes Game class is covered by smoke test. On commenting out the line that invoked move class the smoke test failed. 
    Smoke test uses method for testing purposes, but by commenting out we break the code. Smoke test is helpful in telling
    where the error is. It shows that expected and actual values, as well as the filename and exactly which line is the problem.
    
6)  Again the smoke test failed. It was very difficult to find the error. I suppose this is because direction class is used
    by many other classes. 
    
7)  The game class handles the main game using other classes. The level class intereacts with board and players on the board.
    The board class interacts with square and units.


Week of October 5:

1)  Note that our tests always make use of “clean instances” of the class under test.  See Board-FactoryTest as an example: thesetUp()always instantiates a new BoardFactory instance.What are the advantages of such approach?(max 100 word)
   
   We make clean instanes to make sure that each test is executed independetly, without being affected by previous execution,
   
2)  JUnit and related libraries provide developers with different ways to do assertions. Some canbe better than others in specific contexts. Which one is a better assertion, supposing some inta? 1)assertEquals(1, a);or 2)assertTrue(1 == a)? Discuss the differencesbetween both assertions.(max 100 words)

    The 1)assertEquals(1, a) is a better way of assertion, as it tells the user the actual and expected value in case the assertion fails. 
    

Week of October 26:

1)  |   |   |   |   |   |   |   |   |
    |---|---|---|---|---|---|---|---|
    | Collider     | Ghost | Ghost   | Player   | Ghost   | Pellet  | Player   |  Pellet   |
    | Collidee     | Ghost | Player  | Ghost    | Pellet  | Ghost   | Pellet   |  Player   |
    | Consequence  |  NON  |G.OVER   |  G.OVER  |   NON   | NON |   Points += 10| Points += 10 |
    

    For the code coverage, I achieve 33% class coverage 30% method and 27% line coverage.
    Alone with PlayerCollion test suite. Player collission only has 8% class coverage and 10% 
    method coverage. DefaultPlayerMapInteraction test suite significantly increases coverage. 
    It alone covers 25% class and 20% method.