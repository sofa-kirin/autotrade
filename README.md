<h1>AutoTrade — Car Dealership System</h1>

<p>
AutoTrade is a car dealership platform designed to support vehicle browsing, filtering, and purchase inquiries.
The system allows customers to explore available cars and contact the dealer, while the dealer can manage and publish car listings through an admin interface.
</p>

<p>
The project is <b>currently under active development</b> and is planned to evolve into a full-stack application with a dedicated frontend.
</p>

<h2>Core Features</h2>
<ul>
  <li>Browse available car listings</li>
  <li>Search and filter cars by make, model, year, and price</li>
  <li>View detailed car information with specs, description, and images</li>
  <li>Submit purchase inquiries to the dealer</li>
  <li>Admin panel for creating, updating, and deleting car listings</li>
</ul>

<h2>Architecture</h2>
<ul>
  <li><b>Controller</b> — REST API layer</li>
  <li><b>Service</b> — business logic and validation</li>
  <li><b>Repository</b> — data access layer using Spring Data JPA</li>
  <li><b>Model</b> — domain entities</li>
</ul>

<p>
The application follows a layered architecture to keep responsibilities separated and the codebase maintainable.
</p>

<h2>Technologies</h2>
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>Maven</li>
  <li>REST API</li>
</ul>

<h2>Current Domain Model</h2>
<ul>
  <li><b>User</b> — system user</li>
  <li><b>Role</b> — user role and access level</li>
  <li><b>CarListing</b> — vehicle advertisement</li>
  <li><b>CarImage</b> — images connected to car listings</li>
  <li><b>Favorite</b> — saved listings</li>
</ul>

<h2>Planned Domain Model</h2>
<ul>
  <li><b>Dealer</b> — administrator responsible for managing listings</li>
  <li><b>Inquiry</b> — customer contact or purchase request</li>
  <li><b>Car Specification Details</b> — extended vehicle information such as fuel type, transmission, mileage, colour, and description</li>
</ul>

<h2>🚀 Development Status</h2>
<p>
The project is actively evolving. The core architecture and system design are already defined, with domain models and overall structure planned in advance. 
Development is currently focused on implementing key functionalities, including REST APIs, filtering logic, inquiry handling, and authentication.
</p>

<h2>Planned Features</h2>
<ul>
  <li>Advanced search and filtering</li>
  <li>Admin authentication and authorization</li>
  <li>Full CRUD operations for car listings</li>
  <li>Persistent relational database integration</li>
  <li>Customer inquiry management</li>
  <li>Frontend application for a full-stack experience</li>
  <li>Improved validation and exception handling</li>
  <li>Unit and integration testing</li>
</ul>

<h2>📌 Purpose</h2>
<p>
This project is built as a portfolio application to demonstrate practical skills in Java backend development,
REST API design, relational data modeling, and scalable application architecture.
</p>
