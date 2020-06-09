package view;

import javax.swing.*;

import controller.EnergyController;

public class EnergyCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 320;
	
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
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Amplitude");
		lblNewLabel_1.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Energia");
		lblNewLabel_2.setBounds(25, 185, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
		energyField = new JTextField();
		energyField.setEditable(false);
		energyField.setBounds(327, 185, 114, 19);
		calculator.getContentPane().add(energyField);
		energyField.setColumns(10);
		
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
		EnergyController energyController = new EnergyController();
		String result = energyController.calculate(springConstantField, amplitudeField);
		
		energyField.setText(result);
	}
}
