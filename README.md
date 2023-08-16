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

# Troubleshooting

## Issue 1
```
Error [ERR_PACKAGE_PATH_NOT_EXPORTED]: Package subpath './lib/tokenize' is not defined by "exports" in package.json
```

Fix:
Potentially due to building with one node version and running with another. 

## Issue 2
```
sh: react-scripts: command not found
```

Fix: npm install





