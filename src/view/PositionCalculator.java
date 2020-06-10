package view;

import javax.swing.*;

import controller.PositionController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class PositionCalculator implements View {

	private static final int WIDTH = 525;
	private static final int HEIGHT = 430;
	
	private JFrame calculator;
	private JTextField amplitudeField;
	private JTextField angularFrequencyField;
	private JTextField timeField;
	private JTextField phaseShiftField;
	private JTextField positionField;
	private JButton btnPrevious, btnCalculate, btnClearFields, btnCopyClipboard;
	private JLabel clipboardMsg;
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
		separator.setBounds(12, 250, 497, 15);
		calculator.getContentPane().add(separator);
		
		JLabel positionLabel = new JLabel("Posição (m)");
		positionLabel.setBounds(25, 285, 169, 15);
		calculator.getContentPane().add(positionLabel);
		
		clipboardMsg = new JLabel("Copiado para a área de transferência");
		clipboardMsg.setFont(new Font("Dialog", Font.ITALIC, 12));
		clipboardMsg.setBackground(UIManager.getColor("Button.background"));
		clipboardMsg.setBounds(145, HEIGHT-100, 236, 15);
		clipboardMsg.setVisible(false);
		calculator.getContentPane().add(clipboardMsg);
		
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
		
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(WIDTH-500, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(e -> { redirectToMainMenu(); });
		
		btnClearFields = new JButton("Limpar");
		btnClearFields.setBounds(WIDTH-375, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnClearFields);
		btnClearFields.addActionListener(e -> { clearFields(); });
		
		btnCopyClipboard = new JButton("Copiar");
		btnCopyClipboard.setBounds(WIDTH-250, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCopyClipboard);
		btnCopyClipboard.addActionListener(e -> { copyToClipboard(); });
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(WIDTH-125, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(e -> { calculate(); });
	}
	
	private void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		clipboardMsg.setVisible(false);
		calculator.dispose();
	}
	
	private void clearFields() {
		amplitudeField.setText("");
		angularFrequencyField.setText("");
		timeField.setText("");
		phaseShiftField.setText("");
		positionField.setText("");
		
		clipboardMsg.setVisible(false);
	}
	
	private void copyToClipboard() {
		Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(new StringSelection(positionField.getText()),null);
		
		clipboardMsg.setVisible(true);
	}
	
	private void calculate() {
		try {
			clipboardMsg.setVisible(false);

			PositionController positionController = new PositionController();
			
			String result = positionController.calculate(amplitudeField, angularFrequencyField, timeField, phaseShiftField);
			positionField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, insira somente valores num�ricos.",
					 "Entrada inv�lida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, preencha os campos corretamente.",
					 "Entrada inv�lida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
