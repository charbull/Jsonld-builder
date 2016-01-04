# Jsonld-builder
Jsonld builder based on https://github.com/io-informatics/jackson-jsonld (patched for the graph part).
It has two modules:
1- The patch for the jackson-jsonld
2- An example to Serialize from Java an Jsonld @Graph which is compatible with the specs and the jsonld-java https://github.com/jsonld-java/jsonld-java.
The jsonld-java takes in jsonld (@graph) and generates an ontology.

To start it in a command line use: java -jar boc-jsonld-builder-0.0.1-jar-with-dependencies.jar

It will generate a jsonld file which is then be used to generate an rdf file with the jsonld-java API.
{
	"@context": {
		"owl": {
			"@id": "http://www.w3.org/2002/07/owl#",
			"@type": "@id"
		},
		"rdf": {
			"@id": "http://www.w3.org/1999/02/22-rdf-syntax-ns#",
			"@type": "@id"
		},
		"rdfs": {
			"@id": "http://www.w3.org/2000/01/rdf-schema#",
			"@type": "@id"
		},
		"xsd": {
			"@id": "http://www.w3.org/2001/XMLSchema#",
			"@type": "@id"
		},
		"prot": {
			"@id": "http://www.schneider-electric.com/global/Protocols#",
			"@type": "@id"
		},
		"boc": {
			"@id": "http://www.schneider-electric.com/Clients/BoC#",
			"@type": "@id"
		},
		"hasName": "qt:hasName",
		"hasLocation_Building": "loc:hasLocation_Building",
		"loc": {
			"@id": "http://www.schneider-electric.com/global/CoreSE_Location#",
			"@type": "@id"
		},
		"hasLocation_Room": "loc:hasLocation_Room",
		"hasLocation_Floor": "loc:hasLocation_Floor",
		"qt": {
			"@id": "http://www.schneider-electric.com/global/CoreSE_Quantity#",
			"@type": "@id"
		},
		"buildingBU": {
			"@id": "http://www.schneider-electric.com/builidings/BDevices#",
			"@type": "@id"
		},
		"ews": {
			"@id": "http://www.schneider-electric.com/global/EWS#",
			"@type": "@id"
		}
	},
	"@graph": [{
		"@type": "owl:ontology",
		"@id": "http://www.schneider-electric.com/Clients/BoC#",
		"owl:imports": [{
			"@id": "http://www.schneider-electric.com/global/CoreSE_Location#"
		},
		{
			"@id": "http://www.schneider-electric.com/builidings/BDevices#"
		},
		{
			"@id": "http://www.schneider-electric.com/global/CoreSE_Quantity#"
		},
		{
			"@id": "http://www.schneider-electric.com/global/EWS#"
		},
		{
			"@id": "http://www.schneider-electric.com/global/Protocols#"
		}],
		"owl:versionIRI": {
			"@id": "http://www.schneider-electric.com/Clients/BoC/0.0.1"
		}
	},
	{
		"@type": "loc:Site",
		"hasName": "Boston One Campus",
		"hasLocation_Building": {
			"@id": "boc:BuildingA"
		},
		"@id": "boc:BOC"
	},
	{
		"@type": "loc:Building",
		"hasName": "Building A (North)",
		"hasLocation_Floor": [{
			"@id": "boc:F1"
		},
		{
			"@id": "boc:F2"
		},
		{
			"@id": "boc:F3"
		}],
		"@id": "boc:BuildingA"
	},
	{
		"@type": "loc:Floor",
		"hasName": "Floor 1",
		"hasLocation_Room": [{
			"@id": "boc:R123"
		},
		{
			"@id": "boc:R456"
		}],
		"@id": "boc:F1"
	},
	{
		"@type": "loc:Floor",
		"hasName": "Floor 2",
		"@id": "boc:F2"
	},
	{
		"@type": "loc:Floor",
		"hasName": "Floor 3",
		"@id": "boc:F3"
	},
	{
		"@type": "loc:Room",
		"hasName": "Room 123",
		"@id": "boc:R123"
	},
	{
		"@type": "loc:Room",
		"hasName": "Room 456",
		"@id": "boc:R456"
	},
	{
		"hasName": "HP-1_1.18",
		"@type": "buildingBU:B3866",
		"@id": "boc:HP-1_1.18",
		"qt:controls": [{
			"@id": "boc:HP_1_1"
		}],
		"qt:hasTimeSeries": [{
			"@id": "boc:6549-fsdf-fsdfs13"
		}],
		"qt:hasPhysicalLocation": [{
			"@id": "boc:R123"
		}],
		"qt:hasMonitoringLocation": [{
			"@id": "boc:R456"
		}],
		"prot:hasCommunicationMedium": [{
			"@id": "prot:MSTP"
		}]
	},
	{
		"hasName": "HeatPump of HP-1_1.18",
		"@type": "buildingBU:HeatPump",
		"@id": "boc:HP_1_1"
	},
	{
		"hasName": "EServer",
		"@type": "buildingBU:EnterpriseServer",
		"@id": "boc:server_1",
		"qt:connectsTo": [{
			"@id": "boc:AS_1A1"
		}]
	},
	{
		"hasName": "Automation Server of 1A1",
		"@type": "buildingBU:AutomationServer",
		"@id": "boc:AS_1A1",
		"qt:monitors": [{
			"@id": "boc:HP-1_1.18"
		}]
	},
	{
		"@type": "qt:TimeSeries",
		"@id": "boc:6549-fsdf-fsdfs13",
		"qt:hasType": {
			"@id": "ews:Temperature"
		},
		"qt:hasUnit": {
			"@id": "qt:°F"
		}
	}]
}
