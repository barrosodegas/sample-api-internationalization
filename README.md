# Internationalization of messages in an API example
- This is one of the ways to generate internationalized messages in APIs. It can be used to generate success or error messages.

## Environment
- Have Java 8 installed and setup as your default JVM
- API Client Port: 8003

## Running the example
- Compile: Directory: sample-api-internationalization/ --> Comand: mvn clean package -U -T 2
- Run: java -jar sample-api-internationalization/target/sample-api-internationalization-0.0.1-SNAPSHOT.jar
- Access port to the endpoint that get message: 8003
- To find message: GET --> http://localhost:8003/messages?messageName=hello
- To find ES message by Linux curl: curl -X -H "Accept-Language: es" 'http://localhost:8003/messages?messageName=hello'
- To find EN message by Linux curl: curl -X -H "Accept-Language: en" 'http://localhost:8003/messages?messageName=hello'
- To find PT_BR message by Linux curl: curl -X -H "Accept-Language: pt_BR" 'http://localhost:8003/messages?messageName=hello'

