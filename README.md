Just run this application, there's no need to create DB, the App uses H2 database and all tables will be created by Spring.

The DataInit class adds data to the database when the application starts.

The URLs:

- (GET) http://localhost:8080/department - get all departments from the Db;

- (GET) http://localhost:8080/department/{department_id}/statistics - get the department by id from the Db;

- (GET) http://localhost:8080/lector - getting all lectors from the Db;

- (GET) http://localhost:8080/lector/{lector_id} - getting the lector by id from the Db;

- (PUT) http://localhost:8080/lector/{lector_id}/promote - promoting the lector by id and save new degree to the Db;

- (POST) http://localhost:8080/lector/{lector_id}/update - updating the lector by id and save them to the Db;



The video that shows how the app works: https://drive.google.com/file/d/1FvnLfvxA9O1bVVNNvBgvjd-_XG4Y1Ef-/view


App runs on localhost and on port 8080 for working with The front-end application: https://github.com/MykolaLytvynov/ui-univer-api/tree/master/src

(Spring Boot, Spring Data JPA, Spring Web, Maven, H2, Lombock)
