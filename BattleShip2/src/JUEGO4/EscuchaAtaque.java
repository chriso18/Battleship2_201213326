package JUEGO4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EscuchaAtaque implements ActionListener {
int i,j;
	
	public void actionPerformed(ActionEvent v)
	{						
		BatallaNaval.getPlayers(BatallaNaval.getYou()).humanAttack(v);				
	}
}
