package view;

import javax.swing.*;

import model.Force;

public class ForceCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 320;
	
	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField displacementField;
	private JTextField forceField;
	private JButton btnCalculate, btnPrevious;

	public void run() {
		try {
			ForceCalculator window = new ForceCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ForceCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da Força");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor do deslocamento");
		lblNewLabel_1.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Força restauradora:");
		lblNewLabel_2.setBounds(25, 185, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
		
		forceField = new JTextField();
		forceField.setEnabled(false);
		forceField.setBounds(327, 185, 114, 19);
		calculator.getContentPane().add(forceField);
		forceField.setColumns(10);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(250, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(100, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(e -> { redirectToMainMenu(); });
	}
	
	private void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		calculator.dispose();
	}
	
	private void calculate() {
		Force force = new Force();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double displacement = Double.parseDouble(displacementField.getText());
		
		String result = String.valueOf(force.calculate(springConstant, displacement));
		forceField.setText(result);
	}
}
