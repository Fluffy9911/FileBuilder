package main.fileBuilder;

import main.fileBuilder.builder.FolderManager;
import main.fire.cache.CacheManager;
import main.fire.cache.CacheObject;
import main.module.fire.FireBirdModule;

public class FileBuilder extends FireBirdModule {

	@Override
	public void init() {
		FolderManager.setupFolderManager();

	}

	@Override
	public void cacheEvent(CacheObject obj, CacheManager m) {

	}

	@Override
	public String uniqueID() {
		// TODO Auto-generated method stub
		return "file-builder";
	}

	@Override
	public String version() {
		// TODO Auto-generated method stub
		return "1.0-tests";
	}

}
