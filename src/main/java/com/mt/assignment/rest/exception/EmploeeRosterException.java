package com.mt.assignment.rest.exception;

/***
 * 
 * @author manoj
 *
 */

public class EmploeeRosterException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public EmploeeRosterException() {
		super();
	}

	/**
	 * @param message
	 *            the of message to set
	 */
	public EmploeeRosterException(String message) {
		super(message);
	}

	/**
	 * @param t
	 *            the of t to set
	 */
	public EmploeeRosterException(Throwable t) {
		super(t);
	}

	/**
	 * @param message
	 *            the of message to set
	 * @param t
	 *            the of t to set
	 */
	public EmploeeRosterException(String message, Throwable t) {
		super(message, t);
	}
}
