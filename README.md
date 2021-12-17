# kafka-streams-functional-programming-demo

a sample app to show how to use kafka streams with spring boot using functional programming


# How does this work?

* somehow a message is sent to `source-topic` (you can use `curl http://localhost:8080/api/send` or set `send.dummy-message` to `true` in config files)
* the `processMessage` method will get to work.. once its done, it sends the message to `processed-topic`
* the `sendNotificationMessage` method will get to work.. once its done, it sends the same message to `sink-topic`
* and we are done...


This flow can be made as complicated as needed but the gist is the same. 

carefully look at the configs in application.yml (the names of function bundings should match with method names in function beans)
