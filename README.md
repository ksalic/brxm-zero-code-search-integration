Build and Run the CMS

Build and Run the Search Service microservice (spring boot app)

Go to site and search in the searchbox

Monitor elastic search index during publish and depublish: http://localhost:9200/content/document/_search

For the Active MQ queue to work you will need to be at the office (ipaddress based AWS service)

You can also setup a local activeMQ server, just make sure to enable AMQP protocol and have the correct credentials in /conf/search-integration.properties