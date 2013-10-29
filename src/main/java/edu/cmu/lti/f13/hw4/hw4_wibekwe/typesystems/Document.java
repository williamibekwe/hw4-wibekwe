

/* First created by JCasGen Fri Oct 11 01:58:03 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


// TODO: Auto-generated Javadoc
/** 
 * Updated by JCasGen Mon Oct 28 00:27:23 EDT 2013
 * XML source: /Users/willibeamin/Documents/workspace/hw4-wibekwe/src/main/resources/descriptors/typesystems/VectorSpaceTypes.xml
 * @generated */
public class Document extends Annotation {
  
  /** The Constant typeIndexID. @generated @ordered */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Document.class);
  
  /** The Constant type. @generated @ordered */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  
  /**
   * Gets the type index id.
   *
   * @return the type index id
   * @generated
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Document() {/* intentionally empty block */}
    
  /**
   * Internal - constructor used by generator.
   *
   * @param addr the addr
   * @param type the type
   * @generated
   */
  public Document(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /**
   * Instantiates a new document.
   *
   * @param jcas the jcas
   * @generated
   */
  public Document(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /**
   * Instantiates a new document.
   *
   * @param jcas the jcas
   * @param begin the begin
   * @param end the end
   * @generated
   */  
  public Document(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /**
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->.
   *
   * @generated modifiable
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: relevanceValue

  /**
   * getter for relevanceValue - gets.
   *
   * @return the relevance value
   * @generated
   */
  public int getRelevanceValue() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_relevanceValue == null)
      jcasType.jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Document_Type)jcasType).casFeatCode_relevanceValue);}
    
  /**
   * setter for relevanceValue - sets.
   *
   * @param v the new relevance value
   * @generated
   */
  public void setRelevanceValue(int v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_relevanceValue == null)
      jcasType.jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.ll_cas.ll_setIntValue(addr, ((Document_Type)jcasType).casFeatCode_relevanceValue, v);}    
   
    
  //*--------------*
  //* Feature: queryID

  /**
   * getter for queryID - gets.
   *
   * @return the query id
   * @generated
   */
  public int getQueryID() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_queryID == null)
      jcasType.jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Document_Type)jcasType).casFeatCode_queryID);}
    
  /**
   * setter for queryID - sets.
   *
   * @param v the new query id
   * @generated
   */
  public void setQueryID(int v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_queryID == null)
      jcasType.jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.ll_cas.ll_setIntValue(addr, ((Document_Type)jcasType).casFeatCode_queryID, v);}    
   
    
  //*--------------*
  //* Feature: text

  /**
   * getter for text - gets.
   *
   * @return the text
   * @generated
   */
  public String getText() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Document_Type)jcasType).casFeatCode_text);}
    
  /**
   * setter for text - sets.
   *
   * @param v the new text
   * @generated
   */
  public void setText(String v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.ll_cas.ll_setStringValue(addr, ((Document_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: TokenList

  /**
   * getter for TokenList - gets.
   *
   * @return the token list
   * @generated
   */
  public FSArray getTokenList() {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_TokenList == null)
      jcasType.jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList)));}
    
  /**
   * setter for TokenList - sets.
   *
   * @param v the new token list
   * @generated
   */
  public void setTokenList(FSArray v) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_TokenList == null)
      jcasType.jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.ll_cas.ll_setRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /**
   * indexed getter for TokenList - gets an indexed value -.
   *
   * @param i the i
   * @return the token list
   * @generated
   */
  public Token getTokenList(int i) {
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_TokenList == null)
      jcasType.jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList), i)));}

  /**
   * indexed setter for TokenList - sets an indexed value -.
   *
   * @param i the i
   * @param v the v
   * @generated
   */
  public void setTokenList(int i, Token v) { 
    if (Document_Type.featOkTst && ((Document_Type)jcasType).casFeat_TokenList == null)
      jcasType.jcas.throwFeatMissing("TokenList", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Document");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Document_Type)jcasType).casFeatCode_TokenList), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    