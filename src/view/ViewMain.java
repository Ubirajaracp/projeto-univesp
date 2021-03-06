package view;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.awt.Color;

public class ViewMain implements View {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
	
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

	public ViewMain() {
		initialize();
	}

	private void initialize() {
		mainMenu = new JFrame();
		mainMenu.getContentPane().setBackground(Color.WHITE);
		mainMenu.setTitle("Movimento Harm�nico Simples");
		mainMenu.setBounds(100, 100, WIDTH, HEIGHT);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione uma op��o");
		lblNewLabel.setBounds(175, 31, 217, 15);
		mainMenu.getContentPane().add(lblNewLabel);
		
		btnForce = new JButton("C�lculo da For�a");
		btnForce.setBounds(24, 83, 200, 25);
		mainMenu.getContentPane().add(btnForce);
		btnForce.addActionListener(e -> { createCalculatorWindow("view.ForceCalculator"); });
		
		btnAcceleration = new JButton("C�lculo da acelera��o");
		btnAcceleration.setBounds(263, 83, 200, 25);
		mainMenu.getContentPane().add(btnAcceleration);
		btnAcceleration.addActionListener(e -> { createCalculatorWindow("view.AccelerationCalculator"); });
		
		btnAngularFrequency = new JButton("Frequ�ncia Angular");
		btnAngularFrequency.setBounds(263, 148, 200, 25);
		mainMenu.getContentPane().add(btnAngularFrequency);
		btnAngularFrequency.addActionListener(e -> { createCalculatorWindow("view.AngularFrequencyCalculator"); });
		
		btnShmFrequency = new JButton("Frequ�ncia para MHS");
		btnShmFrequency.setBounds(24, 148, 200, 25);
		mainMenu.getContentPane().add(btnShmFrequency);
		btnShmFrequency.addActionListener(e -> { createCalculatorWindow("view.ShmFrequencyCalculator"); });
		
		btnPeriod = new JButton("C�lculo do Per�odo");
		btnPeriod.setBounds(24, 221, 200, 25);
		mainMenu.getContentPane().add(btnPeriod);
		btnPeriod.addActionListener(e -> { createCalculatorWindow("view.PeriodCalculator"); });
		
		btnAmplitude = new JButton("C�lculo da Posi��o");
		btnAmplitude.setBounds(263, 221, 200, 25);
		mainMenu.getContentPane().add(btnAmplitude);
		btnAmplitude.addActionListener(e -> { createCalculatorWindow("view.PositionCalculator"); });
		
		btnEnergy = new JButton("C�lculo da Energia");
		btnEnergy.setBounds(24, 289, 200, 25);
		mainMenu.getContentPane().add(btnEnergy);
		btnEnergy.addActionListener(e -> { createCalculatorWindow("view.EnergyCalculator"); });
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
