package view;

import javax.swing.*;

import model.Period;

public class PeriodCalculator implements View {

	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField periodField;
	private JButton btnCalculate, btnPrevious;

	
	public void run() {
		try {
			PeriodCalculator window = new PeriodCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PeriodCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Período");
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
		
		JLabel lblNewLabel_1 = new JLabel("Valor da massa");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 49, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(massField);
		massField.setColumns(10);
		
		periodField = new JTextField();
		periodField.setEnabled(false);
		periodField.setBounds(327, 173, 114, 19);
		calculator.getContentPane().add(periodField);
		periodField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Período");
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
		Period period = new Period();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double mass = Double.parseDouble(massField.getText());
		
		String result = String.valueOf(period.calculate(springConstant, mass));
		periodField.setText(result);
	}
}
