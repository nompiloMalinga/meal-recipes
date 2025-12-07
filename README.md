
Fetches all meal categories from [TheMealDB API](https://www.themealdb.com/api.php).  
Exposes categories via a REST endpoint /api/meals/categories.
Returns proper HTTP status codes:  
  200 OK when categories are available.  
  503 SERVICE_UNAVAILABLE when upstream API fails or returns empty.  
Uses Spring Boot, RestTemplate, and DTOs for clean data handling.  

##Tech Stack  

Java 17  
Spring Boot 3.5.7  
Spring Web (REST APIs)  
Mockito & JUnit 5.  
