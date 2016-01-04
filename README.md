# Jsonld-builder
Jsonld builder based on https://github.com/io-informatics/jackson-jsonld (patched for the graph part).
It has two modules:
1- The patch for the jackson-jsonld
2- An example to Serialize from Java an Jsonld @Graph which is compatible with the specs and the jsonld-java https://github.com/jsonld-java/jsonld-java.
The jsonld-java takes in jsonld (@graph) and generates an ontology.

To start it in a command line use: java -jar boc-jsonld-builder-0.0.1-jar-with-dependencies.jar

It will generate a jsonld file which is then be used to generate an rdf file with the jsonld-java API.
