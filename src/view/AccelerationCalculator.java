package view;

import javax.swing.*;

import model.Acceleration;

public class AccelerationCalculator implements View {

	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField displacementField;
	private JTextField accelerationField;
	private JButton btnPrevious, btnCalculate;

	public void run() {
		try {
			AccelerationCalculator window = new AccelerationCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AccelerationCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da Aceleração");
		calculator.setBounds(100, 100, 478, 380);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(264, 292, 117, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(108, 292, 117, 25);
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
		
		accelerationField = new JTextField();
		accelerationField.setEnabled(false);
		accelerationField.setBounds(327, 236, 114, 19);
		calculator.getContentPane().add(accelerationField);
		accelerationField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Aceleração");
		lblNewLabel_2.setBounds(31, 238, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 198, 415, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do deslocamento");
		lblNewLabel_3.setBounds(31, 155, 229, 15);
		calculator.getContentPane().add(lblNewLabel_3);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 153, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
	}

	private void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		calculator.dispose();
	}
	
	private void calculate() {
		Acceleration acceleration = new Acceleration();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double mass = Double.parseDouble(massField.getText());
		Double displacement = Double.parseDouble(displacementField.getText());
		
		Double result = acceleration.calculate(springConstant, mass, displacement);
		accelerationField.setText(String.valueOf(result));
	}
}
