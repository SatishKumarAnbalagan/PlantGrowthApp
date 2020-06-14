/**
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.neu.csye6200.BGAppUI.BGApp;
import edu.neu.csye6200.BGAppUI.BGCanvas;

/**
 * @author satish
 *
 */
public class TreeGrowthApp extends BGApp {

	private static Logger log = Logger.getLogger(TreeGrowthApp.class.getName());

	protected JPanel mainPanel = null;
	protected JPanel northPanel = null;
	protected JButton startBtn = null;
    protected JButton pauseOrResumeBtn = null;	
	protected JButton stopBtn = null;
	//protected JComboBox<String> ruleBox = null;
	//protected JTextField genrNumber = null;
	protected JLabel labelName = null;
	public boolean IsRuled = false;
	public boolean IsStarted = false;
	public boolean IsStoped = false;
	public boolean IspausedOrResumed = false;
	
	/**
	 * TreeGrowth App constructor.
	 * @param - NIL
	 */
	public TreeGrowthApp() {
		frame.setSize(800, 600); // initial Frame size
		frame.setTitle("Tree Growth App");
		
		menuMgr.createDefaultActions(); // Set up default menu items
		
    	showUI(); // Cause the Swing Dispatch thread to display the JFrame
    }

	/**
	 * 
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @return the isRuled
	 */
	public boolean getIsRuled() {
		return IsRuled;
	}

	/**
	 * @param isRuled the isRuled to set
	 */
	public void setIsRuled(boolean isRuled) {
		IsRuled = isRuled;
	}

	/**
	 * @return the isStarted
	 */
	public boolean getIsStarted() {
		return IsStarted;
	}

	/**
	 * @param isStarted the isStarted to set
	 */
	public void setIsStarted(boolean isStarted) {
		IsStarted = isStarted;
	}

	/**
	 * @return the isStoped
	 */
	public boolean getIsStoped() {
		return IsStoped;
	}

	/**
	 * @param isStoped the isStoped to set
	 */
	public void setIsStoped(boolean isStoped) {
		IsStoped = isStoped;
	}

	/**
	 * @return the ispausedOrResumed
	 */
	public boolean getIspausedOrResumed() {
		return IspausedOrResumed;
	}

	/**
	 * @param ispausedOrResumed the ispausedOrResumed to set
	 */
	public void setIspausedOrResumed(boolean ispausedOrResumed) {
		IspausedOrResumed = ispausedOrResumed;
	}

	private void HandleRuleBox(String Rule){
		if (Rule == null) {
			log.info("Rule is null ! Select Rule");
			return;		
		}


		setIsRuled(true);
		bgPanel.setRuleSelected(Rule);
		setIsStarted(false);
		setIsStoped(false);
		setIspausedOrResumed(false);
		bgPanel.setGrowthStarted(false);
		frame.repaint();
		
	}
	
	public void HandleStartButton(){
		if (getIsStarted()) {
			log.info("Already Started ! Stop/Pause the simulation");
			return;	
		}
		
		setIsStarted(true);
		setIsStoped(false);
		setIspausedOrResumed(false);
		bgPanel.setGrowthStarted(true);
		frame.repaint();
	}
	
	public void HandleStopButton() {
		if (! getIsStarted() || getIsStoped()) {
			log.info("Already Stopped ! Press Start or Resume to start simulation");
		}
		
		resetToDefault();

	}
	
	
	private void resetToDefault() {
		setIsStoped(true);
		setIsRuled(false);
		if(! getIsRuled()) {
			ruleBox.setSelectedIndex(0);
		}
		setIsStarted(false);
		setIspausedOrResumed(false);
		bgPanel.setGrowthStarted(false);
		frame.repaint();
	}

	private void HandleGeneration(String generationNumber) {
		if (generationNumber == null) {
			log.info("generation Number is null ! Enter it");
			return;		
		}
		bgPanel.setGeneration(Integer.parseInt(generationNumber));
	}
	
	/**
	 * perform respective button's action
	 * @param - ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We received an ActionEvent " + e.getSource());
		if ( e.getActionCommand()== "comboBoxChanged"){
			JComboBox ruleSelect = (JComboBox) e.getSource();
			Object selected = ruleSelect.getSelectedItem();
			HandleRuleBox(selected.toString());
			//log.info("Rule Box changed - " + ruleBox.getActionCommand().toString());
		} else if (e.getActionCommand() == "Start") {
			log.info("Start pressed");
			HandleStartButton();
		} else if (e.getActionCommand() == "Stop") {
			log.info("Stop pressed");
			HandleStopButton();
		} else if (e.getActionCommand() == "Pause/Resume") {
			log.info("pause/Resume pressed");
			//HandlepauseOrResumeButton();
		} else if (e.getSource()== genrNumber) {
			log.info(" Generation Number : " + genrNumber.getText());
			HandleGeneration(genrNumber.getText());
		}	else {
			log.info("Unknown Event");
		}
	}	
	
	/**
	 * Create a top panel that will hold control buttons
	 * @param - NIL
	 * @return North JPanel
	 */
    public JPanel getNorthPanel() {
    	northPanel = new JPanel();
    	northPanel.setLayout(new FlowLayout());
    	
    	//ruleBox = new JComboBox ();
    	ruleBox.addItem("Select Rule option");
    	ruleBox.addItem("Rule 1");
    	ruleBox.addItem("Rule 2");
    	//ruleBox.setSelectedIndex(0);
    	ruleBox.addActionListener(this);
    	northPanel.add(ruleBox);
    	
    	//genrNumber = new JTextField(2);
    	labelName = new JLabel("Enter number of Generations : ");
    	northPanel.add(labelName);
    	genrNumber.addActionListener(this);
    	northPanel.add(genrNumber);
    	
    	startBtn = new JButton("Start");
    	startBtn.addActionListener(this); // Allow the app to hear about button pushes
    	northPanel.add(startBtn);
    	
    	pauseOrResumeBtn = new JButton("Pause/Resume");
    	pauseOrResumeBtn.addActionListener(this); // Allow the app to hear about button pushes
    	northPanel.add(pauseOrResumeBtn);
    	
    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
    	stopBtn.addActionListener(this);
    	northPanel.add(stopBtn);
    	
    	return northPanel;
    }

	/**
	 * Create a main panel that will hold the bulk of our application display
	 * @param - NIL
	 * @return - Main JPanel
	 */
	@Override
	public JPanel getMainPanel() {
		mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(BorderLayout.NORTH, getNorthPanel());
    	
       	mainPanel.add(BorderLayout.CENTER, bgPanel);
    	
    	return mainPanel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeGrowthApp TGapp = new TreeGrowthApp();
		log.info("TreeGrowthApp started");
	}

}
