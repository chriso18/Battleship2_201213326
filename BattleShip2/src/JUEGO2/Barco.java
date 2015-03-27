package JUEGO2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Barco extends JLabel {
	protected int x;
    protected int y;
    protected int bombas;
    protected boolean hundido;
    protected ImageIcon imagen;
    
    
    public Barco(int x, int y){
        
        this.x=x;
        this.y=y;
        hundido=false;
       
        
    }
     public boolean bombardear(){
         return false;
     }

    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
