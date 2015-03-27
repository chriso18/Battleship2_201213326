package JUEGO3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AttackListener implements ActionListener {
	int i,j;
	
	public void actionPerformed(ActionEvent v)
	{						
		Battleship.getPlayers(Battleship.getYou()).humanAttack(v);				
	}
}
