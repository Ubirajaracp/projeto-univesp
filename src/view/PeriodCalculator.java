package view;

import javax.swing.*;

import controller.PeriodController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class PeriodCalculator implements View {

	private static final int WIDTH = 525;
	private static final int HEIGHT = 320;
	
	private JFrame calculator;
	private JTextField springConstantField;
	private JTextField massField;
	private JTextField periodField;
	private JButton btnPrevious, btnCalculate, btnClearFields, btnCopyClipboard;
	private JLabel clipboardMsg;

	
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
		initialize();
	}

	private void initialize() {
		calculator = new JFrame();
		calculator.getContentPane().setBackground(Color.WHITE);
		calculator.setTitle("Per�odo");
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
		
		JLabel springConstantLabel = new JLabel("Valor da constante el�stica da mola");
		springConstantLabel.setBounds(25, 50, 287, 15);
		calculator.getContentPane().add(springConstantLabel);
		
		JLabel massLabel = new JLabel("Valor da massa");
		massLabel.setBounds(25, 100, 253, 15);
		calculator.getContentPane().add(massLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 497, 15);
		calculator.getContentPane().add(separator);
		
		JLabel periodLabel = new JLabel("Per�odo");
		periodLabel.setBounds(25, 185, 169, 15);
		calculator.getContentPane().add(periodLabel);
		
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
		
		periodField = new JTextField();
		periodField.setEditable(false);
		periodField.setBounds(327, 185, 114, 19);
		calculator.getContentPane().add(periodField);
		periodField.setColumns(10);
		
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
		periodField.setText("");
		
		clipboardMsg.setVisible(false);
	}
	
	private void copyToClipboard() {
		Toolkit.getDefaultToolkit().getSystemClipboard()
			.setContents(new StringSelection(periodField.getText()),null);
		
		clipboardMsg.setVisible(true);
	}
	
	private void calculate() {
		try {
			clipboardMsg.setVisible(false);

			PeriodController periodController = new PeriodController();
			
			String result = periodController.calculate(springConstantField, massField);
			periodField.setText(result);
		} catch (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, insira somente valores num�ricos.",
					 "Entrada inv�lida",JOptionPane.WARNING_MESSAGE);     
		} catch (IllegalArgumentException e) {
			 JOptionPane.showMessageDialog(null, "Entrada inv�lida. Por favor, preencha os campos corretamente.",
					 "Entrada inv�lida", JOptionPane.WARNING_MESSAGE);     
		}
	}
}
