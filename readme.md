# Design Patterns Exercise: Movie Problem
## We would love to search for a movie and

### Display Movie title and year.

### Display all the actors

### If the actor has more movies display it.


## Setup

- Clone the repository
- Open the project in ECLIPSE
- Review The class structure and build the program



## Design Patterns that needs to be used:

- Adapter - to transform the MovieApiResponse in a Movie
- Composite - We have a tree situation with movie > actors > movies

```
interface Movie {
  String getPerformances()
}

```


#### Weather Api Response

```java
public interface ApiResponse {

	public int responseCode();
	public String responseBody();
	
}
```

#### Builder usage:

```java
WeatherApiRequestBuilder builder = new WeatherApiRequestBuilder();
WeatherApiRequest request = builder.apiKey('apikey').location('Buenos Aires').days(1).build();
WeatherApiResponse response = request.get();
```

#### Weather api key:

#### Api documentation:

https://www.weatherapi.com/api-explorer.aspx#forecast


```
06712f56f6e2431590b184348232905
```


