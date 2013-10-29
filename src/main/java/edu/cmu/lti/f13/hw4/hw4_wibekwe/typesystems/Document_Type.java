
/* First created by JCasGen Fri Oct 11 01:58:03 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

// TODO: Auto-generated Javadoc
/**
 * Updated by JCasGen Mon Oct 28 00:27:23 EDT 2013.
 *
 * @generated
 */
public class Document_Type extends Annotation_Type {
  
  /**
   * Gets the fS generator.
   *
   * @return the fS generator
   * @generated
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  
  /** The fs generator. @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Document_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Document_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Document(addr, Document_Type.this);
  			   Document_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Document(addr, Document_Type.this);
  	  }
    };
  
  /** The Constant typeIndexID. @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Document.typeIndexID;
  
  /** The Constant featOkTst. @generated @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
 
  /** The cas feat_relevance value. @generated */
  final Feature casFeat_relevanceValue;
  
  /** The cas feat code_relevance value. @generated */
  final int     casFeatCode_relevanceValue;
  
  /**
   * Gets the relevance value.
   *
   * @param addr the addr
   * @return the relevance value
   * @generated
   */ 
  public int getRelevanceValue(int addr) {
        if (featOkTst && casFeat_relevanceValue == null)
      jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return ll_cas.ll_getIntValue(addr, casFeatCode_relevanceValue);
  }
  
  /**
   * Sets the relevance value.
   *
   * @param addr the addr
   * @param v the v
   * @generated
   */    
  public void setRelevanceValue(int addr, int v) {
        if (featOkTst && casFeat_relevanceValue == null)
      jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    ll_cas.ll_setIntValue(addr, casFeatCode_relevanceValue, v);}
    
  
 
  /** The cas feat_query id. @generated */
  final Feature casFeat_queryID;
  
  /** The cas feat code_query id. @generated */
  final int     casFeatCode_queryID;
  
  /**
   * Gets the query id.
   *
   * @param addr the addr
   * @return the query id
   * @generated
   */ 
  public int getQueryID(int addr) {
        if (featOkTst && casFeat_queryID == null)
      jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return ll_cas.ll_getIntValue(addr, casFeatCode_queryID);
  }
  
  /**
   * Sets the query id.
   *
   * @param addr the addr
   * @param v the v
   * @generated
   */    
  public void setQueryID(int addr, int v) {
        if (featOkTst && casFeat_queryID == null)
      jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    ll_cas.ll_setIntValue(addr, casFeatCode_queryID, v);}
    
  
 
  /** The cas feat_text. @generated */
  final Feature casFeat_text;
  
  /** The cas feat code_text. @generated */
  final int     casFeatCode_text;
  
  /**
   * Gets the text.
   *
   * @param addr the addr
   * @return the text
   * @generated
   */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  
  /**
   * Sets the text.
   *
   * @param addr the addr
   * @param v the v
   * @generated
   */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** The cas feat_ token list. @generated */
  final Feature casFeat_TokenList;
  
  /** The cas feat code_ token list. @generated */
  final int     casFeatCode_TokenList;
  
  /**
   * Gets the token list.
   *
   * @param addr the addr
   * @return the token list
   * @generated
   */ 
  public int getTokenList(int addr) {
        if (featOkTst && casFeat_TokenList == null)
      jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return ll_cas.ll_getRefValue(addr, casFeatCode_TokenList);
  }
  
  /**
   * Sets the token list.
   *
   * @param addr the addr
   * @param v the v
   * @generated
   */    
  public void setTokenList(int addr, int v) {
        if (featOkTst && casFeat_TokenList == null)
      jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    ll_cas.ll_setRefValue(addr, casFeatCode_TokenList, v);}
    
   /**
    * Gets the token list.
    *
    * @param addr the addr
    * @param i the i
    * @return the token list
    * @generated
    */
  public int getTokenList(int addr, int i) {
        if (featOkTst && casFeat_TokenList == null)
      jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i);
  }
   
  /**
   * Sets the token list.
   *
   * @param addr the addr
   * @param i the i
   * @param v the v
   * @generated
   */ 
  public void setTokenList(int addr, int i, int v) {
        if (featOkTst && casFeat_TokenList == null)
      jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_TokenList), i, v);
  }
 



  /**
   * initialize variables to correspond with Cas Type and Features.
   *
   * @param jcas the jcas
   * @param casType the cas type
   * @generated
   */
  public Document_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_relevanceValue = jcas.getRequiredFeatureDE(casType, "relevanceValue", "uima.cas.Integer", featOkTst);
    casFeatCode_relevanceValue  = (null == casFeat_relevanceValue) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relevanceValue).getCode();

 
    casFeat_queryID = jcas.getRequiredFeatureDE(casType, "queryID", "uima.cas.Integer", featOkTst);
    casFeatCode_queryID  = (null == casFeat_queryID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_queryID).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_TokenList = jcas.getRequiredFeatureDE(casType, "TokenList", "uima.cas.FSArray", featOkTst);
    casFeatCode_TokenList  = (null == casFeat_TokenList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TokenList).getCode();

  }
}



    