# Football League

<img src="https://github.com/sherifsharweed/FootballLeague/assets/96727431/f5644ae7-ead3-47f8-9218-d220987aca20" alt="1" height="300"/>
<img src="https://github.com/sherifsharweed/FootballLeague/assets/96727431/412291f2-0786-458b-b9a7-3cf5585d5cdb" alt="1" height="300"/>
<img src="https://github.com/sherifsharweed/FootballLeague/assets/96727431/87b2ed1a-79b4-46ac-878f-204b6d2f1def" alt="1" height="300"/>
<img src="https://github.com/sherifsharweed/FootballLeague/assets/96727431/9f223924-1700-4a7a-a5a0-bffeaf8951af" alt="1" height="300"/>

An application for football leagues and competitions :

1- First screen is the main screen for competitions, it has a list of competition item (name, country, flag, emblem) with horizontal scroll view .

2- User can click on any item, Then it'll redirect to the competition's detail screen.

3- User can see the details of specific competition in the second screen (title,area,matches,start date,end date,date of last update).

4- If the request is still being processed, User will see an animation for loading until it's done.

5- If there's an error, A message will be seen by user to inform him that there's something abnormal.

6- If there's no internet connection, A toast will appear to user and will retrieve data from secure offline database.


# Application architecture and structure

It is a single module project architecture. And, I'm following the Clean Architecture as a Software Architecture Pattern and MVVM as a Presentation Layer Pattern.

# Third-party used

1- Jetpack Compose : for creating UI.

2- Jetpack Navigation.

3- Retrofit and OkHttp: for making secure network calls from API.

4- Room and SQLCipher: for caching data in secure offline storage.

5- Coroutines : for handling the background operations.

6- Hilt : for dependency injection.

7- Coil : for presenting images.
