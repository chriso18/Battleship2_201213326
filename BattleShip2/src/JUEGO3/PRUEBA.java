package JUEGO3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class PRUEBA {
	public void actionPerformed(ActionEvent e)
	{	
		int q= JOptionPane.showConfirmDialog(null,"Esta seguro de querer "
		+" comenzar un nuevo juego?", "Nuevo juego?", JOptionPane.YES_NO_OPTION);
		if (q==0)
		{					
			//resets variables
			b.removeAll();
			c.removeAll();
			d.removeAll();				
			you=0;
			enemy=1;
			ready=0;
			
			if (players[you].getTimer()!=null)
				if (players[you].getTimer().isRunning())
					players[you].getTimer().stop();
			if (players[enemy].getTimer()!=null)
				if (players[enemy].getTimer().isRunning())
					players[enemy].getTimer().stop();									
			
			gametype = e.getSource();			
		
			if (gametype==pvp)
			{
				if (!selectedValue.equals("no server"))
				{
					String[] possibleValues = { "Local", "Online"};
					selectedValue = JOptionPane.showInputDialog(null, 
					"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
				}
				if (!players[you].getUser().equals("CPU1"))
				{
					if (players[you].getUser().equals("Stupid"))
					{
						int w=JOptionPane.showConfirmDialog(null,"Would you"
						+" like to try inputting your name again?","",
						JOptionPane.YES_NO_OPTION);
						if (w==JOptionPane.YES_OPTION)
						{	
							user=JOptionPane.showInputDialog("Enter your name.");
							int dummy=0;
							while (((user==null)||(user.equals("")))&&(dummy<3))
							{				
								user=JOptionPane.showInputDialog("You have to input something.");
								if ((user!=null)&&(!user.equals("")))
									dummy=4;
								else
									dummy++;
							}
							if (dummy==3)
							{
								JOptionPane.showMessageDialog(null,"Still a"
								+"cting stupid.  Oh well, we'll run with it."
								,"",JOptionPane.INFORMATION_MESSAGE);
								user="Stupid";
							}
							else
								JOptionPane.showMessageDialog(null,"That wasn't"
								+" so hard now, was it?","YEAH!",
								JOptionPane.INFORMATION_MESSAGE);									
						}							
					}
					players[you]=new Player (players[you].getUser());
				}
				else									
					players[you]=new Player (user);								
				if (selectedValue.equals("Online"))
				{
					players[enemy]=new Player ("Unknown");
					if (!isAutoSet())
					{
						b.add(setBoard(you),BorderLayout.CENTER);							
						deploy.setEnabled(false);
						d.add(inputpanel,BorderLayout.NORTH);					
					}
					else
					{
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						ready=1;																
					}					
				}
				else
				{
					//gets user to input name
					if((players[enemy].getUser().equals("Computer"))||(players[enemy].getUser().equals("CPU2"))||(players[enemy].getUser().equals("Unknown")))
					{							
						user2=JOptionPane.showInputDialog("Enter your name.");					
						while ((user2==null)||(user2.equals("")))
						{				
							user2=JOptionPane.showInputDialog("You have to input something.");							
						}						
					}
					else
						user2=players[enemy].getUser();
					players[enemy]=new Player (user2);	
					b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
					c.add(autoBoard(enemy,you),BorderLayout.EAST);
					d.add(whoseBoard(),BorderLayout.NORTH);						
					whoGoesFirst();
					ready=1;
				}
				//ready=1;
			}
			else if (gametype==pvc)//Player vs Computer
			{						
				if (!players[you].getUser().equals("CPU1"))
				{
					if (players[you].getUser().equals("Stupid"))
					{
						int w=JOptionPane.showConfirmDialog(null,"Would you"
						+" like to try inputting your name again?","",
						JOptionPane.YES_NO_OPTION);
						if (w==JOptionPane.YES_OPTION)
						{	
							user=JOptionPane.showInputDialog("Enter your name.");
							int dummy=0;
							while (((user==null)||(user.equals("")))&&(dummy<3))
							{				
								user=JOptionPane.showInputDialog("You have to input something.");
								if ((user!=null)&&(!user.equals("")))
									dummy=4;
								else
									dummy++;
							}
							if (dummy==3)
							{
								JOptionPane.showMessageDialog(null,"Still a"
								+"cting stupid.  Oh well, we'll run with it."
								,"",JOptionPane.INFORMATION_MESSAGE);
								user="Stupid";
							}
							else
								JOptionPane.showMessageDialog(null,"That wasn't"
								+" so hard now, was it?","YEAH!",
								JOptionPane.INFORMATION_MESSAGE);									
						}							
					}
					players[you]=new Player (players[you].getUser());
				}
				else									
					players[you]=new Player (user);								
				players[enemy]=new Player ("Computer");			
				if (!isAutoSet())
				{
					b.add(setBoard(you),BorderLayout.CENTER);							
					deploy.setEnabled(false);
					d.add(inputpanel,BorderLayout.NORTH);					
				}
				else
				{
					b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
					c.add(autoBoard(enemy,you),BorderLayout.EAST);
					whoGoesFirst();	
				}
			}
			else if (gametype==cvc)//Computer vs Computer
			{										
				mbar.setText("Battleship Demo");					
				mbar.setEditable(false);					
				d.add(mbar,BorderLayout.NORTH);
				players[you]=new Player ("CPU1");
				players[enemy]=new Player ("CPU2");					
				b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
				c.add(autoBoard(enemy,you),BorderLayout.EAST);					
				whoGoesFirst();		
			}				
			pack();		
			repaint();
		}									
	}
	
	public Battleship(){	
		setTitle("Batalla Naval");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());
		setResizable(false);			
		
		user=JOptionPane.showInputDialog("Ingresa Tu Nombre.");		
		players[you]=new Player (user);
		players[enemy]=new Player ("Rival");						
		b=getContentPane();		
		b.add(setBoard(you),BorderLayout.CENTER);			
		c=getContentPane();
		d = getContentPane();
		inputpanel=shipinput();
		d.add(inputpanel,BorderLayout.NORTH);			
		pack();		
		setVisible(true);	
	}	
	
	
	
	
	
	
	
	
	
	
}	

