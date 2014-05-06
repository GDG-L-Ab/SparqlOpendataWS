package org.gdgrome.sparql.ws.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.gdgrome.sparql.ws.server.SparqlQueryStub;
import org.gdgrome.sparql.ws.server.SparqlQueryStub.SparqlQueryService;

import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

public class TestSparqlQuery {

	public static void main(String[] args) {
		//AxisFault Exception
		SparqlQueryStub stub = null;
		String queryServiceString = "";
		try {
			//get stub
			stub = new SparqlQueryStub();
		} catch (AxisFault e) {			
			e.printStackTrace();
		}
		SparqlQueryService service = new SparqlQueryService();		
		//RemoteException
		try {
			//get service return string
			queryServiceString = stub.sparqlQueryService(service).get_return();
			System.out.println("queryServiceString = " + queryServiceString);
			//create jena query
			Query query = QueryFactory.create(queryServiceString);
			//set ARQ context to true using the SAX parser for XML result sets
			ARQ.getContext().setTrue(ARQ.useSAX);
			//Executing SPARQL Query and pointing to the DBpedia SPARQL Endpoint (sparql service) 
			QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
			//get resultset
			ResultSet rs = qexec.execSelect();
			//resultset formatter JSON
			//ResultSetFormatter.outputAsJSON(rs);
			//resultset formatter CSV
			ResultSetFormatter.outputAsCSV(rs);
			//resultset formatter RDF
			//ResultSetFormatter.outputAsRDF("", rs);
			
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
				

	}

}
