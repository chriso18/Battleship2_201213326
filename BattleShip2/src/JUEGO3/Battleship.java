package JUEGO3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.lang.Integer;
import java.util.Vector;
import java.net.*;

public class Battleship extends JFrame{		
	private static JButton ok = new JButton("OK"),//cierra el menu stats
						   done =new JButton("Done");//cierra el menu opciones
	private static JFrame estadisticas= new JFrame("Estadisticas"),//matiene los stats
						  opciones=new JFrame("Options");//mantiene las opciones
	private static JLabel data,//se usa para el menu de stats
						  title;//se usa para el menu de opciones
	private static JPanel stats=new JPanel(),//usado para el menu de stats
						  opts,//se usa para el menu de opciones
						  inputpanel;//usado para ingresar los barcos de forma manual
	private static Container b,c,d;//tablero y panel para ingresar los barcos
	private JPanel input;//input bar	
	private static JMenuItem m,pvp,pvc;//items del menu
	private static String[] cletras = {" ","A","B","C","D","E","F","G","H","I","J"},//array de letras para poner en el tablero
			    	        cnumeros = {" ","1","2","3","4","5","6","7","8","9","10"},//array de numeros para poner en el tablero
					        barcos = {"Carrier","Battleship","Submarine","Destroyer","Patrol Boat"},//strings usado para los barcos en el combo box
					        direccion = {"Horizontal","Vertical"},//string usado para las direcciones en el combo box
					        level={"Normal", "Ridiculously Hard"}, 
					        layout={"Manual","Automatic"},
					        colores={"Cyan", "Green", "Yellow", "Red","White"},
					        first={"Player 1", "Player 2", "Random"};//usados en las opciones
	private JComboBox cbar = new JComboBox(barcos),//barcos
					  cdir = new JComboBox(direccion);//direcciones
	private static JComboBox aiLevel=new JComboBox(level),
						     shipLayout=new JComboBox(layout),
							 shipColor=new JComboBox(colores),
							 playsFirst=new JComboBox(first);//used
					  			//for options menu
	private JTextField mbar = new JTextField();//message bar	
	private static int enemy=1,
				i,j,//counters							
				length=6,
				you=0,
				prevcolor=0,//index of previous color
				prevFirst=0,
				prevLayout=0,
				prevLevel=0,//tracks changes in corresponding comboboxes
				ready=0,
				sindex=0,//stores index of array
				dindex=0;//direction	
	private static Player players[]=new Player[2];
	private static JButton deploy=new JButton("COLOCAR");
	private static int w=0,a=0,s=0,t=0,e=0;//counters to track the use of all barcos
	private static String[][] shiphit=new String[10][10];
	private static String user,user2,user3;
	private static Color[] color={Color.cyan,Color.green,Color.yellow,Color.red,Color.white};		 	
	private static Object selectedValue=" ",
						  gametype;
	private static BattleshipClient me;
	private static boolean gameover=false;
	
	public Battleship(){	
		setTitle("BatallaNaval");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());
		setResizable(false);	
		setLocationRelativeTo(null);
		
		//gets user to input name
		user=JOptionPane.showInputDialog("Ingresa tu Nombre.");		
		
		players[you]=new Player (user);
		players[enemy]=new Player ("Computer");						
		b=getContentPane();		
		b.add(setBoard(you),BorderLayout.CENTER);			
		c=getContentPane();
		d = getContentPane();
		inputpanel=shipinput();
		d.add(inputpanel,BorderLayout.NORTH);			
		pack();		
		setVisible(true);
		
	}	
	
	public static boolean getGameOver(){
	 	return gameover;	  
	}

	public static void setGameOver(boolean b){
	 	gameover=b;	  
	}
	
	//metodo que determina quien va primero
	public void whoGoesFirst(){
		int x=0;
		if (playsFirst.getSelectedIndex()!=2){
			if (playsFirst.getSelectedIndex()!=you)
				flipYou();	
			players[playsFirst.getSelectedIndex()].getTimer().start();
			x=playsFirst.getSelectedIndex();
		}
		else{		
			int rand=(int)(Math.random()*2);					
			JOptionPane.showMessageDialog(null,players[rand].getUser()+" will "
			+"go first.","",JOptionPane.PLAIN_MESSAGE);
			if (rand!=you)
				flipYou();	
			players[rand].getTimer().start();
			x=rand;
		}
		if
		((!players[x].getUser().equals("Computer"))||(!players[x].getUser().equals("CPU1"))||(!players[x].getUser().equals("CPU2")))
			players[x].setMove(true);
	}
	
	//returns ship color, as selected by the user
	//regresa el color del barco elegido por el usuario
	public static Color getColor(){			
		return (color[shipColor.getSelectedIndex()]);	
	}
	
	//asks if two players are playing on the same computer or over the web
	//pregunta si se unira otro jugador al juego
	public static boolean isLocal(){
		if ((gametype==pvp)&&(selectedValue.equals("Local")))
				return true;
		else
			return false;
	}
	
	
	public static void flipYou(){
		if (you==1){	
			you=0;
			enemy=1;
		}
		else{
			you=1;
			enemy=0;
		}	
	}
	
	//determines whether or not is shipLayout is set to automatic
	//determina si los barcos se ponen automaticamente o no
	public static boolean isAutoSet(){
		if (shipLayout.getSelectedIndex()==0)
			return false;
		else
			return true;
	}
	
	
	//variable that determines whether or not a carrier has been placed
	//variable que determina si el carrier(cargador) se coloco
	public static int getW(){
		return w;	
	}
	
	//variable that determines whether or not a battleship has been placed
	//variable que determina si el Battleship(barco de batalla) se coloco
	public static int getA(){
		return a;	
	}
	
	//variable that determines whether or not a submarine has been placed
	//variable que determina si el submarine(submarino) se coloco
	public static int getS(){
		return s;	
	}
	
	//variable that determines whether or not a destroyer has been placed
	//variable que determina si el destroyer(destructor) se coloco
	public static int getT(){
		return t;	
	}
	
	//variable that determines whether or not a patrol boat has been placed
	//variable que determina si la patrulla se coloco
	public static int getE(){
		return e;	
	}		
	
	public static int getReady(){
		return ready;	
	}
	
	public static JFrame getestadisticas(){
		return estadisticas;	
	}
	
	public static void setData(JLabel x){
		data=x;	
	}
	
	public static JLabel getData(){
		return data;	
	}
	
	public static JPanel getStats(){
		return stats;	
	}	
	
	public static void setDeploy(boolean k){
		deploy.setEnabled(k);	
	}	
	
	public static Player getPlayers(int x){
		return players[x];	
	}
	
	public static String getDirection(int i){
		return direccion[i];	
	}
	
	public static String getCletters(int i){
		return cletras[i];	
	}	
	
	public static String getShips(int i){
		return barcos[i];	
	}
	
	public static String getCnumbers(int i){
		return cnumeros[i];	
	}	
	
	public static int getSIndex(){
		return sindex;	
	}
	
	public static int getDIndex(){
		return dindex;	
	}	
	
	public static int getYou(){
		return you;	
	}
	
	public static int getEnemy(){
		return enemy;	
	}	
	
	public static void setYou(int x){
		you=x;	
	}
	
	public static void setEnemy(int x){
		enemy=x;	
	}
	
	
	//crea el menu del juego y submenus
	public JMenuBar createMenuBar(){
		JMenu menu;//menu
      
		// crea la barra del menu
		JMenuBar menuBar = new JMenuBar();

		// construye el menu del juego
		menu = new JMenu("Juego");
		menuBar.add(menu);
		m = new JMenu("Nuevo Juego");		
		menu.add(m);
		
		//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		//submenu de Nuevo Juego
		GameListener stuff = new GameListener();
		pvp = new JMenuItem("Player vs. Player");		
		pvp.addActionListener(stuff);
		m.add(pvp);
		pvc = new JMenuItem("Player vs. Computer");
		pvc.addActionListener(stuff);
		m.add(pvc);
		
		m = new JMenuItem("Estadisticas");
		m.addActionListener(new StatsListener());		
		menu.add(m);
		m = new JMenuItem("Opciones");
		m.addActionListener(new OptionsListener());		
		menu.add(m);
		m = new JMenuItem("Salir");
		m.addActionListener(new ExitListener());
		menu.add(m);	
		return menuBar;
	}
	
	
	//crea los paneles que se usaran para colocar los barcos
	public JPanel shipinput()
	{
		input= new JPanel();
		cbar.setSelectedIndex(0);	
		cbar.addActionListener(new ShipsListener());
		TitledBorder title;//se usa para los titulos de los combo box
		title = BorderFactory.createTitledBorder("Barcos");
		cbar.setBorder(title);	
		input.add(cbar);		
		cdir.setSelectedIndex(0);	
		cdir.addActionListener(new DirectListener());	
		input.add(cdir);
		title = BorderFactory.createTitledBorder("Direccion");
		cdir.setBorder(title);		
		deploy.setEnabled(false);
		deploy.addActionListener(new DeployListener());
		input.add(deploy);
		return input;
	}	
	
	
	//crea el tablero para coloar los barcos
	public JPanel setBoard(int n){
		players[n].setMyBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;		
		for (i=0;i<11;i++){			
			for (j=0;j<11;j++){
				if ((j!=0)&&(i!=0)){					
					players[n].getBboard(i-1,j-1).addActionListener(new BoardListener());
					players[n].getMyBoard().add(players[n].getBboard(i-1,j-1));
				}				
				if (i==0){				
					if (j!=0){	
						//se usa para mostrar las filas de numeros
						k= new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else {	
						//se usa para mostrar las columnas de numeros
						k= new JTextField();
						k.setEditable(false);						
					}
					players[n].getMyBoard().add(k);
				}
				else if (j==0){	
					k= new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[n].getMyBoard().add(k);
				}				
			}
		}
		return players[n].getMyBoard();		
	}
	
	//crea el tablero y automaticamente coloca los barcos.
	public JPanel autoBoard(int u,int t) {
		players[u].setGBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;	
		if (!players[u].getUser().equals("Unknown"))
			for (i=0;i<5;i++){				
				players[u].setBoats(i,players[u].getBoats(i).compinput(i,u));
			}		
		for (i=0;i<11;i++){			
			for (j=0;j<11;j++){
				if ((j!=0)&&(i!=0)){								
					if ((players[u].getUser().equals("Computer"))||(isLocal()))						{						
						players[u].getBboard(i-1,j-1).addActionListener(new AttackListener());									
					}						
					else if
						((players[t].getUser().equals("Computer"))||(players[t].getUser().equals("CPU1"))||(players[t].getUser().equals("CPU2"))||(players[t].getUser().equals("Unknown")))	{
						if (players[u].getHitOrMiss(i-1,j-1))
							players[u].setBboard(i-1,j-1,getColor());						
					}
					else{
						players[u].getBboard(i-1,j-1).addActionListener(new InternetListener());		
					}
					players[u].getGBoard().add(players[u].getBboard(i-1,j-1));
				}				
				if (i==0){				
					if (j!=0){	
						//se usa para mostrar las filas de numeros
						k= new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else {	
						//se usa para mostrar las columnas de numeros
						k= new JTextField();
						k.setEditable(false);						
					}
					players[u].getGBoard().add(k);
				}
				else if (j==0)					{	
					k= new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[u].getGBoard().add(k);
				}				
			}			
		}
		return players[u].getGBoard();		
	}
	
	
	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//listener para escoger los barcos dentro del combo box
	private class ShipsListener implements ActionListener{	
		public void actionPerformed(ActionEvent v){				
			sindex=cbar.getSelectedIndex();
			if (players[you].getBoats(sindex)!=null)
				cdir.setSelectedIndex(players[you].getBoats(sindex).getDirect());
			switch (sindex){
				case 0:		length=6;
				break;
				case 1:		length=5;
				break;
				case 2:		length=4;	
				break;
				case 3:		length=3;
				break;
				case 4:		length=2;
				break;							
			}
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(barcos[sindex],players[you].getBoats(sindex).getDirect()
				,length,players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();			
			}							
		}
	}			
			
	//listener para elegir la direccion del barco dentro del combo box
	private class DirectListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{						
			dindex = cdir.getSelectedIndex();					
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(barcos[sindex],dindex,players[you].getBoats(sindex).getLength(),
			   	players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		   
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();		   
			}						
		}
	}				
	
	//listener para los botones en el tablero
	private class BoardListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			if (ready==0)
			{
				if (players[you].getBoats(sindex)!=null)
					players[you].getBoats(sindex).clearship();
				Object source = v.getSource();
				outer:						
				for (i=0;i<10;i++)
				{				
					for (j=0;j<10;j++)
					{
						if (source==players[you].getBboard(i,j))
						{						
							switch (sindex)
							{
								case 0:	{											
											if (w==0)
												w++;														
										}
								break;						
								case 1:	{											
											if (a==0)
												a++;														
										}
								break;
								case 2:	{								
											if (s==0)								
												s++;
										}
								break;
								case 3:	{									
											if (t==0)
												t++;													
										}
							break;
							case 4:	{								
										if (e==0)
											e++;															
									}
							break;							
						}	
						players[you].setBoats(sindex,new Ship(barcos[sindex],dindex,length,i,j));																									
						break outer;						
					}					
				}
			}			
			players[you].getBoats(sindex).placeship();
			}						
		}
    }
	
	//crea el panel que indica a quien pertenece cada tablero
	private JPanel whoseBoard()
	{
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(new JLabel(players[you].getUser()+"'s Board",SwingConstants.LEFT),BorderLayout.WEST);
		panel.add(new JLabel(players[enemy].getUser()+"'s Board",SwingConstants.RIGHT),BorderLayout.EAST);
		return panel;
	}

	//listener para la opcion de salida en el menu del juego
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int r= JOptionPane.showConfirmDialog(null,"Esta de Seguro de"
			+" Querer Salir de Battleship?", "SALIR?", JOptionPane.YES_NO_OPTION);
			if (r==0)
				System.exit(0);	
		}	
	}

	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//listener para nuevo juego en el submenu
	private class GameListener implements ActionListener{	
		public void actionPerformed(ActionEvent e){	
			int q= JOptionPane.showConfirmDialog(null,"Esta seguro de querer"
			+" Empezar un Nuevo Juego?", "Nuevo Juego?", JOptionPane.YES_NO_OPTION);
			if (q==0){					
				//resetea las variables
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
			
				if (gametype==pvp){//Jugador vs Jugador
					if (!selectedValue.equals("no server")){
						String[] possibleValues = { "Local", "Online"};
						selectedValue = JOptionPane.showInputDialog(null, 
						"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
					}
					if (!players[you].getUser().equals("CPU1")){
						if (players[you].getUser().equals("Stupid")){
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION){	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3)){				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3){
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
					if (selectedValue.equals("Online")){
						players[enemy]=new Player ("Unknown");
						if (!isAutoSet())
						{
							b.add(setBoard(you),BorderLayout.CENTER);							
							deploy.setEnabled(false);
							d.add(inputpanel,BorderLayout.NORTH);					
						}
						else{
							b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
							c.add(autoBoard(enemy,you),BorderLayout.EAST);
							ready=1;																
						}					
					}
					else{
						//le dice al usuario que ingrese su nombre
						if((players[enemy].getUser().equals("Computer"))||(players[enemy].getUser().equals("CPU2"))||(players[enemy].getUser().equals("Unknown")))
						{							
							user2=JOptionPane.showInputDialog("Enter your name.");					
							while ((user2==null)||(user2.equals(""))){				
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
				
				else if (gametype==pvc){//Jugador vs computadora						
					if (!players[you].getUser().equals("CPU1")){
						if (players[you].getUser().equals("Stupid")){
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION){	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3)){				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3){
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
					if (!isAutoSet()){
						b.add(setBoard(you),BorderLayout.CENTER);							
						deploy.setEnabled(false);
						d.add(inputpanel,BorderLayout.NORTH);					
					}
					else{
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						whoGoesFirst();	
					}
				}
				
				pack();		
				repaint();
			}									
		}	
	}	
	
	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	
	//listener para el boton ok en el menu de estadisticas
	private class OkListener implements ActionListener{	
		public void actionPerformed(ActionEvent e){	
			estadisticas.dispose();
		}	
	}
	
	//listener para el menu stats
	private class StatsListener implements ActionListener{	
		
		public void setup(){			
			stats=new JPanel();
			ok.addActionListener(new OkListener());		
			estadisticas.setSize(450,450);
			estadisticas.setResizable(false);		
			estadisticas.getContentPane().add(ok,BorderLayout.SOUTH);
			estadisticas.setLocationRelativeTo(null);
			
		}	
		
		//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		public void actionPerformed(ActionEvent e){				
			if (data==null)
				setup();
			else
				stats.removeAll();
			stats.setLayout(new GridLayout(6,3));					
			data=new JLabel("");
			stats.add(data);
			data=new JLabel("Jugador 1",SwingConstants.CENTER);
			stats.add(data);
			data=new JLabel("Jugador 2",SwingConstants.CENTER);
			stats.add(data);				
			data=new JLabel("Nombres");
			stats.add(data);
			if (you == 0){								
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Disparos Recibidos");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Golpes");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Precision");
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Barcos Restantes");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}		
			else {					
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Disparos Recibidos");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Golpes");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Precision");
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Barcos Restantes");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}
			estadisticas.getContentPane().add(stats);			
			estadisticas.pack();
			estadisticas.setVisible(true);			
		}	
	}
	
	
	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//listener para el boton de colocar los barcos
	private class DeployListener implements ActionListener{	
		public void actionPerformed(ActionEvent v){	
			int r= JOptionPane.showConfirmDialog(null,"Esta seguro de "
			+" Querer colocar sus Barcos?", "COLOCAR BARCOS?", 
			JOptionPane.YES_NO_OPTION);
			if (r==0){	
				w=0;
				a=0;
				s=0;
				t=0;
				e=0;									
				d.remove(input);						
				b.add(players[you].getMyBoard(),BorderLayout.WEST);
				ready=1;	
				c.add(autoBoard(enemy,you),BorderLayout.EAST);													
				d.add(new JPanel(),BorderLayout.CENTER);
				if (!selectedValue.equals("Online"))
					whoGoesFirst();						
				pack();
				repaint();										
			}
		}	
	}

	//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	//listener para el menu de opciones 
	public class OptionsListener implements ActionListener{	
		public void actionPerformed(ActionEvent e){		
			if (opts==null)
				setup();
			else
				opciones.setVisible(true);					
		}		

		//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		public void setup(){			
			opts=new JPanel(new GridLayout(4,2));
			title=new JLabel("Computer AI");
			opts.add(title);			
			aiLevel.setSelectedIndex(0);			
			opts.add(aiLevel);
			title=new JLabel("Ship Layout");
			opts.add(title);			
			shipLayout.setSelectedIndex(0);			
			opts.add(shipLayout);
			title=new JLabel("Ship Color");
			opts.add(title);				
			shipColor.addActionListener(new SColorListener());
			shipColor.setSelectedIndex(0);	
			opts.add(shipColor);
			title=new JLabel("Who Plays First?");
			opts.add(title);			
			playsFirst.setSelectedIndex(0);			
			opts.add(playsFirst);		
			opciones.getContentPane().add(opts,BorderLayout.CENTER);
			//opciones.setSize(600,800);
			opciones.setResizable(false);
			done.addActionListener(new DoneListener());		
			opciones.getContentPane().add(done,BorderLayout.SOUTH);
			opciones.setLocation(200,200);
			opciones.pack();
			opciones.setVisible(true);		
		}
		
		//Listener for the Colors combo box	
		//listener para el combo box de colores
		private class SColorListener implements ActionListener{	
			public void actionPerformed(ActionEvent v){	
				for (i=0;i<10;i++)
					for (j=0;j<10;j++){
						if (players[you].getBboard(i,j).getBackground()==color[prevcolor])
							players[you].setBboard(i,j,color[shipColor.getSelectedIndex()]);				
						if (players[enemy].getBboard(i,j).getBackground()
							==color[prevcolor])
							players[enemy].setBboard(i,j,color[shipColor.getSelectedIndex()]);		
					}
				prevcolor=shipColor.getSelectedIndex();	
			}
		}	
		
		//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		//listener para el boton ok en el menu de estadisticas
		private class DoneListener implements ActionListener{	
			public void actionPerformed(ActionEvent e){	
				if ((shipLayout.getSelectedIndex()!=prevLayout)||
					(aiLevel.getSelectedIndex()!=prevLevel)||
					(playsFirst.getSelectedIndex()!=prevFirst))
				{
					JOptionPane.showMessageDialog(null,"Los Cambios se Realizaran"+
					" al Comenzar un Nuevo Juego.",""
					,JOptionPane.PLAIN_MESSAGE);
					if (shipLayout.getSelectedIndex()!=prevLayout)
						prevLayout=shipLayout.getSelectedIndex();
					if (playsFirst.getSelectedIndex()!=prevFirst)
						prevFirst=playsFirst.getSelectedIndex();
					if (aiLevel.getSelectedIndex()!=prevLevel)
						prevLevel=aiLevel.getSelectedIndex();
				}
				opciones.dispose();
			}	
		}	
	}	
	
	public static BattleshipClient getClient(){
		return me;		
	}
	
	public static void main(String[] args){		
	
		Battleship gui= new Battleship();
		
		while (gui.isActive()){
			while (selectedValue.equals(" "))
				{	}
			System.out.println("Object = "+selectedValue);
			if (selectedValue.equals("Online")){	
				selectedValue=" ";
				while (ready!=1)
				{ }			
				
				try{
					me=new BattleshipClient();
					if (!me.getServerName().equals("invalid")){
						me.sendShips();
						while (!gameover){
							if (!players[you].getMove()){
								try{
									me.listen();							
								}
								catch (IOException e){ System.out.println("Aw naw."); }					
							}
							while (players[you].getMove())
								{ }
							me.results();
						}								
					}
					else{
						b.removeAll();
						c.removeAll();
						d.removeAll();
						players[you]=new Player (user);
						players[enemy]=new Player ("Computer");					
						b.add(gui.setBoard(you),BorderLayout.CENTER);					
						inputpanel=gui.shipinput();
						d.add(inputpanel,BorderLayout.NORTH);			
						gui.pack();		
						gui.repaint();
					}					
				}					
				catch (IOException e)
				{ System.out.println("You Suck"); }
			}			
		}		//System.out.println("okay");		
	}
}	
	
