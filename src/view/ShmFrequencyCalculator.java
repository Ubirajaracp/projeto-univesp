package view;

import javax.swing.*;

import controller.ShmFrequencyController;

public class ShmFrequencyCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 320;
	
	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField shmFrequencyField;
	private JButton btnCalculate, btnPrevious;

	public void run() {
		try {
			ShmFrequencyCalculator window = new ShmFrequencyCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ShmFrequencyCalculator() {
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da frequência para o MHS");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da massa");
		lblNewLabel_1.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Frequência para o MHS");
		lblNewLabel_2.setBounds(25, 185, 169, 15);
		calculator.getContentPane().add(lblNewLabel_2);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(massField);
		massField.setColumns(10);
		
		shmFrequencyField = new JTextField();
		shmFrequencyField.setEditable(false);
		shmFrequencyField.setBounds(327, 185, 114, 19);
		calculator.getContentPane().add(shmFrequencyField);
		shmFrequencyField.setColumns(10);
		
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
		ShmFrequencyController shmFrequencyController = new ShmFrequencyController();
		String result = shmFrequencyController.calculate(springConstantField, massField);

		shmFrequencyField.setText(result);
	}
}
