package main.fileBuilder.builder;

import java.io.File;

import main.fileBuilder.builder.exceptions.Cause;
import main.fileBuilder.builder.exceptions.FolderException;
import main.fire.core.debug.Debug;
import main.fire.util.Status;

public class FileFolder {

	File folder;
	String folderName;
	boolean errorOnDuplicate = false;

	public FileFolder(File folder, String folderName) {
		this.folder = folder;
		this.folderName = folderName;
		if (FolderManager.getStatus() == Status.DONE) {
			FolderManager.getFolders().put(folderName, this);
		}
	}

	/**
	 * Validates a folder to check weather its there
	 * 
	 * @throws FolderException
	 */
	public void validateFolder() throws FolderException {
		Debug.printInfo("Starting Validation Check... for folder: " + folderName);
		if (folder.exists()) {
			if (errorOnDuplicate) {
				this.validationFailed();

				throw new FolderException(new Cause("Duplicate folder entries, for folder: " + folderName));
			}
		}
		if (!folder.exists()) {

			folder.mkdirs();
			Debug.printInfo("Validation success for folder: " + folderName);
		}

	}

	private void validationFailed() {
		Debug.error("Validation errored");
	}

	public FileFolder errorOnDuplicate() {
		errorOnDuplicate = true;
		return this;
	}

	public File getFolder() {
		return folder;
	}

	public String getFolderName() {
		return folderName;
	}

}
