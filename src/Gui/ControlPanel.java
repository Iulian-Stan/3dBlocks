package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel
{
	JLabel boxLabel = new JLabel("Box");
	ComboBoxModel<Character> addModel;
	JComboBox<Character> boxText = new JComboBox<Character>();

	JButton upButton = new JButton("\u21D1");
	JButton downButton = new JButton("\u21D3");
	JButton leftButton = new JButton("\u21D0");
	JButton rightButton = new JButton("\u21D2");
	

	JButton getBeliefsButton = new JButton("Show Initial");
	JButton getDesiresButton = new JButton("Show Final");

	JButton setBeliefsButton = new JButton("New Initial");
	JButton setDesiresButton = new JButton("New Final");
	
	JButton runButton = new JButton("Run");
	JButton stopButton = new JButton("Stop");

	public ControlPanel(final ActionListener listener, Character[] labels)
	{
		super();
		setLayout(new GridLayout(6, 2));

		addModel = new DefaultComboBoxModel<Character>(labels);
		boxText.setModel(addModel);
		
		add(boxLabel);
		add(boxText);
		
		upButton.addActionListener(new ButtonListener(listener, "up"));	
		add(upButton);
		leftButton.addActionListener(new ButtonListener(listener, "left"));	
		add(leftButton);
		downButton.addActionListener(new ButtonListener(listener, "down"));	
		add(downButton);
		rightButton.addActionListener(new ButtonListener(listener, "right"));	
		add(rightButton);

		getBeliefsButton.addActionListener(new ButtonListener(listener, "get beliefs"));	
		add(getBeliefsButton);
		getDesiresButton.addActionListener(new ButtonListener(listener, "get desires"));	
		add(getDesiresButton);
		
		setBeliefsButton.addActionListener(new ButtonListener(listener, "set beliefs"));	
		add(setBeliefsButton);
		setDesiresButton.addActionListener(new ButtonListener(listener, "set desires"));	
		add(setDesiresButton);
		
		runButton.addActionListener(new ButtonListener(listener, "run"));	
		add(runButton);
		stopButton.addActionListener(new ButtonListener(listener, "stop"));	
		add(stopButton);
	}
	
	class ButtonListener implements ActionListener
	{
		private ActionEvent _event;
		private ActionListener _listener;
		
		public ButtonListener(ActionListener listener, String command)
		{
			super();
			_listener = listener;
			_event = new ActionEvent(this, 0, command);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			_event.setSource(boxText.getSelectedItem());
			_listener.actionPerformed(_event);
		}}
}
