package main.fileBuilder;

import main.fire.cache.CacheObject;
import main.fire.core.CoreIO;
import main.fire.game.Program;
import main.module.fire.ModuleLoader;

public class Tester extends Program {
	public static CoreIO io;

	public Tester(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		io = new CoreIO();
		io.startProgram(new Tester("tester"));
	}

	@Override
	public void saveCache(CacheObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCache(CacheObject m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadAssets() {
		// TODO Auto-generated method stub

	}

	@Override
	public void programEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addModulesEvent() {
		ModuleLoader.addModule(new FileBuilder());
		super.addModulesEvent();
	}

}
