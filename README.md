# AKNewYork1-NewYorkTimesData
 
### An Android library for communication with the external **NYTimes** service.  

![The_New_York_Times_Logo](https://user-images.githubusercontent.com/21279903/171217186-969b02e6-9ab5-40bc-927f-9b19ea0ef579.jpg)

## Requirements  

| Android API Version Min 
| -------------
| 21

## Getting Started    
-----------------------
#### To start using this library, follow the steps below:

1. Add the new submodule with this git command line:
```git
git submodule add https://github.com/AlbaErik/AKNewYork1-NewYorkTimesData.git libs/NewYorkTimesData
```
2. Modify the **settings.gradle** file so that the library is compiled as a module by adding the following lines :
```kotlin
include ':new-york-times-data'
project(':new-york-times-data').projectDir = new File('libs/NewYorkTimesData')
```
3. perform **Sync Project with Gradle files**. 
4. Add this line as a new Gradle dependency :
```kotlin
implementation project(':new-york-times-data')
```
5. perform **Sync Project with Gradle files**.

# NYTimes Service Setup  
______________

To import the module
```kotlin
import ayds.ak1.newyorktimes.article.external.NYInfoService
```

Get an instance of NYInfoService:

```kotlin 
val nyInfoService: NYInfoService = NYInjector.nyInfoService
```

With this method you can retrieve information from the NYTimes service:

```kotlin
nyInfoService.getArtistInfo(artistName)
```
## Edge cases responses
______________

In case of lose internet connection the library returns   

 ```kotlin
null
```

In case the requested article is not found, the library returns null.
