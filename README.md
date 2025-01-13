# CadeauxHubListe

## Project Status
This project is currently under development (Work in Progress). Some features might not yet be implemented or finalized.

## Description

CadeauxHubListe is a web and mobile application designed to simplify the management of gift lists, especially for occasions like Christmas. This project has a dual purpose: to learn technologies such as Java with Spring Boot and React, and to provide a practical and collaborative solution for managing gift wishes within a group.

## Key Features

1. **Group Management**:
   - Create personalized groups.
   - Invite members to join groups.

2. **Gift Lists**:
   - Create individual wish lists for members.
   - Share these lists with other group members.

3. **Gift Reservation**:
   - View other members' gift lists.
   - "Reserve" a gift to select it for purchase.
   - Guaranteed anonymity: the list owner cannot see who reserved their gifts.

4. **Duplicate Management**:
   - Clear indicators for already reserved gifts to avoid multiple purchases of the same item.

5. **Tracking**:
   - Easy access to your groups, lists, and ongoing reservations.

## Technical Objectives

### Back-end
- Create a REST API with **Spring Boot** to:
  - Manage users, groups, gift lists, and reservations.
  - Implement a secure authentication system (e.g., with Spring Security and JWT).

### Front-end
- Develop an intuitive and responsive user interface with **React**.
- Use tools like **React Router** for navigation and **Axios** for API calls.

### Database
- Use a relational database (**MySQL**) to efficiently store data.

### Deployment
- Host the application on a cloud platform (e.g., **Heroku**, **AWS**, or **Railway**) for online accessibility.

## Potential Future Improvements
- **Notifications**: Send email or push notifications to inform members when a gift is reserved.
- **Budget Management**: Allow users to set budgets for gifts and visualize them.
- **Other Events**: Add features for managing birthdays or other similar occasions.

## Installation
⚠️ This application is still under development. Installation steps will be provided as the project progresses.

### Installation and Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/CadeauxHubListe.git
   ```

2. **Back-end**:
   - Navigate to the `backend` folder.
   - Install Maven dependencies.
   - Configure your database in `application.properties`.
   - Start the Spring Boot application.

3. **Front-end**:
   - Navigate to the `frontend` folder.
   - Install npm dependencies:
     ```bash
     npm install
     ```
   - Start the React application:
     ```bash
     npm start
     ```

4. **Access**: Open your browser at the following address: `http://localhost:3000`

### Contributions
This project is in its early development phase. Any suggestions or feedback are welcome to help guide the application's direction.

To contribute:

1. **Fork this repository**.
2. **Create a new branch** for your feature or bugfix.
3. **Make your changes** and ensure they are well-tested.
4. **Submit a pull request (PR)** to the `main` branch with a clear description of your changes.

### Guidelines
- Keep your PRs focused on a single issue or feature.
- Ensure code quality by following best practices.
- Write clear commit messages.

Thank you for your interest in improving CadeauxHubListe!

## Legal Notice
This project is licensed under CC BY-NC 4.0 - see LICENSE file
⚠️ This is a work in progress - see DISCLAIMER.md


---

Thank you for your interest in CadeauxHubListe! I hope this application will help you organize your gift exchanges in a simple and collaborative way.

