package view;

import javax.swing.*;

import model.AngularFrequency;

public class AngularFrequencyCalculator implements View {

	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField angularFrequencyField;
	private JButton btnCalculate, btnPrevious;

	public void run() {
		try {
			AngularFrequencyCalculator window = new AngularFrequencyCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AngularFrequencyCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da frequência angular");
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
		
		angularFrequencyField = new JTextField();
		angularFrequencyField.setEnabled(false);
		angularFrequencyField.setBounds(327, 173, 114, 19);
		calculator.getContentPane().add(angularFrequencyField);
		angularFrequencyField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Frequência Angular");
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
		AngularFrequency angularFrequency = new AngularFrequency();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double mass = Double.parseDouble(massField.getText());
		
		String result = String.valueOf(angularFrequency.calculate(springConstant, mass));
		angularFrequencyField.setText(result);
	}
}
