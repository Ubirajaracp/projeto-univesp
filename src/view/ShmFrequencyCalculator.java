package view;

import javax.swing.*;

public class ShmFrequencyCalculator implements View {

	private JFrame frmClculoFreqMhs;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ShmFrequencyCalculator window = new ShmFrequencyCalculator();
			window.frmClculoFreqMhs.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ShmFrequencyCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClculoFreqMhs = new JFrame();
		frmClculoFreqMhs.setTitle("Cálculo da frequência para o MHS");
		frmClculoFreqMhs.setBounds(100, 100, 478, 320);
		frmClculoFreqMhs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClculoFreqMhs.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(251, 235, 117, 25);
		frmClculoFreqMhs.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(100, 235, 117, 25);
		frmClculoFreqMhs.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(31, 51, 287, 15);
		frmClculoFreqMhs.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da massa");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		frmClculoFreqMhs.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(327, 49, 114, 19);
		frmClculoFreqMhs.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 100, 114, 19);
		frmClculoFreqMhs.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(327, 173, 114, 19);
		frmClculoFreqMhs.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Frequência para o MHS");
		lblNewLabel_2.setBounds(31, 175, 169, 15);
		frmClculoFreqMhs.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 147, 415, 15);
		frmClculoFreqMhs.getContentPane().add(separator);
	}
}
