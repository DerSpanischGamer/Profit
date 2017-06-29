package net.ro.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Main_profit
{
	JFrame ventana;
	
	public JTextField prim_input;
	public JTextField second_input;
	
	public JTextField tax_input;
	public JTextField tax_dos_input;
	
	JButton calcul;
	JButton borrar;
	
	public JLabel tax_dec;
	public JLabel secon_tax_dec;
	
	JLabel prim_out_dec;
	JLabel secon_out_dec;
	JLabel final_out_dec;
	
	public JLabel prim_out;
	public JLabel secon_out;
	public JLabel final_out;
	
	JLabel prim_dec;
	JLabel secon_dec;
	
	JLabel lol;
	
    void init_ventana()
    {
        ventana = new JFrame("Ez profit calculator");
        
        ventana.setAlwaysOnTop(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setSize(1280, 720);
        
        // Inputs para los precios
        
        prim_input = new JTextField();
        
        prim_input.setLocation(50, 50);
        prim_input.setSize(500, 30);
        
        PlainDocument doc = (PlainDocument) prim_input.getDocument();
        doc.setDocumentFilter(new Filtro());

        second_input = new JTextField();
        
        second_input.setLocation(50, 150);
        second_input.setSize(500, 30);
        
        PlainDocument doc_ = (PlainDocument) second_input.getDocument();
        doc_.setDocumentFilter(new Filtro());
        
        // Inputs de impuestos
        
        tax_input = new JTextField();
        
        tax_input.setLocation(750, 50);
        tax_input.setSize(250, 30);
        
        PlainDocument doc__ = (PlainDocument) tax_input.getDocument();
        doc__.setDocumentFilter(new Filtro());

        tax_dos_input = new JTextField();
        
        tax_dos_input.setLocation(750, 150);
        tax_dos_input.setSize(250, 30);
        
        PlainDocument doc___ = (PlainDocument) tax_dos_input.getDocument();
        doc___.setDocumentFilter(new Filtro());
        
        // Botón cálculo
        
        calcul = new JButton("Calcular profit");
        
        calcul.setLocation(50, 250);
        calcul.setSize(250, 50);
        
        // Botón borrar
        
        borrar = new JButton("Borrar");
        
        borrar.setLocation(450, 250);
        borrar.setSize(250, 50);
        
        // Decoración impuestos
        
        tax_dec = new JLabel("Introduce el porcentaje del primer impuesto:");
        
        tax_dec.setLocation(750, 0);
        tax_dec.setSize(500, 50);
        
        secon_tax_dec = new JLabel("Introduce el porcentaje del segundo impuesto:");
        
        secon_tax_dec.setLocation(750, 100);
        secon_tax_dec.setSize(500, 50);
        
        // Decoración textos
        
        prim_dec = new JLabel("Introduce el primer precio:");
        
        prim_dec.setLocation(50, 0);
        prim_dec.setSize(250, 50);
        
        secon_dec = new JLabel("Introduce el segundo precio:");
        
        secon_dec.setLocation(50, 100);
        secon_dec.setSize(250, 50);
        
        // Decoración final textos
        
        prim_out_dec = new JLabel("Introduce el primer precio:");
        
        prim_out_dec.setLocation(50, 350);
        prim_out_dec.setSize(250, 50);
        
        secon_out_dec = new JLabel("Introduce el segundo precio:");
        
        secon_out_dec.setLocation(50, 375);
        secon_out_dec.setSize(250, 50);
        
        JLabel linea = new JLabel("----------------------------------------------------------------------------------------------------------");
        linea.setLocation(50, 400);
        linea.setSize(1250, 50);
        
        final_out_dec = new JLabel("Introduce el segundo precio:");
        
        final_out_dec.setLocation(50, 435);
        final_out_dec.setSize(250, 50);
        
        // Textos de salida
        
        prim_out = new JLabel("123.456");
        
        prim_out.setLocation(350, 350);
        prim_out.setSize(250, 50);
        
        secon_out = new JLabel("123.456");
        
        secon_out.setLocation(350, 375);
        secon_out.setSize(250, 50);
        
        final_out = new JLabel("123.456");
        
        final_out.setLocation(350, 435);
        final_out.setSize(250, 50);
        
        // Debuguer
        
        lol = new JLabel();
        lol.setLocation(0, 50);
        lol.setSize(250, 50);
        
        // Añadir todo a la ventana principal
        
        ventana.add(prim_input);
        ventana.add(second_input);
        
        ventana.add(tax_input);
        ventana.add(tax_dos_input);

        ventana.add(prim_dec);
        ventana.add(secon_dec);
        
        ventana.add(tax_dec);
        ventana.add(secon_tax_dec);
        
        ventana.add(prim_out_dec);
        ventana.add(secon_out_dec);
        ventana.add(linea);
        ventana.add(final_out_dec);
        
        ventana.add(prim_out);
        ventana.add(secon_out);
        ventana.add(final_out);
        
        ventana.add(calcul);
        
        ventana.add(borrar);
        
        ventana.add(lol);
        
        ventana.setVisible(true);
    }
    
    class Filtro extends DocumentFilter
    {
    	   @Override
    	   public void insertString(FilterBypass fb, int offset, String string,
    	         AttributeSet attr) throws BadLocationException
    	   {

    	      Document doc = fb.getDocument();
    	      StringBuilder sb = new StringBuilder();
    	      sb.append(doc.getText(0, doc.getLength()));
    	      sb.insert(offset, string);

    	      if (test(sb.toString()))
    	      {
    	         super.insertString(fb, offset, string, attr);
    	      } else
    	      {
    	         // warn the user and don't allow the insert
    	      }
    	   }

    	   private boolean test(String text) {
    	      try {
    	         Integer.parseInt(text);
    	         return true;
    	      } catch (NumberFormatException e) {
    	         return false;
    	      }
    	   }

    	   @Override
    	   public void replace(FilterBypass fb, int offset, int length, String text,
    	         AttributeSet attrs) throws BadLocationException {

    	      Document doc = fb.getDocument();
    	      StringBuilder sb = new StringBuilder();
    	      sb.append(doc.getText(0, doc.getLength()));
    	      sb.replace(offset, offset + length, text);

    	      if (test(sb.toString())) {
    	         super.replace(fb, offset, length, text, attrs);
    	      } else {
    	         // warn the user and don't allow the insert
    	      }

    	   }

    	   @Override
    	   public void remove(FilterBypass fb, int offset, int length)
    	         throws BadLocationException {
    	      Document doc = fb.getDocument();
    	      StringBuilder sb = new StringBuilder();
    	      sb.append(doc.getText(0, doc.getLength()));
    	      sb.delete(offset, offset + length);

    	      if (test(sb.toString())) {
    	         super.remove(fb, offset, length);
    	      } else {
    	         // warn the user and don't allow the insert
    	      }

    	   }
    }
}
