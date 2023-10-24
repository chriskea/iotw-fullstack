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
6. To build and run locally
   1. In intellij terminal `mvn jib:build -Djib.to.image={**dockerhub_user**}/spring-react-fullstack:v1`
   2. `docker pull {**dockerhub_user***}/spring-react-fullstack:v1`
   2. `docker run -p 3000:8080 {**dockerhub_user***}/spring-react-fullstack:v1`
9. To build and push image to dockerhub
   1. `mvn clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=1
      ` (tip: use cmd + enter after typing to run the command in intellij if you get an **invalid target release** error)


# AWS

## Elastic beanstalk

Contains an Application and an environment. *Note Elastic Beanstalk will create a public IP for your instance*

### Application
1. Elastic Beanstalk > Create Application
 - Name (something sensible)

### Environment
All defaults unless specified

1. Webserver enviromnent
2. Platform Type: Managed platform
3. Platform: Docker
4. Docker running on 64bit Amazon Linux 2023
5. Application code: Sample application (just while testing environment works)
6. Single instance (free tier eligible)

Service access:
1. Service role
- *This dropdown displays ALL IAM roles*
- Choose 'Create and use new service role'

2. EC2 instance profile
- *This dropdown displays IAM roles that have AWSElasticBeanstalkWebTier policy*, to create a new one
- IAM > Roles > Create Role
- AWS Service type
- EC2 service use case
- Add Permissions (policies): AWSElasticBeanstalkMulticontainerDocker and AWSElasticBeanstalkWebTier

3. Networking
(or whatever relevant to your AWS account)
- VPC: vpc-0c37a...
- Subnet: us-west-1c (0c0ee...)

4. Traffic and scaling
(or whatever relevant to your AWS account)
- Security groups: sg-0043..., sg-0064, sg-0cab...
- Autoscaling group: leave as 1 for now

5. Monitorting
- Enhanced

# Robot Framework Automation
We have decided to develope our automation suite in robot framework.

Robot Framework is a generic open source automation framework. It can be used for test automation and robotic process automation (RPA).

*It is required to have a running docker instance of the iotw app in order to run your tests.*

*It is suggested to write your robot tests using robot framework as the intellij language server plugin seems to be a tad janky with environment variables but it can be done with intellij if desired.*

## Setup
1. Install Python
```
brew install python
```
2. Navigate to root directory of repo, create your python venv and source it
```
python3 -m venv iotw-fullstack-venv

source ivm-robot-automation/iotw-fullstack-venv/bin/activate
```
3. Install dependancies
```
python3 -m pip install -r requirements.txt
```
4. Open your iotw-fullstack project in VScode and `cmd+shift+p` and enter "Python Interpreter" to select your python interpreter
5. Install the Robot Framework Language Server plugin
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





