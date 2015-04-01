package JUEGO3;

import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame  {

	private Container contenedor;/**declaramos el contenedor*/
	JButton botonJugar,botonSalir;/**declaramos el objeto Boton*/
	JLabel labelTitulo;/**declaramos el objeto Label*/
	private Menu miMenu;
	public ImageIcon icono;
	Panel miPanel;
	
	public Menu(){
		  /**permite iniciar las propiedades de los componentes*/
		  iniciarComponentes();
		  /**Asigna un titulo a la barra de titulo*/
		  setTitle("Menu");
		  /**tamaño de la ventana*/
		  setSize(300,200);
		  /**pone la ventana en el Centro de la pantalla*/
		  setLocationRelativeTo(null);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
 	
	/**
	 * @param miVentana
	 * Enviamos una instancia de la ventana principal
	 */
	public void setMenu(Menu miMenu) {
	   miMenu=miMenu;
	}
	
	private void iniciarComponentes() {
		
		  contenedor=getContentPane();/**instanciamos el contenedor*/
		  /**con esto definmos nosotros mismos los tamaños y posicion
		   * de los componentes*/
		  contenedor.setLayout(null);
		
		  /**Propiedades del boton, lo instanciamos, posicionamos y
		   * activamos los eventos*/
		  botonJugar= new JButton();
		  botonJugar.setText("Jugar");
		  botonJugar.setBounds(50, 80, 80, 23);
		  botonJugar.addActionListener(new JugarListener());
		  botonSalir = new JButton();
		  botonSalir.setText("Salir");
		  botonSalir.setBounds(140, 80, 80, 23);//mueve el boton de izquierda a derecha //mueve el boton hacia arriba o abajo //expande el tamaño del boton horizontalmente //expande el tamaño del botn verticalmente
		  botonSalir.addActionListener(new ExitListener());  
		  
		  /**Propiedades del Label, lo instanciamos, posicionamos y
		   * activamos los eventos*/
		  labelTitulo= new JLabel();
		  labelTitulo.setText("BIENVENIDO A BATALLANAVAL");
		  labelTitulo.setBounds(50, 10, 180, 23);
		   
		  /**Agregamos los componentes al Contenedor*/
		  contenedor.add(labelTitulo);
		  contenedor.add(botonJugar);
		  contenedor.add(botonSalir);

		 }

	
	 /*Agregamos el evento al momento de llamar la otra ventana*/
	  private class JugarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==botonJugar){
				 /*enviamos la instancia de la ventana principal para que
		          * esta sea Padre de la ventana de dialogo*/
				   Battleship miBatallaNaval=new Battleship(/*miMenu,false*/);
				   miBatallaNaval.setVisible(true);
				   miBatallaNaval.setLocationRelativeTo(null);
				   miBatallaNaval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		  }
		}
	
	
	
	 /*Agregamos el evento al momento de llamar la otra ventana*/
	  private class ExitListener implements ActionListener{
		  public void actionPerformed(ActionEvent e)
			{
				int salir= JOptionPane.showConfirmDialog(null,"Estas Seguro de "
				+" Querer Abandonar el Juego?", "Salir?", JOptionPane.YES_NO_OPTION);
				if (salir==0)
					System.exit(0);	
			}	
	  }
	
	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Declaramos el objeto*/
		 Menu miMenu;
		 /*Instanciamos el objeto*/
		 miMenu= new Menu();
		 /*Enviamos el objeto como parametro para que sea unico
		  * en toda la aplicación*/
		  miMenu.setMenu(miMenu);
		 /*Hacemos que se cargue la ventana*/
		  miMenu.setVisible(true);
		  }
	}


