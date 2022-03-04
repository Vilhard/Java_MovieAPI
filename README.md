# Java_MovieAPI

 Spring Web application that comprises database made in PostgreSQL trough Hibernate with RESTful API. Documentation can be found from Swagger. This was a weekly assignment of Experis Academy's Java course.

The API consists of three objects:
- Movies - A movie can have multiple characters and one franchise
- Characters - A character can be a part of multiple movies
- Franchises - A franchise can have multiple movies

There are basic CRUD elements for all object. User can also get movies or characters in franchise and update movies in franchise or characters in movies.


## To get started:
```
docker run -d --name postgres -e POSTGRES_PASSWORD=supersecretpassword -e POSTGRES_DB=mydb -p 5432:5432 postgres:14-alpine
}
```

Swagger user:
- Username: spring
- Password: spring