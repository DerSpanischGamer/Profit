package net.ro.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculos implements ActionListener
{
	Main_profit m;
	
	Calculos(Main_profit _m)
	{
		m = _m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
		float prim = 0;
		float prim_ = 0;
		
		float secon = 0;
		float secon_ = 0;
		
		float _final = 0;
		
		String _prim = m.prim_input.getText().toString();
		String _secon = m.second_input.getText().toString();
		
		if (!esFloat(_prim)) return;
		if (!esFloat(_secon)) return;
		
		if (m.tax_input.getText().isEmpty()) m.tax_input.setText("0");
		if (m.tax_dos_input.getText().isEmpty()) m.tax_dos_input.setText("0");
		
		try
		{
			prim = Float.parseFloat(_prim);
		} catch (NumberFormatException e)
		{
			System.out.println("Error");
			System.out.println(e);
		}
		secon = Float.valueOf(_secon);
		
		prim_ = (float) (prim * Float.valueOf(m.tax_input.getText()) * 0.01);
		secon_ = (float) (secon * Float.valueOf(m.tax_dos_input.getText()) * 0.01);
		
		System.out.println(prim);
		
		m.prim_out.setText(Float.toString(prim - prim_) + " " + "(" + Float.toString(prim_) + ")");
		m.secon_out.setText(Float.toString(secon - secon_) + " " + "(" + Float.toString(secon_) + ")");
		
		_final = secon - prim;
		
		m.final_out.setText(Float.toString(_final) + " " + "(" + Float.toString(prim_ + secon_) + ")");
	}
	
	private boolean esFloat(String t)
	{
	      try
	      {
	         Float.parseFloat(t);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
	
	private boolean esInt(String t)
	{
	      try
	      {
	         Integer.parseInt(t);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
}