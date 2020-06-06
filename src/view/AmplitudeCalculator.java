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

public class AmplitudeCalculator implements View {

	private JFrame frmClculoDaAceleracao;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AmplitudeCalculator window = new AmplitudeCalculator();
			window.frmClculoDaAceleracao.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AmplitudeCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClculoDaAceleracao = new JFrame();
		frmClculoDaAceleracao.setTitle("Cálculo da Amplitude");
		frmClculoDaAceleracao.setBounds(100, 100, 478, 410);
		frmClculoDaAceleracao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClculoDaAceleracao.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(258, 336, 117, 25);
		frmClculoDaAceleracao.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(108, 336, 117, 25);
		frmClculoDaAceleracao.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Valor da constante elástica da mola");
		lblNewLabel.setBounds(31, 51, 287, 15);
		frmClculoDaAceleracao.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da massa");
		lblNewLabel_1.setBounds(31, 102, 253, 15);
		frmClculoDaAceleracao.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(327, 49, 114, 19);
		frmClculoDaAceleracao.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 100, 114, 19);
		frmClculoDaAceleracao.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(327, 282, 114, 19);
		frmClculoDaAceleracao.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amplitude");
		lblNewLabel_2.setBounds(31, 284, 169, 15);
		frmClculoDaAceleracao.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 249, 415, 15);
		frmClculoDaAceleracao.getContentPane().add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Valor do deslocamento");
		lblNewLabel_3.setBounds(31, 155, 229, 15);
		frmClculoDaAceleracao.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(327, 153, 114, 19);
		frmClculoDaAceleracao.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor do ângulo de fase");
		lblNewLabel_4.setBounds(31, 204, 229, 15);
		frmClculoDaAceleracao.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(327, 202, 114, 19);
		frmClculoDaAceleracao.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
