# TheMovies
This repository serves as a showcase for the capabilities. Here, you'll find the source code, documentation, and examples highlighting the features and functionalities of TheMovies. Feel free to explore, experiment, and learn more about what our app can do.

The application consumes API from TMDB - The Movie Database (TMDB) where you will find the definitive list of currently available methods for our movie, TV, actor, and image API
[ Link to TMDB docs](https://developer.themoviedb.org/docs)

Curently the application displays Top 10 popular movies and their respective details.

### Application Icon
<div>
  <img src="https://github.com/jitendraAndroid/TheMovies/assets/13868320/dbc89a11-29f1-45c8-832a-519dd4f6cc0b" width="200" height="200"/
</div>

## Technical stack
* Kotlin 
* Coroutines flow
* Jetpack Compose
* Hilt

## Architecture
The application is designed with MVVM architecture

* View - The views of the application are designed using Jetpack compose
* ViewModel - The ViewModel is responsible for exposing the data from the model(data)
* Repository - This layer acts as a bridge between the viewModel and Data layer, separating the data layer and handling the business logic
* DataSource - Normally this can be bifurcated based on the different data sources but for this application, it's restricted only to the API response

## Features Integrated
* Centralized dependency management  with buildSrc - ensure consistency of the dependent versions in all the modules used inside the application
* Jetpack compose - A Modern toolkit for building UI, which provides features of Declarative UI, less boilerplate code, Live preview, and interactive development and mainly helps in separating UI logic from UI presentation layer
* Kotlin Coroutine flow - The application uses coroutine flow which is flexible compared to LiveData, more holistically implemented and supports KMM. It goes great with declarative development
* Dependency Injection is supported with the help of the Hilt library, built on top of the popular Dagger library

## Features planned
* Unit testing of ViewModel
* Updating detail screen UI for better user experience
   
## Screenshots
<img src="https://github.com/jitendraAndroid/TheMovies/assets/13868320/5b50b0b0-abfb-4682-9ce2-fad5dd97b788" width="200" height="400"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/jitendraAndroid/TheMovies/assets/13868320/cd4798fd-4969-4464-a2a3-205f1cb64c97" width="200" height="400"/>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/jitendraAndroid/TheMovies/assets/13868320/7cb89187-ba79-4b7b-9541-1d6bfcf06cba" width="200" height="400"/>


