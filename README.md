## Blackjack Project

### Overview
This is a Java Program that simulates a game of **Blackjack** between the dealer and one player (the user). The goal of the game is for the user to get as close to 21 without going over (busting), while also having a better hand than the dealer. 

### Running the Program 
When the user launches the program they will be presented with a menu that asks if the user would like to **Be Dealt In** the game or **Leave the Table**. If the user chooses to leave the table then the program exits. If the user chooses to be dealt into the game then the cards will be dealt to the user and the dealer. The program will check to see if either the user or dealer got Blackjack after the initial deal. If no one has gotten Blackjack then the program prompts the user to **Hit**, **Stay**, or **Quit**. The user can continue to hit until they are satisfied of they bust. If the user chooses to stay then the dealers cards will be revealed and the program will simulate the dealer *taking their turn*. If the dealer has **less than 17** then they will hit and if the dealer has **17 or greater** then they will stay. The program will determine who has won the game and present the appropriate message. After the message the user will be presented with the same menu they were offered in the beginning of the Blackjack Game so the user can play again if they want.

### Technologies Used
*Java*

* Object Oriented Design
* Abstraction
* Polymorphism
* Inheritance
* Encapsulation
* Enums 

*Eclipse*

*Git / GitHub*

*Terminal*

### Lessons Learned
* Taking a step back and really looking at the UML and the relationships between the classes before jumping into the code. Initially was unable to get values from my list of cards because I was instantiating the list of cards in both my Hand class and BlackjackHand class.

* I did not utilize the Abstract Player Class in this application and should of went back to refactor and take advantage of that class to avoid the duplication of code in the BlackjackPlayer and BlackjackDealer Classes.

