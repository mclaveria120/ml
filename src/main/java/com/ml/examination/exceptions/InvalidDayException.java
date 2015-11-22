package com.ml.examination.exceptions;

public class InvalidDayException  extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidDayException() {
        super("Dia invalido");
    }
}
