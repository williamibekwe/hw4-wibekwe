package edu.cmu.lti.f13.hw4.hw4_wibekwe.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Answers {

	public ArrayList<Triplet<Double, Integer, Integer>> scores =new ArrayList<Triplet<Double, Integer, Integer>>();
	public int question; 
	
	public Answers clone(){
		Answers a = new Answers();
		a.question = question;
		a.scores = (ArrayList<Triplet<Double, Integer, Integer>>) scores.clone();
		return a;
		
	}
}
