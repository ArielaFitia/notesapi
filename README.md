# Simple REST API for Notes

A lightweight REST API built with Spring Boot for managing notes. This project demonstrates the implementation of CRUD operations with a clean architecture and best practices in Java.

## Features

- **Create Notes**: Add new notes with a title and content.
- **Read Notes**: Retrieve all notes or a specific note by ID.
- **Update Notes**: Modify the title or content of an existing note.
- **Delete Notes**: Remove a note by its ID.
- **Validation**: Ensures that notes have valid input fields (non-empty title and content).

## Technologies Used

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA** (with H2 Database for development)
- **Lombok** (for boilerplate code reduction)

## Running the Project Locally

Follow these steps to run the project on your machine:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/notesapi.git
   cd notesapi
   
2. Build the project:
   ```bash
   mvn clean install

3. Run the application: 
   ```bash
   mvn spring-boot:run

4. Access the API:
   ```bash
   API Base URL: http://localhost:8080

## API Endpoints
### Notes Endpoints

- **GET	/api/notes:**	Retrieve all notes
- **GET	/api/notes/{id}:**	Retrieve a note by ID
- **POST	/api/notes:**	Create a new note
- **PUT	/api/notes/{id}:**	Update an existing note
- **DELETE	/api/notes/{id}:**	Delete a note by ID

### Example Request and Response
### POST /api/notes
```json
{
  "title": "My First Note",
  "content": "This is the content of the note."
}
```
### Response
```json
{
  "id": 1,
  "title": "My First Note",
  "content": "This is the content of the note.",
  "createdAt": "2024-12-24T12:00:00Z"
}
```
## Live Demo
🚀 Coming Soon: A live version of this API will be deployed to Heroku.

## License
This project is licensed under the MIT License. See the LICENSE file for details.