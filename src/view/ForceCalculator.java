package view;

import javax.swing.*;

import controller.ForceController;

public class ForceCalculator extends Calculator implements View {

	private JTextField springConstantField, displacementField, forceField;

	public void run() {
		try {
			ForceCalculator window = new ForceCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ForceCalculator() {
		super.setWidth(525);
		super.setHeight(320);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("C�lculo da For�a");
		
		JLabel springConstantLabel = new JLabel("Valor da constante el�stica da mola");
		springConstantLabel.setBounds(25, 50, 287, 15);
		
		JLabel displacementLabel = new JLabel("Valor do deslocamento");
		displacementLabel.setBounds(25, 100, 253, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		
		JLabel forceLabel = new JLabel("For�a restauradora:");
		forceLabel.setBounds(25, 185, 169, 15);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		springConstantField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 100, 114, 19);
		displacementField.setColumns(10);
		
		forceField = new JTextField();
		forceField.setEditable(false);
		forceField.setBounds(327, 185, 114, 19);
		forceField.setColumns(10);
		
		super.calculator.getContentPane().add(springConstantLabel);
		super.calculator.getContentPane().add(displacementLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(forceLabel);
		super.calculator.getContentPane().add(springConstantField);
		super.calculator.getContentPane().add(displacementField);
		super.calculator.getContentPane().add(forceField);

		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });

	}
	
	protected void clearFields() {
		super.clearFields(springConstantField, displacementField, forceField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(forceField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			ForceController forceController = new ForceController();
			
			String result = forceController.calculate(springConstantField, displacementField);
			forceField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, insira somente valores num�ricos.",
					 "Entrada inv�lida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, preencha os campos corretamente.",
					 "Entrada inv�lida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
