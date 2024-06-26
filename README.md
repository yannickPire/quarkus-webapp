# Database setup
```shell
docker run --platform linux/amd64 -d --publish 3306:3306 --name sakila restsql/mysql-sakila
```

# Run the application in Quarkus DEV mode

```shell
./mvnw compile quarkus:dev
```

# Run the application in Quarkus DEV debug mode

```shell
./mvnw compile quarkus:dev -Ddebug
```

# Build a native executable

```shell
./mvnw package -Pnative
```

Or when using the Quarkus CLI 

```shell
quarkus build --native
```

# Known Issues

This project is based on the following tutorial

https://www.youtube.com/watch?v=KZnQ5R8Kd4I&list=PLXrGgUEmVqmBNo9bK4hQry6cfJBnJ6bg7

I started out from working with the latest Java LTS version as well as the latest possible Quarkus version as well as the included plugins

I noted following issues 

- Due to an open bug from the JPA Streamer plugin in combination with Hibernate 6.3, this plugin will not work anymore (https://github.com/speedment/jpa-streamer/issues/390)
- I had to use the maven dependency versions and configuration of the provided github with the solution