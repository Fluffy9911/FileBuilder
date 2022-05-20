package main.fileBuilder.builder.exceptions;

public class FolderException extends Exception {
	Cause c;

	public FolderException(Cause c) {
		this.c = c;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {

		return "An Error occured during the folder validation proccess, Cause is: " + c.getCause();
	}

}
