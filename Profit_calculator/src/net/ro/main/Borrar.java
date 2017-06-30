package net.ro.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Borrar implements ActionListener
{
	JTextField[] inputs = new JTextField[4];
	
	Borrar(JTextField arriba_izq, JTextField arriba_der, JTextField abajo_izq, JTextField abajo_der)
	{
		inputs[0] = arriba_izq;
		inputs[1] = arriba_der;
		inputs[2] = abajo_izq;
		inputs[3] = abajo_der;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("Borrar");
		
		for (int i = 0; i < inputs.length; i++)
		{
			System.out.println(inputs[i].getText());
			inputs[i].setText("");
		}
	}
}