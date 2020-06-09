package view;

import javax.swing.*;

import model.Energy;

public class EnergyCalculator implements View {

	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField amplitudeField;
	private JTextField energyField;
	private JButton btnCalculate, btnPrevious;

	public void run() {
		try {
			EnergyCalculator window = new EnergyCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EnergyCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da Energia");
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
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Amplitude");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 49, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
		energyField = new JTextField();
		energyField.setEnabled(false);
		energyField.setBounds(327, 173, 114, 19);
		calculator.getContentPane().add(energyField);
		energyField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Energia");
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
		Energy energy = new Energy();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double amplitude = Double.parseDouble(amplitudeField.getText());
		
		String result = String.valueOf(energy.calculate(springConstant, amplitude));
		energyField.setText(result);
	}
}
