package view;

import javax.swing.*;

import controller.ShmFrequencyController;

public class ShmFrequencyCalculator extends Calculator implements View {
	
	private JTextField springConstantField, massField, shmFrequencyField;

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
		super.setWidth(525);
		super.setHeight(320);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("Cálculo da frequência para o MHS");

		JLabel springConstantLabel = new JLabel("Valor da constante elástica da mola (N/m)");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel massLabel = new JLabel("Valor da massa (kg)");
		massLabel.setBounds(25, 100, 253, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		
		JLabel shmFrequencyLabel = new JLabel("Frequência para o MHS (Hz)");
		shmFrequencyLabel.setBounds(25, 185, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		massField.setColumns(10);
		
		shmFrequencyField = new JTextField();
		shmFrequencyField.setEditable(false);
		shmFrequencyField.setBounds(327, 185, 114, 19);
		shmFrequencyField.setColumns(10);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(massLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(shmFrequencyLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(massField);
		super.calculator.getContentPane().add(shmFrequencyField);

		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, massField, shmFrequencyField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(shmFrequencyField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			ShmFrequencyController shmFrequencyController = new ShmFrequencyController();
			
			String result = shmFrequencyController.calculate(springConstantField, massField);
			shmFrequencyField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, super.getInvalidInputMessage(), "Erro",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, super.getEmptyInputMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
