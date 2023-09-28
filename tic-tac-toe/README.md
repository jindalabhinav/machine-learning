# Tic Tac Toe

This might seem easy at first, but let's delve into it and see how this pans out. But extremely important from an interview point of view.

What we want to understand is:

- Approach for design
- Requirements gathering
- Entities
- Class Diagram

## Problem Statement

The Problem statement could be anything, like Design. When asked for Design, we have:

- Knowns
- Unknowns
  - Ask for more questions like an overview, or what is x?

## Requirement Gathering

This is what needs to be implemented, but that might not give the entire picture, so asking questions and gathering requirements becomes very important.

`Requirement Gathering = Asking Questions`

- Current scope
- Future scope
- Behaviour

Now we cannot ask A LOT of questions, but write them down and categorize them to be asked. For this activity, some valid questions might be:

- **Current Scope** (easier to guess, and most of these questions might even not be required)
  - Structural Components (what is the game made up of)
    - Size of board
      - `N x N OR 3 x 3 to begin with`
    - How many players
      - `Human` and `Computer/Bot`
    - Types of players
    - Symbols
      - `O and X`

- **Future Scope** (what can change or be made dynamic)
  - `Need an N x N board`
  - `How many players, we could have multiple`

- **Behaviour** (Think where will you start, and form a flow of events)
  - Your Symbol `(O OR X)`
  - Whom are you going to play against `(Human or Bot)`
  - If Bot, What's the Difficulty Level `(Easy/Medium/Hard)`
  - Who should start the Game `(maybe Randomly)`
  - How will we play `Alternatively`
    - If a player has 3 consecutive symbols (in a column/row/diagonal) `Then the player wins`
    - Could there be a Draw/Tie `If all the spaces are filled and no one won`

> `FOCUS ON REQUIREMENTS, DON'T GIVE FEAUTURE SUGGESTIONS.`

`Once you have identified the requirements, should you jump into code directly?`

No, we need to design first.

## Design

The different:

- components
- Entities/classes

Look for Nouns in your requirements, you'll identify the Entities. We'll see some other techniques as well on the way.

The Gathered Requirements and identified `Entitities`, *Attributes*, and **Methods**

- `Board` can be of any NxN *size*
- There can be 2 `players`
- Each player will be allotted a `symbol`
- The symbol can be *O and X*
- The players can be of *type* either human or bot
- Each player will have a *name, email and profile image*
- Each bot will have a *difficulty level*
- Any random player can **start** the `game`
- The players will take turns to **play** alternatively
- The player with any consecutive N symmbols in a row, column or diagonal **wins** (check winner)
- If the board us full and no player has won, the game is a **draw**

## Class Diagram

- Game (Class)
  - \- board: Board 
  - \- human: Board 
  - \- bot: Bot 
  - \- board: Board 
  - \- board: Board 