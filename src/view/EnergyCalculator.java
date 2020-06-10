package view;

import javax.swing.*;

import controller.EnergyController;

public class EnergyCalculator extends Calculator implements View {
	
	private JTextField springConstantField, amplitudeField, energyField;

	public void run() {
		try {
			EnergyCalculator window = new EnergyCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EnergyCalculator() {
		super.setWidth(525);
		super.setHeight(320);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("C�lculo da Energia");
		
		JLabel springConstantLabel = new JLabel("Valor da constante el�stica da mola");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel amplitudeLabel = new JLabel("Valor da Amplitude");
		amplitudeLabel.setBounds(25, 100, 253, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		
		JLabel energyLabel = new JLabel("Energia");
		energyLabel.setBounds(25, 185, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 100, 114, 19);
		amplitudeField.setColumns(10);
		
		energyField = new JTextField();
		energyField.setEditable(false);
		energyField.setBounds(327, 185, 114, 19);
		energyField.setColumns(10);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(amplitudeLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(energyLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(amplitudeField);
		super.calculator.getContentPane().add(energyField);

		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, amplitudeField, energyField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(energyField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			EnergyController energyController = new EnergyController();
			
			String result = energyController.calculate(springConstantField, amplitudeField);
			energyField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, insira somente valores num�ricos.",
					 "Entrada inv�lida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, preencha os campos corretamente.",
					 "Entrada inv�lida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
