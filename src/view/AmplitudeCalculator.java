package view;

import javax.swing.*;

import model.Amplitude;

public class AmplitudeCalculator implements View {

	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField amplitudeField;
	private JTextField displacementField;
	private JTextField degreeField;
	private JButton btnCalculate, btnPrevious;
	private JTextField timeField;
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AmplitudeCalculator window = new AmplitudeCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AmplitudeCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da Amplitude");
		calculator.setBounds(100, 100, 478, 480);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(250, 378, 117, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(106, 378, 117, 25);
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
		
		amplitudeField = new JTextField();
		amplitudeField.setEnabled(false);
		amplitudeField.setBounds(327, 324, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amplitude");
		lblNewLabel_2.setBounds(31, 326, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 297, 415, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do deslocamento");
		lblNewLabel_3.setBounds(31, 155, 229, 15);
		calculator.getContentPane().add(lblNewLabel_3);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 151, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor do ângulo de fase");
		lblNewLabel_4.setBounds(31, 204, 229, 15);
		calculator.getContentPane().add(lblNewLabel_4);
		
		degreeField = new JTextField();
		degreeField.setBounds(327, 202, 114, 19);
		calculator.getContentPane().add(degreeField);
		degreeField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor do tempo");
		lblNewLabel_5.setBounds(31, 251, 169, 15);
		calculator.getContentPane().add(lblNewLabel_5);
		
		timeField = new JTextField();
		timeField.setBounds(327, 249, 114, 19);
		calculator.getContentPane().add(timeField);
		timeField.setColumns(10);
	}
	
	private void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		calculator.dispose();
	}
	
	private void calculate() {
		Amplitude amplitude = new Amplitude();
		
		Double springConstant = Double.parseDouble(springConstantField.getText());
		Double mass = Double.parseDouble(massField.getText());
		Double displacement = Double.parseDouble(displacementField.getText());
		Double degree = Double.parseDouble(degreeField.getText());
		Double time = Double.parseDouble(timeField.getText());
		
		String result = String.valueOf(amplitude.calculate(displacement, springConstant, mass, time, degree));
		amplitudeField.setText(result);
	}
}
