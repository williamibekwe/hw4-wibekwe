package edu.cmu.lti.f13.hw4.hw4_wibekwe.utils;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Answers.
 */
public class Answers {

	/** The scores. */
	public ArrayList<Triplet<Double, Integer, Integer>> scores =new ArrayList<Triplet<Double, Integer, Integer>>();
	
	/** The question. */
	public int question; 
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Answers clone(){
		Answers a = new Answers();
		a.question = question;
		a.scores = (ArrayList<Triplet<Double, Integer, Integer>>) scores.clone();
		return a;
		
	}
}
