# News Feeds App

It's a sample app that displays news.

## The main used architectures
* MVVM
* Data Repository 

<p align="center">
    <img src="https://i.imgur.com/P3V0gwq.png" width="600">
</p>

---

## Why Model-View-ViewModel (ie MVVM)?
* MVVM is one of the architectural patterns which enhances separation of concerns.
* Google introduced architecture components which includes **LiveData** and **ViewModel** which facilitates developing Android app using MVVM pattern.
* It's helpful to solve common problems like **Tight Coupling** and **Testability**.


### Used Jetpack Architecture Components
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) -  Observable data holder class
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI-related data in a lifecycle-conscious way.

---

## Why Data Repository?
* Decouples the application from the data sources.
* Provides data from multiple sources (DB, API).
* Testable business logic via Unit Tests.
* Easily adding new data sources.

---

## The app has following packages
1. **common**: It has common classes like Application class.
2. **data**: It contains models and data repository.
3. **ui**: View classes along with their corresponding ViewModel.
4. **utilities**: Utility classes.
5. **data.repository (test)**: Test cases for DataRepository class.

<p align="center">
    <img src="https://i.imgur.com/BTdJxcj.png" width="300">
</p>

---

## 3rd Party Libraries
* [KODIN](https://kodein.org/Kodein-DI/) - Dependency injection library.
* [Retrofit](https://square.github.io/retrofit/) - A HTTP client for Android.
* [Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - An OkHttp interceptor which logs HTTP request and response data.
* [GSON](https://github.com/google/gson) - A serialization/deserialization library to convert Objects into JSON and back.