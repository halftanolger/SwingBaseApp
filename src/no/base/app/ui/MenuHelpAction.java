package no.base.app.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import no.base.app.ui.SwingBaseApp;
import no.base.app.Datamanager;

public class MenuHelpAction implements ActionListener {

	private static Logger logger = Logger.getLogger(no.base.app.ui.MenuHelpAction.class);

	public void actionPerformed(ActionEvent e) {
    		String signatur = "actionPerformed(ActionEvent) ";
		logger.info(signatur + "Enter method.");

 		JFrame frame = (JFrame)Datamanager.getInstance().getSwingBaseApp();

                JOptionPane.showMessageDialog(frame,
                        "This is some information about this SwingBaseApplication..\n" +
			"For the moment, this app does nothing.",
			"Help",
                        JOptionPane.PLAIN_MESSAGE);

		logger.info(signatur + "Exit method.");
	}

}
