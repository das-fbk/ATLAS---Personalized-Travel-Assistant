package eu.domainobjects;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.domainobjects.controller.MainController;
import eu.domainobjects.presentation.main.MainWindow;

/**
 * Main class for Domain Objects Demonstrator
 */
public class Demonstrator {

	private static final Logger logger = LogManager
			.getLogger(Demonstrator.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			private MainWindow window;
			private MainController controller;

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					logger.warn("Unable to set System look and Feel", e);
				}

				try {
					logger.info("Domain Objects Demonstrator start");
					window = new MainWindow();
					controller = new MainController(window);
					window.getActivityWindow().setController(controller);
					window.setController(controller);
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}
}
