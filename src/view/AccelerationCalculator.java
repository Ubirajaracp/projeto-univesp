package view;

import javax.swing.*;

import controller.AccelerationController;

public class AccelerationCalculator extends Calculator implements View {
	
	private JTextField springConstantField, massField, displacementField, accelerationField;

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
		super.setWidth(525);
		super.setHeight(380);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("Cálculo da aceleração");

		JLabel springConstantLabel = new JLabel("Valor da constante elástica da mola (N/m)");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel massLabel = new JLabel("Valor da massa (kg)");
		massLabel.setBounds(25, 100, 253, 15);
		
		JLabel displacementLabel = new JLabel("Valor do deslocamento (m)");
		displacementLabel.setBounds(25, 150, 229, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 200, 497, 15);
		
		JLabel accelerationLabel = new JLabel("Aceleração (m)");
		accelerationLabel.setBounds(25, 235, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		massField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 150, 114, 19);
		displacementField.setColumns(10);
		
		accelerationField = new JTextField();
		accelerationField.setEditable(false);
		accelerationField.setBounds(327, 235, 114, 19);
		accelerationField.setColumns(15);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(massLabel);
		super.calculator.getContentPane().add(displacementLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(accelerationLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(massField);
		super.calculator.getContentPane().add(displacementField);
		super.calculator.getContentPane().add(accelerationField);
		
		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, massField, displacementField, accelerationField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(accelerationField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			AccelerationController accelerationController = new AccelerationController();
			
			String result = accelerationController.calculate(springConstantField, massField, displacementField);
			accelerationField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, super.getInvalidInputMessage(), "Erro",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, super.getEmptyInputMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
