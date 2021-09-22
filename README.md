# Getting Started with eCommerceology

This project was created using React, Java and a PostgreSQL Database.

## Prerequisites

Make sure you have downloaded and have installed the following on your machine:
* Node.js 
* Java 16
* Maven
* PostgreSQL

## Helpful tips

* Using some type of UI for PostgreSQL such as PGAdmin 4 is recommended as it makes the backend development much simpler.
* Download the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) for Visual Studio Code.

## Clone this Repository

`git clone https://github.com/Carter-Walsh/eCommerce-site.git`

## Run the Application

* Once you have cloned the repo to your local machine, navigate to it and open it in the IDE of your choice. 
* Navigate to the frontend of the application with `cd src/frontend` and run it with `npm start`
    * The React portion of this application should now be running on port 3000
* To run the backend Java portion of this application, use `./mvnw spring-boot:run
`
* Lastly, start your PSQL database using the command `psql` in your terminal.

## Things to Know

* This project uses Spring Batch to copy data from a CSV file and import it into the database. If you are unfamiliar with Spring Batch, you can read more about it from [here](https://spring.io/projects/spring-batch) and walkthrough an example [here](https://spring.io/guides/gs/batch-processing/)
* Additionally, the backend of this project uses the [Hibernate Framework](https://hibernate.org/orm/) with JPA for Object Relational Mapping to the PSQL database. 
* The frontend of this application uses [React Router](https://reactrouter.com/web/guides/quick-start) to navigate through its components and [React Bootstrap](https://react-bootstrap.github.io/getting-started/introduction) for styling. 
