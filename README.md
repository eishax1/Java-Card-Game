# Make 11 Card Game

## Overview
**Make 11** is a card game implemented in Java. The goal is to combine the values of cards in hand to make 11 with the top card dealt by the computer. The game includes several features, such as scoring, replaying rounds, and a high score system.

## How to Play
- The game begins with the player being dealt 5 cards.
- In each round, the computer deals a top card.
- The player must select one card from their hand to make a sum of 11 with the top card.
- If the sum equals 11, a point is scored, and the game continues.
- The player can also play cards of the same suit or opt to play picture cards.
- The game ends if the player cannot make 11 or play a matching suit.
- Players can view a replay of their game and check if they made it to the high score table.

## Features
- **Round-based gameplay:** Players are dealt cards and attempt to make 11.
- **Replay system:** View the details of each round.
- **High score tracking:** Track the top scores and see if you made it to the leaderboard.
- **Interactive input:** The game takes user input for card selection, suit matching, and picture card plays.

## Classes Overview
- `Make11`: The main class that controls the flow of the game, scoring, and high score system.
- `Deck`: Represents a deck of cards and handles dealing cards to the player.
- `Player`: Manages the player’s hand and actions during the game.
- `Round_info`: Stores the details of each round for replay purposes.
- `HighScore`: Manages the high score table and allows for updates.

## Requirements
- **Java 8 or higher**

## Running the Game
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/make-11-card-game.git
