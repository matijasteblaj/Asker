import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.MenuSelectionManager;

@SuppressWarnings("serial")
public class AskFrame extends JFrame implements ActionListener, KeyListener{
	
	private JMenu modes;
	private JMenuItem mode1;
	private JMenuItem mode2;
	private JMenuItem mode3;
	private JTextArea output;
	private JMenuBar menuBar;
	private Extractor extractor;
	private boolean next;

	public AskFrame(Extractor E) {
		super();
		this.next = false;
		this.extractor = E;
		setTitle("Asker");
		Container pane = this.getContentPane();
		pane.setLayout(new GridBagLayout());
		
		this.menuBar = new JMenuBar();
		this.modes = new JMenu("Izbor nacina");
		menuBar.add(modes);
		this.mode1 = new JMenuItem("Nacin 1");
		mode1.addActionListener(this);
		mode1.setActionCommand("Nacin 1");
		mode1.setToolTipText("Izpisuje nakljucna vprasanja iz vseh sklopov");
		
		this.mode2 = new JMenu("Nacin 2");
		for (String sklop : extractor.seznamSklopov) {
			JMenuItem a = new JMenuItem(sklop);
			a.addActionListener(this);
			a.setActionCommand(sklop);
			mode2.add(a);
		}
		mode2.setToolTipText("Izpisuje nakljucna vprasanja iz dolocenega sklopa");
		
		this.mode3 = new JMenuItem("Nacin 3");
		mode3.addActionListener(this);
		mode3.setActionCommand("Nacin 3");
		mode3.setToolTipText("Cikla po eno vprasanje iz vsakega sklopa");
		
		modes.add(mode1);
		modes.add(mode2);
		modes.add(mode3);
		pane.add(menuBar);
		
		this.output = new JTextArea(20, 40);
		output.setEditable(false);
		output.setText("HAHAHAHA");
		GridBagConstraints outputConstraint = new GridBagConstraints();
		outputConstraint.gridx= 0;
		outputConstraint.gridy = 1;
		outputConstraint.fill = GridBagConstraints.BOTH;
		pane.add(output, outputConstraint);
		pane.addKeyListener(this);
		
		
		this.setJMenuBar(menuBar);
		
	}
	
	@SuppressWarnings("unchecked")
	private void nacin1(){
		ArrayList<String> vprasanja = (ArrayList<String>) this.extractor.returnAll().clone();
		//Scanner scanner = new Scanner(System.in);
		Collections.shuffle(vprasanja);
		while (!vprasanja.isEmpty()) {
			//???
		}
		//scanner.close();
	}
	
	private void nacin2(String action) {
		// TODO Auto-generated method stub
		
	}

	private void nacin3() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (this.extractor.seznamSklopov.contains(action)) {
			MenuSelectionManager.defaultManager().clearSelectedPath();
			nacin2(action);
		} else if (action.equals("Nacin 1")){
			MenuSelectionManager.defaultManager().clearSelectedPath();
			nacin1();
		} else if (action.equals("Nacin 3")) {
			MenuSelectionManager.defaultManager().clearSelectedPath();
			nacin3();
		} else {
			System.out.println("Neveljaven ukaz");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		this.next = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	


	
}
