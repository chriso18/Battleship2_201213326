package JUEGO2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Juego extends javax.swing.JFrame implements MouseListener {
	
	 public Barco[][] tablero1 =new Barco[10][10];
     public Barco[][] tablero2 =new Barco[10][10];
     ImageIcon imagen;
     ImageIcon i=null;
     Icon icono=null;
     int cont=0, cont1=0;
     Barco barco;
     
     
     
     
     
    /** Creates new form NewJFrame */
    public Juego() {
        initComponents();
        
        this.generarTableros();
        this.Panel1.setLayout(new GridLayout(8,8));
        this.Panel2.setLayout(new GridLayout(8,8));
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2,(pantalla.height - ventana.height) / 2);
        
        
    }
    
    
    
    
    
    //Genera los tableros jLabel de 8x8
    public final void generarTableros(){
        for(int x=0;x<8;x++){
            final int fx=x;
            for(int y=0;y<8;y++){
                final int fy=y;
                tablero1[x][y]=new Barco(x,y);
                this.Panel1.add(tablero1[x][y]);
                tablero1[x][y].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
                this.tablero1[x][y].addMouseListener(new MouseAdapter(){
                
                @Override
                public void mouseClicked(MouseEvent e){
                        Barco destino=(Barco)e.getSource();
                        destino=barco;
                        
                        ImageIcon i=(ImageIcon)icono;
                        if(i!=null){
                        
                        destino.setX(fx);
                        destino.setY(fy);
                        System.out.println(" x: "+destino.x + "Y:"+destino.y);
                        ImageIcon imagen2=new ImageIcon(i.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                        destino.setIcon(imagen2);
                        }else{
                            System.out.println("Seleccione una imagen primero");
                            
                        }
                    }
                });
               
                tablero2[x][y]=new Barco(x,y);
                this.Panel2.add(tablero2[x][y]);
                tablero2[x][y].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
                this.tablero2[x][y].addMouseListener(new MouseAdapter(){
                
                @Override
                public void mouseClicked(MouseEvent e){
                       
                    
                    Barco destino=(Barco)e.getSource();
                       ImageIcon i=(ImageIcon)icono;
                       if(i!=null){
                       ImageIcon imagen2=new ImageIcon(i.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                       destino.setIcon(imagen2);
                       }else
                           System.out.println("Seleccione una imagen primero");
                       }
                });
               
            }
            
        }
        
        
    }
    
    
    //Genera la imagenes de los barcos en el tablero aleatoriamente
    public void imagenAleatorio(){
        tablero1[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/portaviones.png"));
        tablero1[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/acorazado.png"));
        tablero1[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/destructor.png"));
        tablero1[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/submarino.png"));
        
        tablero2[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/portaviones.png"));
        tablero2[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/acorazado.png"));
        tablero2[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/destructor.png"));
        tablero2[xRandom()][yRandom()].setIcon(establecerImagen("/Users/christian/Documents/Christian/PROGRAMACION/ProyectoProgra2_Battleship/src/proyectoprogra2/images/submarino.png"));
    }
    
    //funcion para limpiar el arreglo de los barcos
    private void limpiarArreglos() {
       for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                tablero1[x][y].setIcon(null);
                tablero2[x][y].setIcon(null);
            }
       }
       
    }
    
    //Funcion para agregar imagen y retornarla
    public ImageIcon establecerImagen(String path){
        String path2=path;
        URL url2 = this.getClass().getResource(path2);
        ImageIcon img2=new ImageIcon(url2);
        ImageIcon imagen2=new ImageIcon(img2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        return imagen2;
    }
    
    //retorna una posicion en X aleatoria
    public int xRandom(){
        int x;
        x=(int)(Math.random()*8);
        return x;
    }
    
    //retorna una posicion en Y aleatoria
    public int yRandom(){
        int y;
        y=(int)(Math.random()*8);
        return y;
    }
    
   


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        Panel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imagenDestructor = new javax.swing.JLabel();
        imagenSubmarino = new javax.swing.JLabel();
        ImagenAcorazado = new javax.swing.JLabel();
        imagenPortaviones = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        statusjuegotxt = new javax.swing.JLabel();
        statusjuego2txt = new javax.swing.JLabel();
        barraMenus = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuJugar = new javax.swing.JMenuItem();
        menuCargar = new javax.swing.JMenuItem();
        menuDificultad = new javax.swing.JMenuItem();
        menuJugadores = new javax.swing.JMenu();
        menuJugador1 = new javax.swing.JMenuItem();
        menuJugador2 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      

        jLabel1.setText("jLabel1");

        Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel1.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel2.setName(""); // NOI18N
        Panel2.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jButton1.setText("Muevanse");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Barcos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 2, 14), java.awt.Color.black)); // NOI18N

        imagenDestructor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenDestructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:/Users/christian/Desktop/CURSO DE JAVA 2/BattleShip2/src/JUEGO2/images/destructor.png"))); // NOI18N
        imagenDestructor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        imagenDestructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDestructorMouseClicked(evt);
            }
        });

        imagenSubmarino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenSubmarino.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:/Users/christian/Desktop/CURSO DE JAVA 2/BattleShip2/src/JUEGO2/images/submarino.png"))); // NOI18N
        imagenSubmarino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        imagenSubmarino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenSubmarinoMouseClicked(evt);
            }
        });

        ImagenAcorazado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagenAcorazado.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:/Users/christian/Desktop/CURSO DE JAVA 2/BattleShip2/src/JUEGO2/images/acorazado.png"))); // NOI18N
        ImagenAcorazado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ImagenAcorazado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImagenAcorazado.setMaximumSize(new java.awt.Dimension(60, 60));
        ImagenAcorazado.setMinimumSize(new java.awt.Dimension(60, 60));
        ImagenAcorazado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenAcorazadoMouseClicked(evt);
            }
        });

        imagenPortaviones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenPortaviones.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:/Users/christian/Desktop/CURSO DE JAVA 2/BattleShip2/src/JUEGO2/images/portaviones.png"))); // NOI18N
        imagenPortaviones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        imagenPortaviones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenPortavionesMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Acorazado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Destructor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Submarino");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Porta Aviones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPortaviones, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(imagenSubmarino, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(imagenDestructor, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(ImagenAcorazado, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImagenAcorazado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagenDestructor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagenSubmarino, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagenPortaviones, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setText("Rendirse");
        jButton2.setActionCommand("");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton3.setText("Rendirse");

        menuArchivo.setText("Archivo");

        menuJugar.setText("Jugar");
        menuArchivo.add(menuJugar);

        menuCargar.setText("Cargar Partida");
        menuArchivo.add(menuCargar);

        menuDificultad.setText("Dificultad");
        menuArchivo.add(menuDificultad);

        menuJugadores.setText("Jugadores");

        menuJugador1.setText("Jugador 1");
        menuJugadores.add(menuJugador1);

        menuJugador2.setText("Jugador 2");
        menuJugadores.add(menuJugador2);

        menuArchivo.add(menuJugadores);

        menuSalir.setText("Salir");
        menuArchivo.add(menuSalir);

        barraMenus.add(menuArchivo);

        menuEditar.setText("Editar");
        barraMenus.add(menuEditar);

        setJMenuBar(barraMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusjuegotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusjuego2txt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusjuego2txt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusjuegotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        limpiarArreglos();
        this.imagenAleatorio();
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void ImagenAcorazadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenAcorazadoMouseClicked
        this.ImagenAcorazado.setBorder(BorderFactory.createRaisedBevelBorder());
        this.imagenDestructor.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenPortaviones.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenSubmarino.setBorder(BorderFactory.createLoweredBevelBorder());
        JLabel casilla=(JLabel)evt.getSource();
        icono=casilla.getIcon();
       // barco=new Acorazado(0,0);
        icono=barco.imagen;
        
        
    }//GEN-LAST:event_ImagenAcorazadoMouseClicked

    private void imagenDestructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDestructorMouseClicked
        this.ImagenAcorazado.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenDestructor.setBorder(BorderFactory.createRaisedBevelBorder());
        this.imagenPortaviones.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenSubmarino.setBorder(BorderFactory.createLoweredBevelBorder());
        Barco casilla=(Barco)evt.getSource();
        icono=casilla.getIcon();
    }//GEN-LAST:event_imagenDestructorMouseClicked

    private void imagenSubmarinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenSubmarinoMouseClicked
        this.ImagenAcorazado.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenDestructor.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenPortaviones.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenSubmarino.setBorder(BorderFactory.createRaisedBevelBorder());
        Barco casilla=(Barco)evt.getSource();
        icono=casilla.getIcon();
    }//GEN-LAST:event_imagenSubmarinoMouseClicked

    private void imagenPortavionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenPortavionesMouseClicked
        this.ImagenAcorazado.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenDestructor.setBorder(BorderFactory.createLoweredBevelBorder());
        this.imagenPortaviones.setBorder(BorderFactory.createRaisedBevelBorder());
        this.imagenSubmarino.setBorder(BorderFactory.createLoweredBevelBorder());
        Barco casilla=(Barco)evt.getSource();
        icono=casilla.getIcon();
    }//GEN-LAST:event_imagenPortavionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

 
            public void run() {
                new Juego().setVisible(false);
                
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenAcorazado;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JMenuBar barraMenus;
    private javax.swing.JLabel imagenDestructor;
    private javax.swing.JLabel imagenPortaviones;
    private javax.swing.JLabel imagenSubmarino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    @SuppressWarnings("unused")
	private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuCargar;
    private javax.swing.JMenuItem menuDificultad;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuJugador1;
    private javax.swing.JMenuItem menuJugador2;
    private javax.swing.JMenu menuJugadores;
    private javax.swing.JMenuItem menuJugar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JLabel statusjuego2txt;
    private javax.swing.JLabel statusjuegotxt;
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent e) {
        //JLabel casilla=(JLabel)e.getSource();
        //icono=casilla.getIcon();
        //((JLabel)e.getSource()).setIcon(null);
        
            
        
    }

    public void mousePressed(MouseEvent e) {
       
        
        
    }

    public void mouseReleased(MouseEvent e) {
        
       
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
    
    
     
     
     
     
     
     
     
     
     
     
}
