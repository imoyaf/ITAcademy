# Sprint 5 Task 1 Level 3

<br/>

## Exercise 1


In a sports news editorial, the news is classified by sports: football, basketball, tennis, F1, and motocross.

The editorial can have more than one writer, and for each of them, we want to know their name, ID number, and salary. Once an ID number is assigned, it cannot be changed. All writers have the same salary, and if in the future the company increases the salary, it will apply equally to everyone. For now, the current salary is €1500.

Each writer can work on more than one article. Articles must have a title, text, a rating, and a price. When an article is created, the text should be empty.

Additionally, for football articles, we need to know which competition it refers to (String), which club (String), and which player (String).

For basketball articles, we need to know which competition it refers to (String) and which club (String).

For tennis articles, we need to know which competition (String) it refers to and which tennis players (String).

For F1 articles, we need to know which team (String) is being referred to.

For motocross articles, we need to indicate which team (String) they belong to.

Articles are sold to various media outlets. To determine the price of each article, we need to implement a method called calculateArticlePrice().

The following explains how to calculate the price of each article:

**Football articles:**

    Initial price: €300
    Champions League: €100
    Barça or Madrid: €100
    Ferran Torres or Benzema: €50

Example: An article about a goal by Ferran Torres of Barça in the Champions League has a price of €550.

**Basketball articles:**

    Initial price: €250
    Euroleague: €75
    Barça or Madrid: €75

**Tennis articles:**

    Initial price: €150
    Federer, Nadal, or Djokovic: €100

**F1 articles:**

    Initial price: €100
    Ferrari or Mercedes: €50

**Motocross articles:**

    Initial price: €100
    Honda or Yamaha: €50

To calculate the ratings of the articles, the following criteria are used:

**Football articles:**

    5 points
    Champions League: 3 points
    League: 2 points
    Barça or Madrid: 1 point
    Ferran Torres or Benzema: 1 point

Example: An article about a goal by Ferran Torres of Barça in the Champions League has a score of 10 points.

**Basketball articles:**

    4 points
    Euroleague: 3 points
    ACB: 2 points
    Barça or Madrid: 1 point

**Tennis articles:**

    4 points
    Federer, Nadal, or Djokovic: 3 points

**F1 articles:**

    4 points
    Ferrari or Mercedes: 2 points

**Motocross articles:**

    3 points
    Honda or Yamaha: 3 points

In the main class, a menu must be created with the following options:

1. Add a writer.
2. Remove a writer.
3. Assign an article to a writer.
4. Remove an article (it should ask for the writer and article title).
5. Show all articles by a writer.
6. Calculate the article’s score.
7. Calculate the article’s price.