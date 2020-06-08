package view;

import javax.swing.*;

public class ForceCalculator implements View {

	private JFrame calculator;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnPrevious;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ForceCalculator window = new ForceCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ForceCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calculator = new JFrame();
		calculator.setTitle("Cálculo da Força");
		calculator.setBounds(100, 100, 478, 320);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(251, 235, 117, 25);
		calculator.getContentPane().add(btnNewButton);
		
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
		
		textField = new JTextField();
		textField.setBounds(327, 49, 114, 19);
		calculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(327, 173, 114, 19);
		calculator.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
}
