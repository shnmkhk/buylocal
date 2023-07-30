echo [INFO] Building and loading the database to the configured database in [DEV] profile
./mvnw compile flyway:clean flyway:migrate -Pdev
