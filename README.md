# NewsApp
Project - Byju’s News Application

This News Application has two Activity pages (NewsActivity) which is displaying list of News articles
With the help network api(https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001
), and another activity News Detail activity page which displays detail of that particular article

Getting Started
The main page called News Activity page which is called to display the News article info on that page using following API calls.

1) News API call -> https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-24&sortBy=publishedAt&apiKey=c96d27cfad814260a641accf02576001
Above API calls being called in main page and animation UI is displayed as per requirement, it has 20 articles list as shown on main page.

3) The class NewsViewModel is used as ViewModel which is container of data after calling apis. It calls api from News Service interface with help of Retrofit and RxJava.

4) The class NewsListingAdapter is used to display the list items of News  articles with help of recyclerview list adapter and item list xml.

5) This application is using Dagger 2 for dependency injection, to create top level objects for Network Service, Application context, Gson and etc

6) In this application RXjava is used for multi threading to call network apis on different thread rather than android main thread.

7) This application has following test cases
   1) Unit tests with Mockito
   2) Android UI Instrumentation test with Espresso

   following are the unit tests covered
   1) testToCheckIsNewsApiSuccessful
   2) testToCheckIsNewsApiFailure
   3) testToCheckArticleListIsEmptyOrNot
   4) testToCheckFirstArticleTitle
   5) testToCheckFirstArticleDescription
  
   and following are Android UI Instrumentation test with Espresso
   1) showError
   2) checkIsProgressBarVisible
   3) confirmNewsTitleNameDisplayedOrNot
   4) populateRecyclerViewSuccess
   5) populateRecyclerViewWrongData

   That's all!!
