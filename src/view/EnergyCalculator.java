package view;

import javax.swing.*;

public class EnergyCalculator implements View {

	private JFrame frmClculoDaEnergia;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			EnergyCalculator window = new EnergyCalculator();
			window.frmClculoDaEnergia.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public EnergyCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClculoDaEnergia = new JFrame();
		frmClculoDaEnergia.setTitle("Cálculo da Energia");
		frmClculoDaEnergia.setBounds(100, 100, 478, 320);
		frmClculoDaEnergia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClculoDaEnergia.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(251, 235, 117, 25);
		frmClculoDaEnergia.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(100, 235, 117, 25);
		frmClculoDaEnergia.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(31, 51, 287, 15);
		frmClculoDaEnergia.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Amplitude");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		frmClculoDaEnergia.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(327, 49, 114, 19);
		frmClculoDaEnergia.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 100, 114, 19);
		frmClculoDaEnergia.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(327, 173, 114, 19);
		frmClculoDaEnergia.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Energia");
		lblNewLabel_2.setBounds(31, 175, 169, 15);
		frmClculoDaEnergia.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 147, 415, 15);
		frmClculoDaEnergia.getContentPane().add(separator);
	}
}
