package view;

import javax.swing.*;

import controller.PositionController;

import java.awt.Color;

public class PositionCalculator implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 430;
	
	private JFrame calculator;
	private JTextField amplitudeField;
	private JTextField angularFrequencyField;
	private JTextField timeField;
	private JTextField phaseShiftField;
	private JButton btnCalculate, btnPrevious;
	private JTextField positionField;
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			PositionCalculator window = new PositionCalculator();
			window.calculator.setVisible(true);
			window.calculator.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public PositionCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calculator = new JFrame();
		calculator.getContentPane().setBackground(Color.WHITE);
		calculator.setTitle("Cálculo da Amplitude");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel amplitudeLabel = new JLabel("Valor da amplitude (m)");
		amplitudeLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(amplitudeLabel);
		
		JLabel angularFrequencyLabel = new JLabel("Valor da frequência angular (rad/s)");
		angularFrequencyLabel.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(angularFrequencyLabel);
		
		JLabel timeLabel = new JLabel("Valor do tempo (s)");
		timeLabel.setBounds(25, 150, 229, 15);
		calculator.getContentPane().add(timeLabel);
		
		JLabel phaseShiftLabel = new JLabel("Valor do ângulo de fase (rad)");
		phaseShiftLabel.setBounds(25, 200, 229, 15);
		calculator.getContentPane().add(phaseShiftLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 250, 472, 15);
		calculator.getContentPane().add(separator);
		
		JLabel positionLabel = new JLabel("Posição (m)");
		positionLabel.setBounds(25, 285, 169, 15);
		calculator.getContentPane().add(positionLabel);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
		angularFrequencyField = new JTextField();
		angularFrequencyField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(angularFrequencyField);
		angularFrequencyField.setColumns(10);
		
		timeField = new JTextField();
		timeField.setBounds(327, 150, 114, 19);
		calculator.getContentPane().add(timeField);
		timeField.setColumns(10);
		
		phaseShiftField = new JTextField();
		phaseShiftField.setBounds(327, 200, 114, 19);
		calculator.getContentPane().add(phaseShiftField);
		phaseShiftField.setColumns(10);
		
		positionField = new JTextField();
		positionField.setEditable(false);
		positionField.setBounds(327, 285, 114, 19);
		calculator.getContentPane().add(positionField);
		positionField.setColumns(10);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(250, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(100, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(e -> { redirectToMainMenu(); });

	}
	
	private void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		calculator.dispose();
	}
	
	private void calculate() {
		try {
			PositionController positionController = new PositionController();
			String result = positionController.calculate(amplitudeField, angularFrequencyField, timeField, phaseShiftField);
			
			amplitudeField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira somente valores numéricos.",
					 "Entrada inválida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Entrada inválida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
