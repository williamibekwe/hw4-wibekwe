

/* First created by JCasGen Fri Oct 11 01:58:03 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


// TODO: Auto-generated Javadoc
/** 
 * Updated by JCasGen Mon Oct 28 00:27:23 EDT 2013
 * XML source: /Users/willibeamin/Documents/workspace/hw4-wibekwe/src/main/resources/descriptors/typesystems/VectorSpaceTypes.xml
 * @generated */
public class Token extends Annotation {
  
  /** The Constant typeIndexID. @generated @ordered */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
  
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
  protected Token() {/* intentionally empty block */}
    
  /**
   * Internal - constructor used by generator.
   *
   * @param addr the addr
   * @param type the type
   * @generated
   */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /**
   * Instantiates a new token.
   *
   * @param jcas the jcas
   * @generated
   */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /**
   * Instantiates a new token.
   *
   * @param jcas the jcas
   * @param begin the begin
   * @param end the end
   * @generated
   */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: text

  /**
   * getter for text - gets.
   *
   * @return the text
   * @generated
   */
  public String getText() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_text);}
    
  /**
   * setter for text - sets.
   *
   * @param v the new text
   * @generated
   */
  public void setText(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: frequency

  /**
   * getter for frequency - gets.
   *
   * @return the frequency
   * @generated
   */
  public int getFrequency() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_frequency == null)
      jcasType.jcas.throwFeatMissing("frequency", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Token");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Token_Type)jcasType).casFeatCode_frequency);}
    
  /**
   * setter for frequency - sets.
   *
   * @param v the new frequency
   * @generated
   */
  public void setFrequency(int v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_frequency == null)
      jcasType.jcas.throwFeatMissing("frequency", "edu.cmu.lti.f13.hw4.hw4_wibekwe.typesystems.Token");
    jcasType.ll_cas.ll_setIntValue(addr, ((Token_Type)jcasType).casFeatCode_frequency, v);}    
  }

    