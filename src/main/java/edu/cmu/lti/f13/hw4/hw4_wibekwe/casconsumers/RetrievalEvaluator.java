package edu.cmu.lti.f13.hw4.hw4_wibekwe.casconsumers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document;
import edu.cmu.lti.f13.hw4.hw4_wibekwe.utils.Answers;
import edu.cmu.lti.f13.hw4.hw4_wibekwe.utils.Triplet;

public class RetrievalEvaluator extends CasConsumer_ImplBase {

	/** query id number **/
	public ArrayList<Integer> qIdList;

	/** query and text relevant values **/
	public ArrayList<Integer> relList;
	
	/** list of all the documents **/
	public ArrayList<HashMap<String, Integer>> documents;

	/** list of all the the different types of words **/
	public ArrayList<String> globalDict;
	
	/** list of all the the different questions **/
	ArrayList<String> questionString; 
	
	/** list of all answer sentences **/
	ArrayList<String> answerString; 
	
	private static void BubbleSortOnLeft(
			ArrayList<Triplet<Double, Integer, Integer>> num) {
		for (int i = 0; i < num.size() - 1; i++)
			for (int x = 0; x < num.size() - 1; x++)
				if (num.get(x).getLeft() < num.get(x + 1).getLeft()) {
					Triplet temp = num.get(x);
					num.set(x, num.get(x + 1));
					num.set(x + 1, temp);
				}

	}

	public void initialize() throws ResourceInitializationException {
		qIdList = new ArrayList<Integer>();
		relList = new ArrayList<Integer>();
		documents = new ArrayList<HashMap<String, Integer>>();
		questionString =new ArrayList<String>(); 
		answerString =new ArrayList<String>(); 
	}

	/**
	 * 1. construct the global word dictionary 2. keep the word
	 * frequency for each sentence
	 */
	@Override
	public void processCas(CAS aCas) throws ResourceProcessException {
		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		FSIterator it = jcas.getAnnotationIndex(Document.type).iterator();

		if (it.hasNext()) {
			Document doc = (Document) it.next();
			// Make sure that your previous annotators have populated this in
			// CAS
			FSArray fsTokenList = doc.getTokenList();
			// ArrayList<Token>tokenList=Utils.fromFSListToCollection(fsTokenList,
			// Token.class);
			qIdList.add(doc.getQueryID());
			relList.add(doc.getRelevanceValue());
			if(doc.getRelevanceValue() == 99 ){
				questionString.add(doc.getText());
			}else {
				answerString.add(doc.getText());
			}
			HashMap<String, Integer> d = new HashMap<String, Integer>();
			for (int i = 0; i < doc.getTokenList().size(); i++) {
				d.put(doc.getTokenList(i).getText(), doc.getTokenList(i).getFrequency());
			}
			documents.add(d);
			HashMap<String, Integer> vectors = new HashMap<String, Integer>();
			FSArray tokenList = doc.getTokenList();
		}

	}

	/**
	 * 1. Compute Cosine Similarity, Jaccard Coefficient, Hamming Distance, Dice Coefficient and rank the retrieved sentences 
	 * 2. Compute the MRR metric
	 */
	@Override
	public void collectionProcessComplete(ProcessTrace arg0)
			throws ResourceProcessException, IOException {

		ArrayList<HashMap<String, Integer>> qList = new ArrayList<HashMap<String, Integer>>();
		ArrayList<HashMap<String, Integer>> aList = new ArrayList<HashMap<String, Integer>>();

		ArrayList<Integer> arel = new ArrayList<Integer>();

		ArrayList<Integer> questIDa = new ArrayList<Integer>();
		ArrayList<Integer> questID = new ArrayList<Integer>();
		ArrayList<Answers> csranking = new ArrayList<Answers>();
		ArrayList<Answers> jsranking = new ArrayList<Answers>();
		ArrayList<Answers> hdranking = new ArrayList<Answers>();		
		ArrayList<Answers> dcranking = new ArrayList<Answers>();

		

		super.collectionProcessComplete(arg0);
		Answers a = new Answers();
		for (int i = 0; i < qIdList.size(); i++) {
			if (relList.get(i) == 99) {
				a = new Answers();
				qList.add(documents.get(i));
				questID.add(qIdList.get(i));
				a.question = qIdList.get(i);
				csranking.add(a);
				jsranking.add(a.clone());
				hdranking.add(a.clone());
				dcranking.add(a.clone());
			} else {
				aList.add(documents.get(i));
				arel.add(relList.get(i));
				questIDa.add(qIdList.get(i));
			}
		}
		//compute the cosine similarity measure
		System.out.println("Cosine Similarity Measurement");
		System.out.println("**********************************************************");	

		for (int i = 0; i < qList.size(); i++) {
			for (int j = 0, count = 1; j < aList.size(); j++) {
				if (questID.get(i) == questIDa.get(j)) {
					Double score = computeCosineSimilarity(qList.get(i),aList.get(j));
					csranking.get(i).scores.add(new Triplet<Double, Integer, Integer>(score,count++, arel.get(j)));
				}
			}
		}
		ArrayList<Double> mmr = new ArrayList<Double>();
		// compute the rank of retrieved sentences
		for (int i = 0; i < csranking.size(); i++) {
			BubbleSortOnLeft(csranking.get(i).scores);
			for (int j = 0; j < csranking.get(i).scores.size(); j++) {
				if (csranking.get(i).scores.get(j).getRight() == 1) {
					mmr.add(1 / (double) (j + 1));
				}
				System.out.println("Score: "
					+ String.format("%-19s", csranking.get(i).scores.get(j)
							.getLeft()) + "  rank: " + (j + 1) + "  rel: "
					+ csranking.get(i).scores.get(j).getRight() + "  qid: "
					+ (i + 1) + "  sent"
					+ csranking.get(i).scores.get(j).getMiddle());
			}
		}

		// TODO :: compute the metric:: mean reciprocal rank
		double metric_mrr = compute_mrr(mmr);
		System.out.println("\n(MRR) Mean Reciprocal Rank: " + metric_mrr);
		System.out.println("\n\n");

		System.out.println("Jaccard Coefficient Measurement");	
		System.out.println("**********************************************************");	

	//  compute the cosine similarity measure
		for (int i = 0; i < qList.size(); i++) {
			for (int j = 0, count = 1; j < aList.size(); j++) {
				if (questID.get(i) == questIDa.get(j)) {
					Double score = computeJaccardCoefficient(qList.get(i),aList.get(j));
					jsranking.get(i).scores.add(new Triplet<Double, Integer, Integer>(score,count++, arel.get(j)));
			}
		}
	}
	 mmr = new ArrayList<Double>();
	// compute the rank of retrieved sentences
	for (int i = 0; i < jsranking.size(); i++) {
		BubbleSortOnLeft(jsranking.get(i).scores);
		for (int j = 0; j < jsranking.get(i).scores.size(); j++) {
			if (jsranking.get(i).scores.get(j).getRight() == 1) {
				mmr.add(1 / (double) (j + 1));
			}
			System.out.println("Score: "
					+ String.format("%-19s", jsranking.get(i).scores.get(j)
							.getLeft()) + "  rank: " + (j + 1) + "  rel: "
					+ jsranking.get(i).scores.get(j).getRight() + "  qid: "
					+ (i + 1) + "  sent"
					+ jsranking.get(i).scores.get(j).getMiddle());
		}
	}

	//compute the metric : mean reciprocal rank
	metric_mrr = compute_mrr(mmr);
	System.out.println("\n(MRR) Mean Reciprocal Rank: " + metric_mrr);
	System.out.println("\n\n");
	
	System.out.println("Dice Coefficient Measurement");	
	System.out.println("**********************************************************");	

	for (int i = 0; i < questionString.size(); i++) {
		for (int j = 0, count = 1; j < answerString.size(); j++) {
			if (questID.get(i) == questIDa.get(j)) {
				Double score = computeDiceCoefficient(questionString.get(i),answerString.get(j));
				dcranking.get(i).scores.add(new Triplet<Double, Integer, Integer>(score,count++, arel.get(j)));
			}
		}
	}
	 mmr = new ArrayList<Double>();
	// TODO :: compute the rank of retrieved sentences
	for (int i = 0; i < dcranking.size(); i++) {
		BubbleSortOnLeft(dcranking.get(i).scores);
		for (int j = 0; j < dcranking.get(i).scores.size(); j++) {
			if (dcranking.get(i).scores.get(j).getRight() == 1) {
				mmr.add(1 / (double) (j + 1));
			}
			System.out.println("Score: "
					+ String.format("%-19s", dcranking.get(i).scores.get(j)
							.getLeft()) + "  rank: " + (j + 1) + "  rel: "
					+ dcranking.get(i).scores.get(j).getRight() + "  qid: "
					+ (i + 1) + "  sent"
					+ dcranking.get(i).scores.get(j).getMiddle());
		}
	}

	//compute the metric : mean reciprocal rank
	metric_mrr = compute_mrr(mmr);
	System.out.println("\n(MRR) Mean Reciprocal Rank: " + metric_mrr);
	System.out.println("\n\n");
	
	
	System.out.println("Hamming Distance Measurement");	
	System.out.println("**********************************************************");	
	for (int i = 0; i < questionString.size(); i++) {
		for (int j = 0, count = 1; j < answerString.size(); j++) {
			if (questID.get(i) == questIDa.get(j)) {
				int score = computeHammingDistance(questionString.get(i),answerString.get(j));
				hdranking.get(i).scores.add(new Triplet<Double, Integer, Integer>((double)score,count++, arel.get(j)));
			}
		}
	}
	 mmr = new ArrayList<Double>();
	// TODO :: compute the rank of retrieved sentences
	for (int i = 0; i < hdranking.size(); i++) {
		BubbleSortOnLeft(hdranking.get(i).scores);
		for (int j = 0; j < hdranking.get(i).scores.size(); j++) {
			if (hdranking.get(i).scores.get(j).getRight() == 1) {
				mmr.add(1 / (double) (j + 1));
			}
			System.out.println("Score: "
					+ String.format("%-19s", hdranking.get(i).scores.get(j)
							.getLeft()) + "  rank: " + (j + 1) + "  rel: "
					+ hdranking.get(i).scores.get(j).getRight() + "  qid: "
					+ (i + 1) + "  sent"
					+ hdranking.get(i).scores.get(j).getMiddle());
		}
	}

	//compute the metric : mean reciprocal rank
	metric_mrr = compute_mrr(mmr);
	System.out.println("\n(MRR) Mean Reciprocal Rank: " + metric_mrr);	
}

	
	/**
	 * Cosine Similarity calculation between two sest of tokens
	 * @return cosine_similarity
	 */
	private double computeCosineSimilarity(Map<String, Integer> queryVector,Map<String, Integer> docVector) {
		double cosine_similarity = 0.0;
		// TODO :: compute cosine similarity between two sentences
		Set<String> both = new HashSet<String>(queryVector.keySet());
		both.retainAll(docVector.keySet());
		double sclar = 0, norm1 = 0, norm2 = 0;
		for (String k : both)
			sclar += queryVector.get(k) * docVector.get(k);
		for (String k : queryVector.keySet())
			norm1 += queryVector.get(k) * queryVector.get(k);
		for (String k : docVector.keySet())
			norm2 += docVector.get(k) * docVector.get(k);
		return sclar / Math.sqrt(norm1 * norm2);
	}

	
	
	/**
	 * Hamming Distance calculation between two sets of tokens
	 * @return HammingDistance
	 */
	public static int computeHammingDistance(String sequence1, String sequence2) {
	    char[] s1 = sequence1.toCharArray();
	    char[] s2 = sequence2.toCharArray();
	    int shorter = Math.min(s1.length, s2.length);
	    int longest = Math.max(s1.length, s2.length);
	    int result = 0;
	    for (int i=0; i<shorter; i++) {
	        if (s1[i] != s2[i]) 
	        	result++;
	    }
	    return result +  longest - shorter;
	}
	/**
	 * 
	 * helper function for hamming distance algorithm
	 * This take the to string sets, get the bi-grams, and puts them in into a Set class
	 * 
	 * @return 
	 */
	private Set<String> splitIntoBigrams(String s) {
        ArrayList<String> bigrams = new ArrayList<String>();
        if (s.length() < 2) {
        	bigrams.add(s);
        } else {
            for(int i = 1; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i-1));
                sb.append(s.charAt(i));
                bigrams.add(sb.toString());
            }
        }
        return new TreeSet<String>(bigrams);
	}
	
	
	
	/**
	 * Dice Coefficient calculation between two sets of tokens
	 * @return dice coefficient
	 */
	private double computeDiceCoefficient(String queryVector, String docVector) {
         // Create two sets of character bigrams, one for each string.
         Set<String> s1 = splitIntoBigrams(queryVector);
         Set<String> s2 = splitIntoBigrams(docVector);
         // Get the number of elements in each set.
         int n1 = s1.size();
         int n2 = s2.size();
         // Find the intersection, and get the number of elements in that set.
         s1.retainAll(s2);
         int nt = s1.size(); 
         return (2.0 * (double)nt) / ((double)(n1 + n2));      
     }

	
	
	/**
	 * Jaccard coefficient calculation between two sets of tokens
	 * @return Jaccard Coefficient
	 */
	private double computeJaccardCoefficient(Map<String, Integer> queryVector,Map<String, Integer> docVector) {
		HashSet<String> h1 = new HashSet<String>();
		HashSet<String> h2 = new HashSet<String>();
		for(String s : queryVector.keySet()){
			h1.add(s);
		}
		for(String s : docVector.keySet()){
			h2.add(s);
		}
		int sizeh1 = h1.size();
		// Retains all elements in h3 that are contained in h2 ie intersection
		h1.retainAll(h2);
		// h1 now contains the intersection of h1 and h2
		h2.removeAll(h1);
		// h2 now contains unique elements
		// Union
		int union = sizeh1 + h2.size();
		int intersection = h1.size();
		return (double) intersection / union;
	}

	
	/**
	 * Mean Reciprical Ranking
	 * @return mrr
	 */
	private double compute_mrr(ArrayList<Double> mrr) {
		double metric_mrr = 0.0;

		for (int i = 0; i < mrr.size(); i++) {
			metric_mrr += (double) mrr.get(i);
		}
		metric_mrr = metric_mrr / mrr.size();
		return metric_mrr;
	}

}
