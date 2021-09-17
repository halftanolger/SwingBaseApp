/* --------------------------------------------------------------------------
 * SwingBaseApp
 *
 * Dette er en enkel grunnleggende Swing-applikasjon, som kan benyttes som et
 * utgangspunkt for ulike enkle java-applikasjoner som trenger et grafiskt
 * grensesnitt.
 *
 * Halftan Sætherskar, halftan@online.no, 2021
 * -------------------------------------------------------------------------- */

package no.base.app.ui;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.*;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import no.base.app.Datamanager;

public class SwingBaseApp extends JFrame {

	private int initialWith = 800;
	private int initialHeight = 600;
	private String initialTitle = "SwingBaseApp";
	private static Logger logger = Logger.getLogger(no.base.app.ui.SwingBaseApp.class);

	private JPanel mainPanel;

	public static void main(String args[]) {
		BasicConfigurator.configure();
		logger.info("Hello World");
		SwingBaseApp.boot();
	}

	public SwingBaseApp() {

		final SplashScreen splash = SplashScreen.getSplashScreen();
        	if (splash == null) {
            		System.out.println("SplashScreen.getSplashScreen() returned null");
            		return;
        	}
        	Graphics2D g = splash.createGraphics();
        	if (g == null) {
            		System.out.println("g is null");
            		return;
        	}
        	for(int i=0; i<100; i++) {
            		renderSplashFrame(g, i);
            		splash.update();
            		try {
                		Thread.sleep(90);
            		} catch(InterruptedException e) {
            		}
        	}
        	splash.close();
        	setVisible(true);
        	toFront();
		initComponents();
		initJFrame();
	}

	public void exitSwingBaseApp(int ret) {
		logger.info("TheEnd");
		System.exit(ret);
	}

	public static void boot() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingBaseApp a = new SwingBaseApp();
				Datamanager.getInstance().setSwingBaseApp(a);
			}
		});		
	}

	private void initJFrame() {
		this.setTitle(initialTitle);
		this.pack();
		this.setSize(initialWith,initialHeight);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		this.setLocation(new Point((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.width) / 2));

		this.setVisible(true);
	}

	private void initComponents() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		SwingBaseMenu m = new SwingBaseMenu();
		setJMenuBar(m.getJMenuBar());

	}

	private void exitForm(WindowEvent evt) {
		exitSwingBaseApp(0);
	}

	static void renderSplashFrame(Graphics2D g, int frame) {
        	final String[] comps = {"foo", "bar", "baz"};
        	g.setComposite(AlphaComposite.Clear);
        	g.fillRect(120,140,200,40);
        	g.setPaintMode();
        	g.setColor(Color.BLACK);
        	g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
    	}



}
