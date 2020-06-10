package view;

import javax.swing.*;

import controller.AngularFrequencyController;

public class AngularFrequencyCalculator extends Calculator implements View {

	private JTextField springConstantField, massField, angularFrequencyField;

	public void run() {
		try {
			AngularFrequencyCalculator window = new AngularFrequencyCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AngularFrequencyCalculator() {
		super.setWidth(525);
		super.setHeight(320);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("Cálculo da frequência angular");
		
		JLabel springConstantLabel = new JLabel("Valor da constante elástica da mola (N/m)");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel massLabel = new JLabel("Valor da massa (kg)");
		massLabel.setBounds(25, 100, 253, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		
		JLabel angularFrequencyLabel = new JLabel("Frequência Angular (rad/s)");
		angularFrequencyLabel.setBounds(25, 185, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		massField.setColumns(10);
		
		angularFrequencyField = new JTextField();
		angularFrequencyField.setEditable(false);
		angularFrequencyField.setBounds(327, 185, 114, 19);
		angularFrequencyField.setColumns(10);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(massLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(angularFrequencyLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(massField);
		super.calculator.getContentPane().add(angularFrequencyField);
		
		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, massField, angularFrequencyField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(angularFrequencyField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			AngularFrequencyController angularFrequencyController = new AngularFrequencyController();
			
			String result = angularFrequencyController.calculate(springConstantField, massField);
			angularFrequencyField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, super.getInvalidInputMessage(), "Erro",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, super.getEmptyInputMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
