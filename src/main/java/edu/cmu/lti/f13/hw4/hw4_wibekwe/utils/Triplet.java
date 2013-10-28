package edu.cmu.lti.f13.hw4.hw4_wibekwe.utils;

import java.util.ArrayList;

/**
 * @author willibeamin
 * This class  in that will allow three different generic variables. 
 * Think of this as an extension of Pairs
 * @param <L>
 * @param <M>
 * @param <R>
 * 
 */
public class Triplet<L,M,R> {

	  private final L left;
	  private final R right;
	  private final M middle;
	  

	  public Triplet(L left, M middle, R right) {
	    this.left = left;
	    this.right = right;
	    this.middle = middle; 
	  }

	  public L getLeft() { return left; }
	  public R getRight() { return right; }
	  public M getMiddle() { return middle; }

	  @Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode() ^ middle.hashCode(); }

	  @Override
	  public boolean equals(Object o) {
	    if (o == null) return false;
	    if (!(o instanceof Triplet)) return false;
	    Triplet pairo = (Triplet) o;
	    return this.left.equals(pairo.getLeft()) &&
	           this.right.equals(pairo.getRight())&& this.middle.equals(pairo.getMiddle());
	  }
	}