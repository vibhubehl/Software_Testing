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
	 
