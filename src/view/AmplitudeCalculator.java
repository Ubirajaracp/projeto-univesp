package view;

import javax.swing.*;

import controller.AmplitudeController;

public class AmplitudeCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 480;
	
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
		
		JLabel lblNewLabel_4 = new JLabel("Valor do ângulo de fase");
		lblNewLabel_4.setBounds(25, 200, 229, 15);
		calculator.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valor do tempo");
		lblNewLabel_5.setBounds(25, 250, 169, 15);
		calculator.getContentPane().add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 300, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Amplitude");
		lblNewLabel_2.setBounds(25, 335, 169, 15);
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
		
		degreeField = new JTextField();
		degreeField.setBounds(327, 200, 114, 19);
		calculator.getContentPane().add(degreeField);
		degreeField.setColumns(10);

		timeField = new JTextField();
		timeField.setBounds(327, 250, 114, 19);
		calculator.getContentPane().add(timeField);
		timeField.setColumns(10);
		
		amplitudeField = new JTextField();
		amplitudeField.setEditable(false);
		amplitudeField.setBounds(327, 335, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
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
		try {
			AmplitudeController amplitudeController = new AmplitudeController();
			String result = amplitudeController.calculate(springConstantField, massField, displacementField, degreeField, timeField);
			
			amplitudeField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira somente valores numéricos.",
					 "Entrada inválida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, preencha os campos corretamente.",
					 "Entrada inválida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
