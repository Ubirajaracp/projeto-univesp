package view;

import javax.swing.*;

import controller.EnergyController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class EnergyCalculator implements View {

	private static final int WIDTH = 525;
	private static final int HEIGHT = 320;
	
	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField amplitudeField;
	private JTextField energyField;
	private JButton btnPrevious, btnCalculate, btnClearFields, btnCopyClipboard;
	private JLabel clipboardMsg;

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
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.getContentPane().setBackground(Color.WHITE);
		calculator.setTitle("C�lculo da Energia");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel springConstantLabel = new JLabel("Valor da constante el�stica da mola");
		springConstantLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(springConstantLabel);
		
		JLabel amplitudeLabel = new JLabel("Valor da Amplitude");
		amplitudeLabel.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(amplitudeLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		calculator.getContentPane().add(separator);
		
		JLabel energyLabel = new JLabel("Energia");
		energyLabel.setBounds(25, 185, 169, 15);
		calculator.getContentPane().add(energyLabel);
		
		clipboardMsg = new JLabel("Copiado para a área de transferência");
		clipboardMsg.setFont(new Font("Dialog", Font.ITALIC, 12));
		clipboardMsg.setBackground(UIManager.getColor("Button.background"));
		clipboardMsg.setBounds(145, HEIGHT-100, 236, 15);
		clipboardMsg.setVisible(false);
		calculator.getContentPane().add(clipboardMsg);
		
		springConstantField = new JTextField();
		springConstantField.setBounds(327, 50, 114, 19);
		calculator.getContentPane().add(springConstantField);
		springConstantField.setColumns(10);
		
		amplitudeField = new JTextField();
		amplitudeField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(amplitudeField);
		amplitudeField.setColumns(10);
		
		energyField = new JTextField();
		energyField.setEditable(false);
		energyField.setBounds(327, 185, 114, 19);
		calculator.getContentPane().add(energyField);
		energyField.setColumns(10);
		
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
		springConstantField.setText("");
		amplitudeField.setText("");
		energyField.setText("");
		
		clipboardMsg.setVisible(false);
	}
	
	private void copyToClipboard() {
		Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(new StringSelection(energyField.getText()),null);
		
		clipboardMsg.setVisible(true);
	}
	
	private void calculate() {
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
