package view;

import javax.swing.*;

import model.Force;

public class ForceCalculator implements View {

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
		calculator.setBounds(100, 100, 478, 320);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(251, 235, 117, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(100, 235, 117, 25);
		calculator.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(e -> { redirectToMainMenu(); });
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(31, 51, 287, 15);
		calculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor do deslocamento");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 49, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
		
		forceField = new JTextField();
		forceField.setEnabled(false);
		forceField.setBounds(327, 173, 114, 19);
		calculator.getContentPane().add(forceField);
		forceField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Força restauradora:");
		lblNewLabel_2.setBounds(31, 175, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 147, 415, 15);
		calculator.getContentPane().add(separator);
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
