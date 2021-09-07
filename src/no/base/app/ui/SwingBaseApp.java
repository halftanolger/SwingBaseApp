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

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

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
				new SwingBaseApp().setVisible(true);
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
	}

	private void exitForm(WindowEvent evt) {
		exitSwingBaseApp(0);
	}

}
