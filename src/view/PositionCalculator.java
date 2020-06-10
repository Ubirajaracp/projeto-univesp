package view;

import javax.swing.*;

import controller.PositionController;


public class PositionCalculator extends Calculator implements View {
	
	private JTextField amplitudeField, angularFrequencyField, timeField, phaseShiftField, positionField;

	public void run() {
		try {
			PositionCalculator window = new PositionCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PositionCalculator() {
		super.setWidth(525);
		super.setHeight(430);
		
		initialize();
	}

	private void initialize() {
		super.initializeComponents();
		super.calculator.setTitle("Cálculo da posição do Corpo ");

		
		JLabel amplitudeLabel = new JLabel("Valor da amplitude (m)");
		amplitudeLabel.setBounds(25, 50, 287, 15);
		
		JLabel angularFrequencyLabel = new JLabel("Valor da frequência angular (rad/s)");
		angularFrequencyLabel.setBounds(25, 100, 253, 15);
		
		JLabel timeLabel = new JLabel("Valor do tempo (s)");
		timeLabel.setBounds(25, 150, 229, 15);
		
		JLabel phaseShiftLabel = new JLabel("Valor do Ângulo de fase (rad)");
		phaseShiftLabel.setBounds(25, 200, 229, 15);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 250, 497, 15);
		
		JLabel positionLabel = new JLabel("Posição (m)");
		positionLabel.setBounds(25, 285, 169, 15);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 50, 114, 19);
		amplitudeField.setColumns(10);
		
		angularFrequencyField = new JTextField();
		angularFrequencyField.setBounds(327, 100, 114, 19);
		angularFrequencyField.setColumns(10);
		
		timeField = new JTextField();
		timeField.setBounds(327, 150, 114, 19);
		timeField.setColumns(10);
		
		phaseShiftField = new JTextField();
		phaseShiftField.setBounds(327, 200, 114, 19);
		phaseShiftField.setColumns(10);
		
		positionField = new JTextField();
		positionField.setEditable(false);
		positionField.setBounds(327, 285, 114, 19);
		positionField.setColumns(10);
		
		super.calculator.getContentPane().add(amplitudeLabel);
		super.calculator.getContentPane().add(angularFrequencyLabel);
		super.calculator.getContentPane().add(timeLabel);
		super.calculator.getContentPane().add(phaseShiftLabel);
		super.calculator.getContentPane().add(separator);
		super.calculator.getContentPane().add(positionLabel);
		super.calculator.getContentPane().add(amplitudeField);
		super.calculator.getContentPane().add(angularFrequencyField);
		super.calculator.getContentPane().add(timeField);
		super.calculator.getContentPane().add(phaseShiftField);
		super.calculator.getContentPane().add(positionField);
		
		btnClearFields.addActionListener(e -> { clearFields(); });
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
	}
	
	protected void clearFields() {
		super.clearFields(amplitudeField, angularFrequencyField, timeField, phaseShiftField, positionField);
	}
	
	protected void copyToClipboard() {
		super.copyToClipboard(positionField);
	}
	
	protected void calculate() {
		try {
			clipboardMsg.setVisible(false);

			PositionController positionController = new PositionController();
			
			String result = positionController.calculate(amplitudeField, angularFrequencyField, timeField, phaseShiftField);
			positionField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, super.getInvalidInputMessage(), "Erro",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, super.getEmptyInputMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
