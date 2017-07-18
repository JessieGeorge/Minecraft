package jes.corenlp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.google.common.io.Files;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleExample {

	public static void main(String[] args)throws IOException
	{
		/* NOTE:
		 * Code commented for json has errors. 
		 * Working code for text file is below.
		JSONParser parser = new JSONParser();
		
		try {

            Object obj = parser.parse(new FileReader("out_servers.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
            // loop array
            JSONArray signs = (JSONArray) jsonObject.get("signs");
            Iterator<String> iterator = signs.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		*/
	
		File inputFile = new File("gamerules.txt");
		String text = Files.toString(inputFile, Charset.forName("UTF-8"));
		
		Properties props = new Properties();
	    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    Annotation document = new Annotation(text);
	    pipeline.annotate(document);
	    
	    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
	    String word, pos, ne;
	    for(CoreMap sentence: sentences)
	    {
	    	//each word in the sentence
	    	for(CoreLabel token: sentence.get(TokensAnnotation.class))
	    	{
	    		word = token.get(TextAnnotation.class);
	    		pos = token.get(PartOfSpeechAnnotation.class);
	    		ne = token.get(NamedEntityTagAnnotation.class);
	    		System.out.println("word: " + word + " pos: " + pos + " ne:" + ne);	
	    		
	    	}
	    	
	    	Tree tree = sentence.get(TreeAnnotation.class);
		    System.out.println("parse tree:\n" + tree);
		    
		    SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
		    System.out.println("dependency graph:\n" + dependencies);
		    
	    }
	    
	    Map<Integer,CorefChain> graph = document.get(CorefChainAnnotation.class);
	    
	    
	}
}
