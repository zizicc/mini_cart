## Setup MySQL Docker Desktop
* Install docker
## Using command
* Run command: `$ docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql`
## Using compose file
* Create a `docker-compose.yml` file in your directory.

```yaml
version: '3.1'

services:
  db:
    image: mysql:latest
    container_name: mysql-compose-container
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: mydatabase
      MYSQL_USER: myuser
      MYSQL_PASSWORD: mypassword
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```
* Under the directory, run command: `docker-compose up -d`
