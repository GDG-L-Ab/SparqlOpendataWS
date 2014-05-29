package org.gdgrome.sparql.ws.server;

public class SparqlQuery {
	public String sparqlQueryService() throws IOException {
		//I want all the cities on the Wikipedia(EN) Category CitiesAndTownsInAbruzzo
		//where the property populationTotal > 50.000
		//order by city ASC
		/*String sparqlQueryString = 
			"PREFIX class: <http://dbpedia.org/class/yago/CitiesAndTownsInAbruzzo> " +
			"PREFIX property: <http://dbpedia.org/property/populationTotal> " +
			"SELECT ?resource ?value " + 
				" WHERE { " + 
				" ?resource a <http://dbpedia.org/class/yago/CitiesAndTownsInAbruzzo> . " + 
				" ?resource <http://dbpedia.org/property/populationTotal> ?value . " + 
				" FILTER (?value > 50000) " + 
				" } " + 
				" ORDER BY ?resource ?value";*/
		
		//init reader
		BufferedReader reader = null;
		String line = null;	
		String sparqlQuery = null;
		try {
			//read file
			File file = new File("C://readSparqlQuery.txt");
			reader = new BufferedReader(new FileReader(file));
			//defining SPARQL Query				
			//read line
			while((line = reader.readLine()) != null){	
				if(sparqlQuery == null){
					sparqlQuery = line;
				}
				else{
					sparqlQuery += line;
					//System.out.println("server, sparqlQuery -------- " + sparqlQuery);
				}
			}
			//System.out.println("server, sparqlQuery -------- " + sparqlQuery);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		return sparqlQuery;
	}
}
