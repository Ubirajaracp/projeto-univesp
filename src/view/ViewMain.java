package view;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ViewMain implements View {

	private JFrame mainMenu;
	private JButton btnForce, btnAcceleration, btnAngularFrequency, btnShmFrequency, btnPeriod, btnAmplitude, btnEnergy;


	public void run() {
		try {
			ViewMain window = new ViewMain();
			window.mainMenu.setVisible(true);
			window.mainMenu.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		btnForce.addActionListener(e -> { createCalculatorWindow("view.ForceCalculator"); });
		
		btnAcceleration = new JButton("Cálculo da Aceleração");
		btnAcceleration.setBounds(263, 83, 200, 25);
		mainMenu.getContentPane().add(btnAcceleration);
		btnAcceleration.addActionListener(e -> { createCalculatorWindow("view.AccelerationCalculator"); });
		
		btnAngularFrequency = new JButton("Frequência Angular");
		btnAngularFrequency.setBounds(263, 148, 200, 25);
		mainMenu.getContentPane().add(btnAngularFrequency);
		btnAngularFrequency.addActionListener(e -> { createCalculatorWindow("view.AngularFrequencyCalculator"); });
		
		btnShmFrequency = new JButton("Frequência para MHS");
		btnShmFrequency.setBounds(24, 148, 200, 25);
		mainMenu.getContentPane().add(btnShmFrequency);
		btnShmFrequency.addActionListener(e -> { createCalculatorWindow("view.ShmFrequencyCalculator"); });
		
		btnPeriod = new JButton("Período");
		btnPeriod.setBounds(24, 221, 150, 25);
		mainMenu.getContentPane().add(btnPeriod);
		btnPeriod.addActionListener(e -> { createCalculatorWindow("view.PeriodCalculator"); });
		
		btnAmplitude = new JButton("Amplitude");
		btnAmplitude.setBounds(263, 221, 150, 25);
		mainMenu.getContentPane().add(btnAmplitude);
		btnAmplitude.addActionListener(e -> { createCalculatorWindow("view.AmplitudeCalculator"); });
		
		btnEnergy = new JButton("Energia");
		btnEnergy.setBounds(24, 289, 117, 25);
		mainMenu.getContentPane().add(btnEnergy);
		btnEnergy.addActionListener(e -> { createCalculatorWindow("view.EnergyCalculator"); });
		
		JLabel lblNewLabel = new JLabel("Selecione uma opção");
		lblNewLabel.setBounds(151, 31, 217, 15);
		mainMenu.getContentPane().add(lblNewLabel);
	}

	private void createCalculatorWindow(String windowClassName) {
		try {
			Class<View> c = (Class<View>) Class.forName(windowClassName);
			View view = c.getDeclaredConstructor().newInstance();

			view.run();
			mainMenu.dispose();
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
