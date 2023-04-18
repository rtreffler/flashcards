# What is this?

Project I did as a part of [Hyperskill](https://hyperskill.org) course [Kotlin Basics](https://hyperskill.org/tracks/18).

It's a simple flashcards program with ability to import and export data.

File has the following format:
- file is plain text
- each flashcard is in separate line
- flashcard consists of:
  - error count - an integer
  - term - a string
  - definition - a string
- each flashcard's part is separated by ` -> `, that is:
  - `a space`,
  - `a minus sign`,
  - `a right triangle bracket`
  - `a space`

Example file:
```
 -> London -> capital of England
0 -> Warsaw -> capital of Poland
2 -> Dhaka -> capital of Bangladesh
```

It implements Strategy pattern to handle different commands by separate command implementations.

# How to run
When imported into IntelliJ IDEA it should just work. If not, Build -> Rebuild project.

# Comment
Any comments, pull requests, issue tickets appreciated. I'm particularly interested in build improvement and tests. 
