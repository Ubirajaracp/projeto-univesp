package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewMain implements ActionListener {

	private JFrame mainMenu;
	private JButton btnForce, btnAcceleration, btnAngularFrequency, btnShmFrequency, btnPeriod, btnAmplitude, btnEnergy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain window = new ViewMain();
					window.mainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainMenu = new JFrame();
		mainMenu.setTitle("Movimento Harmônico Simples");
		mainMenu.setBounds(100, 100, 492, 404);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(null);

		btnForce = new JButton("Cálculo da Força");
		btnForce.setBounds(24, 83, 200, 25);
		mainMenu.getContentPane().add(btnForce);
		btnForce.addActionListener(this);
		
		btnAcceleration = new JButton("Cálculo da Aceleração");
		btnAcceleration.setBounds(263, 83, 200, 25);
		mainMenu.getContentPane().add(btnAcceleration);
		btnAcceleration.addActionListener(this);
		
		btnAngularFrequency = new JButton("Frequência Angular");
		btnAngularFrequency.setBounds(263, 148, 200, 25);
		mainMenu.getContentPane().add(btnAngularFrequency);
		btnAngularFrequency.addActionListener(this);
		
		btnShmFrequency = new JButton("Frequência para MHS");
		btnShmFrequency.setBounds(24, 148, 200, 25);
		mainMenu.getContentPane().add(btnShmFrequency);
		btnShmFrequency.addActionListener(this);
		
		btnPeriod = new JButton("Período");
		btnPeriod.setBounds(24, 221, 150, 25);
		mainMenu.getContentPane().add(btnPeriod);
		btnPeriod.addActionListener(this);
		
		btnAmplitude = new JButton("Amplitude");
		btnAmplitude.setBounds(263, 221, 150, 25);
		mainMenu.getContentPane().add(btnAmplitude);
		btnAmplitude.addActionListener(this);
		
		btnEnergy = new JButton("Energia");
		btnEnergy.setBounds(24, 289, 117, 25);
		mainMenu.getContentPane().add(btnEnergy);
		btnEnergy.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Selecione uma opção");
		lblNewLabel.setBounds(151, 31, 217, 15);
		mainMenu.getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		View view = null;
		
		if (e.getSource() == btnForce) {
			view = new ForceCalculator();
		} else if (e.getSource() == btnAcceleration) {
			view = new AccelerationCalculator();
		} else if (e.getSource() == btnAngularFrequency) {
			view = new AngularFrequencyCalculator();
		} else if (e.getSource() == btnShmFrequency) {
			view = new ShmFrequencyCalculator();
		} else if (e.getSource() == btnPeriod) {
			view = new PeriodCalculator();
		} else if (e.getSource() == btnAmplitude) {
			view = new AmplitudeCalculator();
		} else if (e.getSource() == btnEnergy) {
			view = new EnergyCalculator();
		}
		
		view.run();
		mainMenu.dispose();
	}

}
