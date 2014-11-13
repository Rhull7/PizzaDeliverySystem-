import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class PizzaOrderView extends JFrame
{
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
		ButtonGroup B1 = new ButtonGroup();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		GridLayout G = new GridLayout(1, 2, 10, 10);
		
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setPreferredSize(new Dimension(400, 10));
		customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		BoxLayout B = new BoxLayout(customerInfoPanel, BoxLayout.Y_AXIS);
		customerInfoPanel.setLayout(B);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(G);
		JLabel nameLabel = new JLabel("name");
		nameLabel.setOpaque(true);
		nameLabel.setBackground(Color.ORANGE);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setVerticalAlignment(SwingConstants.CENTER);
		JTextField nameField = new JTextField();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.setOpaque(false);
		customerInfoPanel.add(namePanel);
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel addressLabel = new JLabel("address");
		addressLabel.setOpaque(true);
		addressLabel.setBackground(Color.ORANGE);
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setVerticalAlignment(SwingConstants.CENTER);
		JTextField addressField = new JTextField();
		addressPanel.add(addressLabel);
		addressPanel.add(addressField);
		addressPanel.setOpaque(false);
		customerInfoPanel.add(addressPanel);
		
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel instructionsLabel = new JLabel("instructions");
		instructionsLabel.setOpaque(true);
		instructionsLabel.setBackground(Color.ORANGE);
		instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsLabel.setVerticalAlignment(SwingConstants.CENTER);
		JTextField instructionsField = new JTextField();
		instructionsPanel.add(instructionsLabel);
		instructionsPanel.add(instructionsField);
		instructionsPanel.setOpaque(false);
		customerInfoPanel.add(instructionsPanel);
		
		JButton update = new JButton("Update Customer Info");
		update.setAlignmentX(CENTER_ALIGNMENT);
		update.setEnabled(false);
		customerInfoPanel.add(update);
		customerInfoPanel.setOpaque(false);
		customerInfoPanel.setPreferredSize(new Dimension(60, 5));
		getContentPane().add(customerInfoPanel);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setPreferredSize(new Dimension(400, 20));
		phonePanel.setBorder(BorderFactory.createTitledBorder("Customer Phone Number"));
		JButton phoneButton = new JButton("Search phone #");
		JTextField phoneField = new JTextField();
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
		JCheckBox An = new JCheckBox("Anchovies");
		An.setOpaque(false);
		JCheckBox Pep = new JCheckBox("Pepperoni");
		Pep.setOpaque(false);
		JCheckBox S = new JCheckBox("Sausage");
		S.setOpaque(false);
		JCheckBox It = new JCheckBox("Italian Sausage");
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
		JCheckBox Black = new JCheckBox("Black Olives");
		Black.setOpaque(false);
		JCheckBox M = new JCheckBox("Mushrooms");
		M.setOpaque(false);
		JCheckBox On = new JCheckBox("Onions");
		On.setOpaque(false);
		JCheckBox RP = new JCheckBox("Roasted Peppers");
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
		JRadioButton Small = new JRadioButton("Small");
		Small.setOpaque(false);
		JRadioButton Med = new JRadioButton("Medium");
		Med.setOpaque(false);
		JRadioButton Large = new JRadioButton("Large");
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
		JButton addToOrderButton = new JButton("Add pizza to this order");
		addToOrderButton.setEnabled(false);
		orderButtonsPanel.add(addToOrderButton);
		JButton totalTheOrderButton = new JButton("Total this order");
		totalTheOrderButton.setEnabled(false);
		orderButtonsPanel.add(totalTheOrderButton);
		orderButtonsPanel.setOpaque(false);
		orderPanel.add(orderButtonsPanel);
		getContentPane().add(orderPanel);
		
		JPanel orderSummaryPanel = new JPanel();
		orderSummaryPanel.setPreferredSize(new Dimension(400, 60));
		orderSummaryPanel.setBorder(BorderFactory.createTitledBorder("Order Summary:"));
		orderSummaryPanel.setLayout(new FlowLayout(1, 1, 1));
		JTextField orderSummaryField = new JTextField();
		orderSummaryField.setPreferredSize(new Dimension(1000, 40));
		JScrollPane Scroll = new JScrollPane(orderSummaryField);
		Scroll.setPreferredSize(new Dimension(300, 70));
		Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderSummaryPanel.setOpaque(false);
		orderSummaryPanel.add(Scroll);
		add(orderSummaryPanel);
		
		
		JPanel finishUpPanel = new JPanel();
		finishUpPanel.setPreferredSize(new Dimension(400, 20));
		finishUpPanel.setLayout(new GridLayout(1, 2, 10, 10));
		finishUpPanel.setBorder(BorderFactory.createTitledBorder("Finish the Order:"));
		JButton submit = new JButton("Submit");
		submit.setEnabled(false);
		JButton clear = new JButton("Clear");
		finishUpPanel.add(submit);
		finishUpPanel.add(clear);
		finishUpPanel.setOpaque(false);
		getContentPane().add(finishUpPanel);
		
		JPanel instructionsPanel1 = new JPanel();
		instructionsPanel1.setPreferredSize(new Dimension(400, 40));
		instructionsPanel1.setBorder(BorderFactory.createTitledBorder("Employee instructions:"));
		instructionsPanel1.setLayout(new FlowLayout(1, 1, 1));
		JTextField instructionsField1 = new JTextField("Enter the customers phone number.");
		instructionsField1.setPreferredSize(new Dimension(1000, 20));;
		JScrollPane Scroll2 = new JScrollPane(instructionsField1);
		Scroll2.setPreferredSize(new Dimension(400, 40));
		instructionsPanel1.add(Scroll2);
		instructionsPanel1.setOpaque(false);
		getContentPane().add(instructionsPanel1);
		
		pack();
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
