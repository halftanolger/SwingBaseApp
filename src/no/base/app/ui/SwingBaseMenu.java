package no.base.app.ui;


import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SwingBaseMenu {


	public JMenuBar getJMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menuBar.add(menu);
	
		menuItem = new JMenuItem("Open file");
		menu.add(menuItem);
	
		menuItem = new JMenuItem("Save");
		menu.add(menuItem);

		menuItem = new JMenuItem("Save as..");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit");
		menu.add(menuItem);
  		menuItem.addActionListener(new MenuExitAction());
		 
		menu = new JMenu("Help");
		menuBar.add(menu);  	
                            
		menuItem = new JMenuItem("Help");
		menu.add(menuItem);
		menuItem.addActionListener(new MenuHelpAction());
		
		menu.addSeparator();

		menuItem = new JMenuItem("About");
		menu.add(menuItem);
		menuItem.addActionListener(new MenuAboutAction());
		
		return menuBar;
	}
}



