package Pizza;

//Image by suphakit73 on http://www.freedigitalphotos.net

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


@SuppressWarnings("serial")
public class PizzaOrderView extends JFrame
{
	PizzaOrderModel Pizza = new PizzaOrderModel();
	JTextField phoneField;
	JPanel namePanel;
	JLabel nameLabel;
	JTextField nameField;
	JLabel addressLabel;
	JTextField addressField;
	JLabel instructionsLabel;
	JTextField instructionsField;
	JButton update;
	JButton phoneButton;
	JCheckBox An;
	JCheckBox Pep;
	JCheckBox S;
	JCheckBox It;
	JCheckBox Black;
	JCheckBox M;
	JCheckBox On;
	JCheckBox RP;
	JRadioButton Small;
	JRadioButton Med;
	JRadioButton Large;
	JButton addToOrderButton;
	JButton totalTheOrderButton;
	JTextField orderSummaryField;
	JScrollPane Scroll;
	JButton submit;
	JButton clear;
	JTextField instructionsField1;
	JScrollPane Scroll2;
	ButtonGroup B1;
	Order O;
	Customer U;
	
	public PizzaOrderView()
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Guido's Pizza");
		
		
		Border raisedBorder = BorderFactory.createEmptyBorder(0, 2, 2, 2);
		Font font = new Font("Verdana", Font.ITALIC, 50);
		JPanel contentPane = new JPanel() 
		 {  
			 	public void paintComponent(Graphics g) 
			{  
			 	Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ID-100213720.jpg"));  
		 		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		 	}
		 };  
		contentPane.setPreferredSize(new Dimension(400, 900));
		Border Raised = BorderFactory.createTitledBorder(raisedBorder, "Guido's Pizzeria", TitledBorder.TOP, TitledBorder.CENTER, font, Color.RED);
		contentPane.setBorder(Raised);
		setContentPane(contentPane);
		B1 = new ButtonGroup();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		GridLayout G = new GridLayout(1, 2, 10, 10);
		
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setPreferredSize(new Dimension(400, 10));
		customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		BoxLayout B = new BoxLayout(customerInfoPanel, BoxLayout.Y_AXIS);
		customerInfoPanel.setLayout(B);
		
		namePanel = new JPanel();
		namePanel.setLayout(G);
		nameLabel = new JLabel("name");
		nameLabel.setOpaque(true);
		nameLabel.setBackground(Color.ORANGE);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setVerticalAlignment(SwingConstants.CENTER);
		nameField = new JTextField();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.setOpaque(false);
		customerInfoPanel.add(namePanel);
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new GridLayout(1, 2, 10, 10));
		addressLabel = new JLabel("address");
		addressLabel.setOpaque(true);
		addressLabel.setBackground(Color.ORANGE);
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setVerticalAlignment(SwingConstants.CENTER);
		addressField = new JTextField();
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		addressPanel.setOpaque(false);
		customerInfoPanel.add(addressPanel);
		
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(1, 2, 10, 10));
		instructionsLabel = new JLabel("instructions");
		instructionsLabel.setOpaque(true);
		instructionsLabel.setBackground(Color.ORANGE);
		instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsLabel.setVerticalAlignment(SwingConstants.CENTER);
		instructionsField = new JTextField();
		instructionsPanel.add(instructionsLabel);
		instructionsPanel.add(instructionsField);
		instructionsPanel.setOpaque(false);
		customerInfoPanel.add(instructionsPanel);
		
		update = new JButton("Update Customer Info");
		update.setAlignmentX(CENTER_ALIGNMENT);
		update.setEnabled(false);
		update.addActionListener(new PizzaOrderView.UpdateListener());
		customerInfoPanel.add(update);
		customerInfoPanel.setOpaque(false);
		customerInfoPanel.setPreferredSize(new Dimension(60, 5));
		getContentPane().add(customerInfoPanel);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setPreferredSize(new Dimension(400, 20));
		phonePanel.setBorder(BorderFactory.createTitledBorder("Customer Phone Number"));
		phoneButton = new JButton("Search phone #");
		phoneButton.addActionListener(new PizzaOrderView.PhoneListener());
		phoneField = new JTextField();
		phonePanel.setLayout(new GridLayout(0, 2, 0, 0));
		phonePanel.add(phoneButton);
		phonePanel.add(phoneField);
		phonePanel.setOpaque(false);
		getContentPane().add(phonePanel);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setPreferredSize(new Dimension(400, 100));
		orderPanel.setBorder(BorderFactory.createTitledBorder("Pizza Orders"));
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
		
		JPanel toppingsPanel = new JPanel();
		toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.X_AXIS));
		
		JPanel meatToppingsPanel = new JPanel();
		meatToppingsPanel.setBackground(Color.ORANGE);
		meatToppingsPanel.setLayout(new GridLayout(4, 1));
		meatToppingsPanel.setBorder(BorderFactory.createTitledBorder("Meat Toppings:"));
		An = new JCheckBox("Anchovies");
		An.setOpaque(false);
		Pep = new JCheckBox("Pepperoni");
		Pep.setOpaque(false);
		S = new JCheckBox("Sausage");
		S.setOpaque(false);
		It = new JCheckBox("Italian Sausage");
		It.setOpaque(false);
		meatToppingsPanel.add(An);
		meatToppingsPanel.add(Pep);
		meatToppingsPanel.add(S);
		meatToppingsPanel.add(It);
		toppingsPanel.add(meatToppingsPanel);
		
		JPanel veggieToppingsPanel = new JPanel();
		veggieToppingsPanel.setBackground(Color.ORANGE);
		veggieToppingsPanel.setLayout(new GridLayout(4, 1));
		veggieToppingsPanel.setBorder(BorderFactory.createTitledBorder("Veggie Toppings:"));
		Black = new JCheckBox("Black Olives");
		Black.setOpaque(false);
		M = new JCheckBox("Mushrooms");
		M.setOpaque(false);
		On = new JCheckBox("Onions");
		On.setOpaque(false);
		RP = new JCheckBox("Roasted Peppers");
		RP.setOpaque(false);
		veggieToppingsPanel.add(Black);
		veggieToppingsPanel.add(M);
		veggieToppingsPanel.add(On);
		veggieToppingsPanel.add(RP);
		toppingsPanel.add(veggieToppingsPanel);
		orderPanel.setOpaque(false);
		toppingsPanel.setOpaque(false);
		orderPanel.add(toppingsPanel);
		
		JPanel pizzaSizesPanel = new JPanel();
		pizzaSizesPanel.setBackground(Color.ORANGE);
		pizzaSizesPanel.setBorder(BorderFactory.createTitledBorder("Pizza sizes:"));
		pizzaSizesPanel.setLayout(new FlowLayout(1, 3, 1));
		Small = new JRadioButton("Small");
		Small.setOpaque(false);
		Med = new JRadioButton("Medium");
		Med.setOpaque(false);
		Large = new JRadioButton("Large");
		Large.setSelected(true);
		Large.setOpaque(false);
		B1.add(Small);
		B1.add(Med);
		B1.add(Large);
		pizzaSizesPanel.add(Small);
		pizzaSizesPanel.add(Med);
		pizzaSizesPanel.add(Large);
		orderPanel.add(pizzaSizesPanel);
		
		JPanel orderButtonsPanel = new JPanel();
		orderButtonsPanel.setLayout(new GridLayout(1, 2, 10, 10));
		addToOrderButton = new JButton("Add pizza to this order");
		addToOrderButton.setEnabled(false);
		addToOrderButton.addActionListener(new addButtonListener());
		orderButtonsPanel.add(addToOrderButton);
		totalTheOrderButton = new JButton("Total this order");
		totalTheOrderButton.setEnabled(false);
		totalTheOrderButton.addActionListener(new TotalButtonListener());
		orderButtonsPanel.add(totalTheOrderButton);
		orderButtonsPanel.setOpaque(false);
		orderPanel.add(orderButtonsPanel);
		getContentPane().add(orderPanel);
		
		JPanel orderSummaryPanel = new JPanel();
		orderSummaryPanel.setPreferredSize(new Dimension(400, 60));
		orderSummaryPanel.setBorder(BorderFactory.createTitledBorder("Order Summary:"));
		orderSummaryPanel.setLayout(new FlowLayout(1, 1, 1));
		orderSummaryField = new JTextField();
		orderSummaryField.setPreferredSize(new Dimension(1000, 40));
		Scroll = new JScrollPane(orderSummaryField);
		Scroll.setPreferredSize(new Dimension(500, 70));
		Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderSummaryPanel.setOpaque(false);
		orderSummaryPanel.add(Scroll);
		add(orderSummaryPanel);
		
		
		JPanel finishUpPanel = new JPanel();
		finishUpPanel.setPreferredSize(new Dimension(400, 20));
		finishUpPanel.setLayout(new GridLayout(1, 2, 10, 10));
		finishUpPanel.setBorder(BorderFactory.createTitledBorder("Finish the Order:"));
		submit = new JButton("Submit");
		submit.setEnabled(false);
		submit.addActionListener(new SubmitListener());
		clear = new JButton("Clear");
		clear.addActionListener(new ClearListener());
		finishUpPanel.add(submit);
		finishUpPanel.add(clear);
		finishUpPanel.setOpaque(false);
		getContentPane().add(finishUpPanel);
		
		JPanel instructionsPanel1 = new JPanel();
		instructionsPanel1.setPreferredSize(new Dimension(400, 40));
		instructionsPanel1.setBorder(BorderFactory.createTitledBorder("Employee instructions:"));
		instructionsPanel1.setLayout(new FlowLayout(1, 1, 1));
		instructionsField1 = new JTextField("Enter the customers phone number.");
		instructionsField1.setPreferredSize(new Dimension(1000, 20));;
		Scroll2 = new JScrollPane(instructionsField1);
		Scroll2.setPreferredSize(new Dimension(400, 40));
		instructionsPanel1.add(Scroll2);
		instructionsPanel1.setOpaque(false);
		getContentPane().add(instructionsPanel1);
		
		pack();
	}
	
	private class PhoneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String phoneN = phoneField.getText();
			if(phoneN.equals(""))
			{
				
			}
			
			if(Pizza.find(phoneN) == null)
			{
				orderSummaryField.setText("Customer not found");
				phoneButton.setEnabled(false);
				update.setEnabled(true);
			}
			else
			{
				U = Pizza.find(phoneN);
				orderSummaryField.setText("Customer found");
				instructionsField1.setText(U.getInstructions());
				update.setEnabled(true);
				addToOrderButton.setEnabled(true);
			}
		}
	}
	
	private class UpdateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(nameField.getText().equals(""))
			{
				orderSummaryField.setText("You need to fill all the options in the update.");
			}
			else if(addressField.getText().equals(""))
			{
				orderSummaryField.setText("You need to fill all the options in the update.");
			}
			else if(instructionsField.getText().equals(""))
			{
				orderSummaryField.setText("You need to fill all the options in the update.");
			}
			else
			{
				String Name = nameField.getText();
				String address = addressField.getText();
				String instructions = instructionsField.getText();
				String phoneN = phoneField.getText();
				Customer N = new Customer(phoneN, Name, address, instructions);
				Pizza.add(N);
				U = N;
				orderSummaryField.setText("");
				instructionsField1.setText(instructionsField.getText());
				
				if(addToOrderButton.isEnabled() == false)
				{
					addToOrderButton.setEnabled(true);
					
				}
				
			}
		}
	}
	
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			addToOrderButton.setEnabled(false);
			totalTheOrderButton.setEnabled(false);
			submit.setEnabled(false);
			clear.setEnabled(false);
			update.setEnabled(false);
			phoneButton.setEnabled(true);
		    phoneField.setText("");
			nameField.setText("");
			addressField.setText("");
			instructionsField.setText("");
			An.setSelected(false);
			Pep.setSelected(false);
			S.setSelected(false);
			It.setSelected(false);
			Black.setSelected(false);
			M.setSelected(false);
			On.setSelected(false);
			RP.setSelected(false);
			Small.setSelected(false);
			Med.setSelected(false);
			Large.setSelected(true);
			orderSummaryField.setText("");
			instructionsField1.setText("");
		}
	}
	
	private class addButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(totalTheOrderButton.isEnabled() == false)
			{
				O = new Order(U, new Date());
				int R = 0;
				if(Large.isSelected())
				{
					R = 3;
				}
				else if(Med.isSelected())
				{
					R = 2;
				}
				else
				{
					R = 1;
				}
				O.addPizza(R, An.isSelected(), Pep.isSelected(), S.isSelected(), It.isSelected(), Black.isSelected(), M.isSelected(), On.isSelected(), RP.isSelected());
				if(orderSummaryField.getText().length() >= orderSummaryField.getWidth()- 200)
				{
					orderSummaryField.setSize(orderSummaryField.getWidth()*2, orderSummaryField.getHeight());
				}
				totalTheOrderButton.setEnabled(true);
				orderSummaryField.setText(O.orderSummary());
			}
			else
			{
				int R = 0;
				if(Large.isSelected())
				{
					R = 3;
				}
				else if(Med.isSelected())
				{
					R = 2;
				}
				else
				{
					R = 1;
				}
				O.addPizza(R, An.isSelected(), Pep.isSelected(), S.isSelected(), It.isSelected(), Black.isSelected(), M.isSelected(), On.isSelected(), RP.isSelected());
				if(orderSummaryField.getText().length() >= orderSummaryField.getWidth()- 200)
				{
					orderSummaryField.setSize(orderSummaryField.getWidth()*2, orderSummaryField.getHeight());
				}
				orderSummaryField.setText(O.orderSummary());
			}
		}
	}
	
	private class TotalButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			orderSummaryField.setText("The total is $" + O.orderTotal());
			addToOrderButton.setEnabled(false);
			totalTheOrderButton.setEnabled(false);
			submit.setEnabled(true);
		}
	}
	
	private class SubmitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Pizza.add(O);
			orderSummaryField.setText("Order submitted");
			update.setEnabled(true);
			submit.setEnabled(false);
			Pizza.shutdown();
		}
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PizzaOrderView P = new PizzaOrderView();
		P.setSize(600, 700);
		P.setVisible(true);
	}
	
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) 
	{
		int maxUnitIncrement = 1000;
//Get the current position.
		int currentPosition = 0;
		if (orientation == SwingConstants.HORIZONTAL) 
		{
			currentPosition = visibleRect.x;
		} 
		else 
		{
			currentPosition = visibleRect.y;
		}

//Return the number of pixels between currentPosition
//and the nearest tick mark in the indicated direction.
		if (direction < 0) 
		{
			int newPosition = currentPosition -(currentPosition / maxUnitIncrement)* maxUnitIncrement;
			return (newPosition == 0) ? maxUnitIncrement : newPosition;
		} 
		else 
		{
			return ((currentPosition / maxUnitIncrement) + 1)* maxUnitIncrement- currentPosition;
		}
	}
	
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) 
	{
		int maxUnitIncrement = 1000;
		if (orientation == SwingConstants.HORIZONTAL)
			return visibleRect.width - maxUnitIncrement;
		else
			return visibleRect.height - maxUnitIncrement;
	}
}
