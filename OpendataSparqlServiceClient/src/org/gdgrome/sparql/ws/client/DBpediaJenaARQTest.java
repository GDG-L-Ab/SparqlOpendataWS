package org.gdgrome.sparql.ws.client;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;

/**
 * This is an example built on top of the Jena ARQ library.
 * See: http://jena.sourceforge.net/ARQ/documentation.html
 */
public class DBpediaJenaARQTest {

	private String service = null;

	public DBpediaJenaARQTest(String service) {
		this.service = service;
	}
	public ResultSet executeQuery(String queryString) throws Exception {
		 Query query = QueryFactory.create(queryString) ;

		 QueryEngineHTTP qexec = QueryExecutionFactory.createServiceRequest(this.service, query);
		 ResultSet results = qexec.execSelect() ;
		 return results;

	}
	public static void main(String[] args) throws Exception {
		String sparqlService = "http://dbpedia.org/sparql";

		String query = 
				"SELECT ?resource ?value " +  
				"WHERE { " +  
					"?resource a <http://dbpedia.org/class/yago/CitiesAndTownsInAbruzzo> . " +  
					"?resource <http://dbpedia.org/property/populationTotal> ?value . " +  
					"FILTER (?value > 50000) " + 
					"} " + 
					"ORDER BY ?resource ?value";

		DBpediaJenaARQTest test = new DBpediaJenaARQTest(sparqlService);
		ResultSet results = test.executeQuery(query);
		    for ( ; results.hasNext() ; ) {
		      QuerySolution soln = results.nextSolution() ;
		      RDFNode res = soln.get("resource") ;
		      Literal val = soln.getLiteral("value");		      
		      System.out.println(res + " ---- " + val);
		    }
	}
}
