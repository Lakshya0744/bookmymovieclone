# BookMyMovie Backend

A Spring Boot backend application for the BookMyMovie project with in-memory data storage.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bookmymovie/
│   │           ├── BookMyMovieApplication.java (Main class)
│   │           ├── controller/
│   │           │   └── MovieController.java
│   │           ├── service/
│   │           │   └── MovieService.java
│   │           └── model/
│   │               └── Movie.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── bookmymovie/
                └── BookMyMovieApplicationTests.java
```

## Setup and Running

1. **Build the project:**
   ```bash
   mvn clean install
   ```

2. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the application:**
   - Main application: http://localhost:8081
   - Movies API: http://localhost:8081/movies

## Sample Data

The application comes with pre-loaded sample movies:
- Barbie
- Oppenheimer
- Jawan
- Kantara
- Pathaan
- RRR
- Spider-Man: Across the Spider-Verse

## Debugging

### IDE Setup
1. Import the project as a Maven project
2. Set breakpoints in your Java files
3. Run the application in debug mode

### Common Issues and Solutions

1. **Port already in use:**
   - Change `server.port` in `application.properties`
   - Or kill the process using the port

2. **Package not found errors:**
   - Ensure all files have correct package declarations
   - Run `mvn clean compile` to verify compilation

### Debug Endpoints

- `GET /movies` - Get all movies
- `POST /movies/upload` - Upload a new movie (commented out in controller)
- `GET /movies/{id}/image` - Get movie image (commented out in controller)

## Development

The application uses:
- Spring Boot 3.2.0
- In-memory data storage (no database required)
- Maven for dependency management

## Next Steps

1. Uncomment the upload and image endpoints in `MovieController`
2. Add more movie properties (description, genre, etc.)
3. Implement user authentication
4. Add movie search functionality
5. Switch to database storage when ready
