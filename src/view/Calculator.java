package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public abstract class Calculator {

	protected int WIDTH;
	protected int HEIGHT;

	protected JFrame calculator;
	protected JButton btnPrevious, btnCalculate, btnClearFields, btnCopyClipboard;
	protected JLabel clipboardMsg;
	
	protected void initializeComponents() {
		initializeJFrame();
		initializeLabels();
		initializeButtons();
	}
	
	protected void initializeJFrame() {
		calculator = new JFrame();
		calculator.getContentPane().setBackground(Color.WHITE);
		calculator.setBounds(100, 100, WIDTH, HEIGHT);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.getContentPane().setLayout(null);
	}
	
	protected void initializeLabels() {
		clipboardMsg = new JLabel("Copiado para a área de transferência");
		clipboardMsg.setFont(new Font("Dialog", Font.ITALIC, 12));
		clipboardMsg.setBackground(UIManager.getColor("Button.background"));
		clipboardMsg.setBounds(145, HEIGHT-100, 236, 15);
		clipboardMsg.setVisible(false);
		calculator.getContentPane().add(clipboardMsg);
	}
	
	protected void initializeButtons() {
		btnPrevious = new JButton("Voltar");
		btnPrevious.setBounds(WIDTH-500, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnPrevious);
		
		btnClearFields = new JButton("Limpar");
		btnClearFields.setBounds(WIDTH-375, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnClearFields);
		
		btnCopyClipboard = new JButton("Copiar");
		btnCopyClipboard.setBounds(WIDTH-250, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCopyClipboard);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(WIDTH-125, HEIGHT-75, 100, 25);
		calculator.getContentPane().add(btnCalculate);
		
		btnPrevious.addActionListener(e -> { redirectToMainMenu(); });
		btnCalculate.addActionListener(e -> { calculate(); });
	}

	protected void redirectToMainMenu() {
		ViewMain viewMain = new ViewMain();
		viewMain.run();
		
		clipboardMsg.setVisible(false);
		calculator.dispose();
	}

	protected void clearFields(JTextField... args) {
	    for (JTextField input : args) {
	    	input.setText("");
	    }
		
		clipboardMsg.setVisible(false);
	}
	
	protected void copyToClipboard(JTextField result) {
		Toolkit.getDefaultToolkit().getSystemClipboard()
		.setContents(new StringSelection(result.getText()),null);
	
		clipboardMsg.setVisible(true);
	}
	
	protected abstract void calculate();
	
	protected void setWidth(int x) {
		this.WIDTH = x;
	}
	
	protected void setHeight(int y) {
		this.HEIGHT = y;
	}
}
