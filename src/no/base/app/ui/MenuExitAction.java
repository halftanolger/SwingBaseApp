package no.base.app.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import no.base.app.ui.SwingBaseApp;
import no.base.app.Datamanager;

public class MenuExitAction implements ActionListener {

	private static Logger logger = Logger.getLogger(no.base.app.ui.MenuExitAction.class);

	public void actionPerformed(ActionEvent e) {
		String signatur = "actionPerformed(ActionEvent) ";
		logger.info(signatur + "Enter method.");

		JFrame frame = (JFrame)Datamanager.getInstance().getSwingBaseApp();

		Object[] options = {"Yes", "No"};
		int n = JOptionPane.showOptionDialog(frame,
    				"Do you want to exit the application?",
    				"Exit",
    				JOptionPane.YES_NO_OPTION,
    				JOptionPane.QUESTION_MESSAGE,
    				null,     
    				options,  
    				options[0]); 

		logger.debug(signatur + "n=" + n);
		SwingBaseApp a = Datamanager.getInstance().getSwingBaseApp();
		if (n == 0)
			a.exitSwingBaseApp(0);
		
		logger.info(signatur + "Exit method.");
	}

}
