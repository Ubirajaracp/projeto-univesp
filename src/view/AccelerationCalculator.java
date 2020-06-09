package view;

import javax.swing.*;

import model.Acceleration;

public class AccelerationCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 380;
	
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
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da massa");
		lblNewLabel_1.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do deslocamento");
		lblNewLabel_3.setBounds(25, 150, 229, 15);
		calculator.getContentPane().add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 200, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Aceleração");
		lblNewLabel_2.setBounds(25, 235, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(massField);
		massField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 150, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
		
		accelerationField = new JTextField();
		accelerationField.setEnabled(false);
		accelerationField.setBounds(327, 235, 114, 19);
		calculator.getContentPane().add(accelerationField);
		accelerationField.setColumns(15);
		
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
		Acceleration acceleration = new Acceleration();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double mass = Double.parseDouble(massField.getText());
		Double displacement = Double.parseDouble(displacementField.getText());
		
		Double result = acceleration.calculate(springConstant, mass, displacement);
		accelerationField.setText(String.valueOf(result));
	}
}
