How to run...

# Pre-req
1. Java 11 installed
2. Node v16.4.0
3. Npm 8.7.0

Tip: Use nvm to install and select specific versions of node https://asibin99.medium.com/how-to-use-node-version-manager-nvm-on-ubuntu-20-04-fa71c9929f51

## Cheatsheet
```
nvm ls // list installed versions
nvm ls-remote // list installable version

nvm install v16.4.0

nvm use v16.4.0
```

# Setup
1. git clone git@github.com:chriskea/iotw-fullstack.git

## Backend
1. Intellij > New > Project From Existing Sources > iotw-fullstack pom.xml

When the project is imported it should automatically create a Run configuration for the Spring boot server. Our spring boot server should start and we should be able to hit http://localhost:8080/api/v1/students

## Frontend
We should also create a Run configuration for the node app (in frontend)

1. cd iotw-fullstack/src/frontend
2. npm install
3. npm run build
4. In Intellij > Edit Configurations > + > npm
- Name: Frontend
- package.json: frontend/package.json
- Command: start
- Node and NPM versions should automatically be selected (but if they are not select the correct versions)

## Running backend and frontend from Tomcat together
Once the frontend is compiled and copied into the jar both apps are served from tomcat. We can start the application by running the compiled jar

```
java -jar demo-0.0.1-SNAPSHOT.jar
```

# Jib + Docker
1. `mvn jib:dockerBuild -Djib.to.image=fullstack:v1`
2. `docker run --name fullstack -p 3000:8080 fullstack:v1`
3. stop and delete container
4. Create dockerhub account
5. Login on docker desktop or with `docker login` in terminal
6. In intellij terminal `mvn jib:build -Djib.to.image={**dockerhub_user**}/spring-react-fullstack:v1`
7. `docker pull {**dockerhub_user***}/spring-react-fullstack:v1`
8. `docker run -p 3000:8080 {**dockerhub_user***}/spring-react-fullstack:v1`

# Troubleshooting

## Issue 1
```
Error [ERR_PACKAGE_PATH_NOT_EXPORTED]: Package subpath './lib/tokenize' is not defined by "exports" in package.json
```

Fix: Something to do with having multiple versions of node/npm installed. Try restarting the terminal and running npm run build or npm start. If that does not work, delete the package.lock.json/node_modules then run npm install again.

## Issue 2
```
sh: react-scripts: command not found
```

Fix: npm install





