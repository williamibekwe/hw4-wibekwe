package edu.cmu.lti.f13.hw4.hw4_wibekwe.annotators;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.f13.hw4.hw4_wibekwe.utils.StopWords;
import edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document;
import edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Token;


public class DocumentVectorAnnotator extends JCasAnnotator_ImplBase {

        @Override
        public void process(JCas jcas) throws AnalysisEngineProcessException {

                FSIterator<Annotation> iter = jcas.getAnnotationIndex().iterator();
                if (iter.isValid()) {
                        iter.moveToNext();
                        Document doc = (Document) iter.get();
                        try {
                                createTermFreqVector(jcas, doc);
                        } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }
        /**
         * 
         * @param jcas
         * @param doc
         * @throws FileNotFoundException 
         */
        

        private void createTermFreqVector(JCas jcas, Document doc) throws FileNotFoundException {
                //TO DO: construct a vector of tokens and update the tokenList in CASException
                
                String txt = doc.getText().toLowerCase();
                txt = StopWords.removeStopWords(txt);
                String[] tl = txt.split(" ");
                
        
                HashMap<String, Integer> vectors =new HashMap<String, Integer>(); 
                for(int i = 0; i < tl.length; i++ ){
                        if( vectors.containsKey(tl[i])){
                                int freq = vectors.get(tl[i].trim());
                                vectors.remove(tl[i].trim()); 
                                vectors.put(tl[i].trim(), freq + 1 ); 
                        }else{ 
                                vectors.put(tl[i].trim(), 1 ); 
                        }
                }
                FSArray tokenList =new FSArray(jcas, vectors.size());

                int i = 0;
                for (String key: vectors.keySet()) {
                        Token t = new Token(jcas);
                        t.setText(key);
                        t.setFrequency(vectors.get(key));
                        tokenList.set(i++, t);
                }
                doc.setTokenList(tokenList);
                //System.out.println(rel + " " + qid + " " + txt );
                
                

        }

}