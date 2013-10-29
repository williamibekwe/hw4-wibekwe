package edu.cmu.lti.f13.hw4.hw4_wibekwe.utils;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Triplet.
 *
 * @param <L> the generic type
 * @param <M> the generic type
 * @param <R> the generic type
 * @author willibeamin
 * This class  in that will allow three different generic variables.
 * Think of this as an extension of Pairs
 */
public class Triplet<L,M,R> {

	  /** The left. */
  	private final L left;
	  
  	/** The right. */
  	private final R right;
	  
  	/** The middle. */
  	private final M middle;
	  

	  /**
  	 * Instantiates a new triplet.
  	 *
  	 * @param left the left
  	 * @param middle the middle
  	 * @param right the right
  	 */
  	public Triplet(L left, M middle, R right) {
	    this.left = left;
	    this.right = right;
	    this.middle = middle; 
	  }

	  /**
  	 * Gets the left.
  	 *
  	 * @return the left
  	 */
  	public L getLeft() { return left; }
	  
  	/**
  	 * Gets the right.
  	 *
  	 * @return the right
  	 */
  	public R getRight() { return right; }
	  
  	/**
  	 * Gets the middle.
  	 *
  	 * @return the middle
  	 */
  	public M getMiddle() { return middle; }

	  /* (non-Javadoc)
  	 * @see java.lang.Object#hashCode()
  	 */
  	@Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode() ^ middle.hashCode(); }

	  /* (non-Javadoc)
  	 * @see java.lang.Object#equals(java.lang.Object)
  	 */
  	@Override
	  public boolean equals(Object o) {
	    if (o == null) return false;
	    if (!(o instanceof Triplet)) return false;
	    Triplet pairo = (Triplet) o;
	    return this.left.equals(pairo.getLeft()) &&
	           this.right.equals(pairo.getRight())&& this.middle.equals(pairo.getMiddle());
	  }
	}