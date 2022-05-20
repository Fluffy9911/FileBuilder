package main.fileBuilder.builder;

import java.util.HashMap;
import java.util.Map;

import main.fileBuilder.builder.exceptions.FolderException;
import main.fire.core.debug.Debug;
import main.fire.util.Status;

public class FolderManager {
	private static Status st;
	private static Map<String, FileFolder> folders;
	public static final String FIREBIRD_LOCATION = "firebird/data";

	public static void setupFolderManager() {
		st = Status.STARTING;
		folders = new HashMap<>();

		st = Status.DONE;
		FolderManager.validateFolders();
	}

	public static Status getStatus() {
		if (st == null)
			st = Status.NONE;
		return st;
	}

	private static void validateFolders() {
		FolderManager.getFolders().forEach((name, fileFolder) -> {
			try {
				fileFolder.validateFolder();
			} catch (FolderException e) {
				Debug.debugError(FolderManager.class, e);
			}
		});
	}

	public static void reValidateFolders() {
		FolderManager.validateFolders();
	}

	public static Map<String, FileFolder> getFolders() {
		return folders;
	}

}
