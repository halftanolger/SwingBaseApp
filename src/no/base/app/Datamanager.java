package no.base.app;

import no.base.app.ui.SwingBaseApp;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Datamanager {

	private static Logger logger = Logger.getLogger(no.base.app.Datamanager.class);

	private static Datamanager instance = null;
	private SwingBaseApp swingBaseApp = null;
	
	private Datamanager() {
		logger.info("Datamanager - contstructor");
	}

	public static synchronized Datamanager getInstance() {
		if (instance == null)
			instance = new Datamanager();
		return instance;
	}

	public void setSwingBaseApp(SwingBaseApp app) {
		swingBaseApp = app;
	}

	public SwingBaseApp getSwingBaseApp() {
		return swingBaseApp;
	}

}
