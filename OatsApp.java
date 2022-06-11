import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OatsApp extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JLabel baseLiquidLabel;
	private JComboBox<String> baseLiquidOptions;
	private JLabel gramsLabel;
	private JTextField grams;
	private JLabel yogurtLabel;
	private JComboBox<String> yesOrNoOptions1;
	private JLabel chiaLabel;
	private JComboBox<String> yesOrNoOptions2;
	private JLabel fruitLabel;
	private JComboBox <String> fruitOptions;
	private JButton calculate;
	
	public OatsApp() {
		frame = new JFrame();
		panel = new JPanel();
		baseLiquidLabel = new JLabel("Select base liquid: ");
		String [] baseLiquids = {" ", "milk (dairy)", "almond milk", "water"};
		baseLiquidOptions = new JComboBox<String>(baseLiquids);
		gramsLabel = new JLabel("How many grams of oats? ");
		grams = new JTextField();
		yogurtLabel = new JLabel("Would you like to add yogurt? ");
		String[] yesOrNo = {" ", "Yes", "No"};
		yesOrNoOptions1 = new JComboBox<String>(yesOrNo);
		chiaLabel = new JLabel("Would you like to add chia seeds? ");
		yesOrNoOptions2 = new JComboBox<String>(yesOrNo);
		fruitLabel = new JLabel("Select fruit: ");
		String[] fruits = {" ", "strawberry", "pineapple", "blueberry", "banana", "apple"};
		fruitOptions = new JComboBox<String>(fruits);
		calculate = new JButton("calculate");
		calculate.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 2));
		
		panel.add(baseLiquidLabel);
		panel.add(baseLiquidOptions);
		panel.add(gramsLabel);
		panel.add(grams);
		panel.add(yogurtLabel);
		panel.add(yesOrNoOptions1);
		panel.add(chiaLabel);
		panel.add(yesOrNoOptions2);
		panel.add(fruitLabel);
		panel.add(fruitOptions);
		panel.add(calculate);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Oats App");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public String getMacros() {
		double gramsValue = (double)Integer.parseInt(grams.getText());
		double caloriesCount = gramsValue/100 * 389;
		double carbohydratesCount = gramsValue/100 * 66;
		double proteinCount = gramsValue/100 * 17;
		double fatsCount = gramsValue/100 * 7;
		
		if(baseLiquidOptions.getSelectedItem().equals("milk (dairy)")) {
			caloriesCount += 75;
			carbohydratesCount += 6;
			proteinCount += 4;
			fatsCount += 4;
		}
		else if(baseLiquidOptions.getSelectedItem().equals("almond milk")) {
			caloriesCount += 15;
			carbohydratesCount += 1;
			fatsCount += 1;
		}
		
		if(yesOrNoOptions1.getSelectedItem().equals("Yes")) {
			caloriesCount += 17;
			carbohydratesCount += 1;
			proteinCount += 3;
		}
		
		if(yesOrNoOptions2.getSelectedItem().equals("Yes")) {
			caloriesCount += 50;
			carbohydratesCount += 4;
			proteinCount += 2;
			fatsCount += 2;
		}
		
		if(fruitOptions.getSelectedItem().equals("strawberry")) {
			caloriesCount += 30;
			carbohydratesCount += 8;
			proteinCount += 1;
		}
		else if (fruitOptions.getSelectedItem().equals("pineapple")) {
			caloriesCount += 50;
			carbohydratesCount += 13;
			proteinCount += 1;
		}
		else if (fruitOptions.getSelectedItem().equals("blueberry")) {
			caloriesCount += 57;
			carbohydratesCount += 14;
			proteinCount += 1;
		}
		else if (fruitOptions.getSelectedItem().equals("apple")) {
			caloriesCount += 52;
			carbohydratesCount += 14;
		}
		else if (fruitOptions.getSelectedItem().equals("banana")) {
			caloriesCount += 89;
			carbohydratesCount += 23;
			proteinCount += 1;
		}
		
		return "Calories: " + caloriesCount + "\n\nCarbohydrates: " + carbohydratesCount + "\nProtein: " + proteinCount + "\nFat: " + fatsCount;
	}
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(OatsApp.this, getMacros());
		
	}

	public static void main(String[] args) {
		new OatsApp();

	}


}
