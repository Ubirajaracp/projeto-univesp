package view;

import javax.swing.*;

import controller.PeriodController;

public class PeriodCalculator extends Calculator implements View {
	
	private JTextField springConstantField, massField, periodField;

	
	public void run() {
		try {
			PeriodCalculator window = new PeriodCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PeriodCalculator() {
		super.setWidth(525);
		super.setHeight(320);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("Período");
		
		JLabel springConstantLabel = new JLabel("Valor da constante elática da mola (N/m)");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel massLabel = new JLabel("Valor da massa (m)");
		massLabel.setBounds(25, 100, 253, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		
		JLabel periodLabel = new JLabel("Período (s)");
		periodLabel.setBounds(25, 185, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		massField.setColumns(10);
		
		periodField = new JTextField();
		periodField.setEditable(false);
		periodField.setBounds(327, 185, 114, 19);
		periodField.setColumns(10);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(massLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(periodLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(massField);
		super.calculator.getContentPane().add(periodField);

		
		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, massField, periodField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(periodField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			PeriodController periodController = new PeriodController();
			
			String result = periodController.calculate(springConstantField, massField);
			periodField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, super.getInvalidInputMessage(), "Erro",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, super.getEmptyInputMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
