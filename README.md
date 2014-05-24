SparqlOpendataWS
================

SPARQL queries on the service endpoints open data


Comments & Feedback
================

camelia.boban @ gmail.com

Resources:

jdk1.8.0

eclipse Luna IDE for J2EE developers

Apache Tomcat 8.0.5

Axis2 1.6.2

Apache Jena 2.11.1

  httpclient-4.2.3.jar
	httpcore-4.2.2.jar
	Jena-arq-2.11.1.jar
	Jena-core-2.11.1.jar
	Jena-iri-1.0.1.jar
	jena-sdb-1.4.1.jar
	jena-tdb-1.0.1.jar
	slf4j-api-1.6.4.jar
	slf4j-log4j12-1.6.4.jar
	xercesImpl-2.11.0.jar
	xml-apis-1.4.01.jar
		ATTENTION!! NO THIS JARS: jcl-over-slf4j-1.6.4.jar (slf4j-log4j12-1.6.4 conflict, “Can’t override final class exception”) 
		    & httpcore-4.0.jar (made by Axis, httpcore-4.2.2.jar conflict, don’t let create the WS)
