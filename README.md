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
    
    DefaultPlayerMapInteraction is very interactive. It interacts with CollisionInteractionMap and 
    DefaultInteractionMap. It has 0 coverage for other classes. But PlayerCollision test suite has only 
    interaction with PlayCollisions. It doesn't interact with any other class.

2)  Question 1:
    But, in your opinion, what are the main disadvantages of such approach?  Explain your reason
    
    Mocking interaction between classes is complex and results in test sensitive to implementation details.
    It also results in over-abstraction and design damage by implementing too many interfaces.
    Mocking cannot mock constructors or static methods.
    
    Question 2:
    There are occasions in which we should use the class’ concrete implementation and not mockit. In what cases should one mock a class? In what cases should one not mock a class?Hint:  Think about the test level (unit,  integration,  system testing).   You can also read thefollowing paer
    
    When a class has too many interaction with external services like a database then its better to mock it. This can 
    Especially if that class does something dangerous like deletion then it is better to mock. Mock will also prevent 
    errors of other classes from seeping into our own test cases. 
    
    But mocks shouln't be used when multiple classes interact with each other.These interactions are complex to mock.
    Also mocks need be kept in sync with production code. In case interaction between actual code and some component changess
    this has to be added to the mocks too. 


Week of November 2 Lab 7:

    Exerise 3:
    
    For system tests you are testing a system as a whole. In scenario 2.4 and 2.5 I tested the system earleir via 
    unit testing. In those scenarios we mocked ghost, player and pelllet and just checked the collide function. 
    Thus, the scope of the testing was really small. We were just checking whether setlkiller(ghost_object) was called when colided with player, etc. 
    But now since we are testing the whole system, we cannot mock any classes. We also have to make use of multiple different classes,
    like get the square where we expect the player to be at the end then checking whether there is an actual player occupying it or not. 
    Thus, the scope and complexity has increased in system testing. 
    
    Exercise 5:
    
    The unit tests for ghost were simple. Mockito helped in mocking objects like ghost, pellet and player. Allthat was needed to be 
    done was use collision function from PlayerColision. But in system tests we will need to use actual instance of all these components.
    The bigger problem is that ghost moves automatically. You can't move them in a specific direction. Thus, specific maps need to be made 
    to enable collision with other items like pellet and player. Thus, due to scope and complexity has increased. 
