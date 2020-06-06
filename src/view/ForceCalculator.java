package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class ForceCalculator implements View {

	private JFrame frmClculoDaFora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ForceCalculator window = new ForceCalculator();
			window.frmClculoDaFora.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ForceCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClculoDaFora = new JFrame();
		frmClculoDaFora.setTitle("Cálculo da Força");
		frmClculoDaFora.setBounds(100, 100, 478, 320);
		frmClculoDaFora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClculoDaFora.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(251, 235, 117, 25);
		frmClculoDaFora.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(100, 235, 117, 25);
		frmClculoDaFora.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(31, 51, 287, 15);
		frmClculoDaFora.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor do deslocamento");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		frmClculoDaFora.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(327, 49, 114, 19);
		frmClculoDaFora.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 100, 114, 19);
		frmClculoDaFora.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(327, 173, 114, 19);
		frmClculoDaFora.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Força restauradora:");
		lblNewLabel_2.setBounds(31, 175, 169, 15);
		frmClculoDaFora.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 147, 415, 15);
		frmClculoDaFora.getContentPane().add(separator);
	}
}
