package view;

import javax.swing.*;

import controller.AccelerationController;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.Font;

public class AccelerationCalculator implements View {

	private static final int WIDTH = 525;
	private static final int HEIGHT = 380;
	
	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField displacementField;
	private JTextField accelerationField;
	private JButton btnPrevious, btnCalculate, btnClearFields, btnCopyClipboard;
	private JLabel clipboardMsg;

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
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.getContentPane().setBackground(Color.WHITE);
		calculator.setTitle("C�lculo da Acelera��o");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel springConstantLabel = new JLabel("Valor da constante el�stica da mola");
		springConstantLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(springConstantLabel);
		
		JLabel massLabel = new JLabel("Valor da massa");
		massLabel.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(massLabel);
		
		JLabel displacementLabel = new JLabel("Valor do deslocamento");
		displacementLabel.setBounds(25, 150, 229, 15);
		calculator.getContentPane().add(displacementLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 200, 497, 15);
		calculator.getContentPane().add(separator);
		
		JLabel accelerationLabel = new JLabel("Acelera��o");
		accelerationLabel.setBounds(25, 235, 169, 15);
		calculator.getContentPane().add(accelerationLabel);
		
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
		
		massField = new JTextField();
		massField.setBounds(327, 100, 114, 19);
		calculator.getContentPane().add(massField);
		massField.setColumns(10);
		
		displacementField = new JTextField();
		displacementField.setBounds(327, 150, 114, 19);
		calculator.getContentPane().add(displacementField);
		displacementField.setColumns(10);
		
		accelerationField = new JTextField();
		accelerationField.setEditable(false);
		accelerationField.setBounds(327, 235, 114, 19);
		calculator.getContentPane().add(accelerationField);
		accelerationField.setColumns(15);
		
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
		massField.setText("");
		displacementField.setText("");
		accelerationField.setText("");
		
		clipboardMsg.setVisible(false);
	}
	
	private void copyToClipboard() {
		Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(new StringSelection(accelerationField.getText()),null);
		
		clipboardMsg.setVisible(true);
	}
	
	private void calculate() {
		try {
			clipboardMsg.setVisible(false);

			AccelerationController accelerationController = new AccelerationController();
			
			String result = accelerationController.calculate(springConstantField, massField, displacementField);
			accelerationField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, insira somente valores num�ricos.",
					 "Entrada inv�lida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, preencha os campos corretamente.",
					 "Entrada inv�lida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
