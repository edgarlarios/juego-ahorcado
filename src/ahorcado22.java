import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.*;
//EDGAR CELESTINO LARIOS AMEZCUA
public class ahorcado22  extends JFrame implements ActionListener{

    private JButton botonBuscar, botonSalir,botonNuevo;
    private JTextField edt1,edt2;
    private JLabel lbl1,lbl2,lbl4,imagenn,imagenn1,imagenn2,
                   imagenn3,imagenn4,imagenn5,imagenn6;
    private String palabra;
    private String []lineas= new String[10];
    public int contador=0,correctas=0,intentos=0;
    private JLabel imagen,imagen1,imagen2,
                   imagen3,imagen4,imagen5,imagen6;
  
    public ahorcado22(){

      super("ahorcado");
      lbl1 = new JLabel(" palabra: ");
      lbl1.setBounds(100,20,100,20);
      lbl2 = new JLabel(" letra ");
      lbl2.setBounds(200,90,100,20);
      lbl4 = new JLabel("");
      lbl4.setBounds(140,40,200,20);
         
      edt1 = new JTextField("");
      edt1.setEditable(false);
      edt1.setBounds(170,20,200,20);
      edt2 = new JTextField("");
      edt2.setBounds(250,90,80,20);
     
      botonBuscar = new JButton("buscar");
      botonBuscar.setBounds(200,120,100,20);

      botonSalir = new JButton("salir");
      botonSalir.setBounds(200,200,100,20);

      botonNuevo = new JButton("juego nuevo");
      botonNuevo.setBounds(200,160,100,20);

      botonSalir.addActionListener(this);
      botonBuscar.addActionListener(this);
      botonNuevo.addActionListener(this);

      Icon imagenInicio= new ImageIcon("./inicio.GIF");
      imagenn=new JLabel(imagenInicio);
      imagenn.setBounds(30,110,160,170);

      Icon imagen1= new ImageIcon("./1.GIF");
      imagenn1=new JLabel(imagen1);
      imagenn1.setBounds(30,110,160,170);

      Icon imagen2= new ImageIcon("./2.GIF");
      imagenn2=new JLabel(imagen2);
      imagenn2.setBounds(30,110,160,170);

      Icon imagen3= new ImageIcon("./3.GIF");
      imagenn3=new JLabel(imagen3);
      imagenn3.setBounds(30,110,160,170);

      Icon imagen4= new ImageIcon("./4.GIF");
      imagenn4=new JLabel(imagen4);
      imagenn4.setBounds(30,110,160,170);

      Icon imagen5= new ImageIcon("./5.GIF");
      imagenn5=new JLabel(imagen5);
      imagenn5.setBounds(30,110,160,170);

      Icon imagen6= new ImageIcon("./6.GIF");
      imagenn6=new JLabel(imagen6);
      imagenn6.setBounds(30,110,160,170);

      imagenes();
      crearPalabra();

      getContentPane().add(lbl1);
      getContentPane().add(lbl2);
      getContentPane().add(lbl4);
      getContentPane().add(edt1);
      getContentPane().add(edt2);
      getContentPane().add(botonSalir);
      getContentPane().add(botonBuscar);
      getContentPane().add(botonNuevo);

      getContentPane().setLayout(null);
		setSize(400,350);
		setVisible(true);
      }
private void crearPalabra(){
      String [][] lista={{"futbol","tenis","golf","ciclismo","natacion","voleibol","hockey"},
                         {"delfin","jirafa","gato","lagartija","cocodrilo","perro","gato"},
                         {"viper","porsche","ford","ferrari","mercedes","lamborghini","macklaren"},
                         {"mochila","escritorio","guitarra","estereo","ventana","foco","botella"}};

     int categoria=(int) (Math.random()*3);
     int pala=(int)(Math.random()*7);
palabra= lista[categoria][pala];
     if(categoria==0){
           lbl4.setText("categoria deportes");
      }
     if(categoria==1){
           lbl4.setText("categoria animales");
      }
     if(categoria==2){
           lbl4.setText("categoria autos");
      }
     if(categoria==3){
           lbl4.setText("categoria objetos");
     }

      for(int j=0;j<palabra.length();j++){

        contador++;
        lineas[j]="_";
        edt1.setText(edt1.getText()+lineas[j] + " ");
     }
  }    
  private void imagenes(){

    if(intentos==0){
            imagenn.setVisible(true);}
    if(intentos==1){
            imagenn1.setVisible(true);}
    if(intentos==2){
            imagenn2.setVisible(true);}
    if(intentos==3){
            imagenn3.setVisible(true);}
    if(intentos==4){
            imagenn4.setVisible(true);}
    if(intentos==5){
            imagenn5.setVisible(true);}
    if(intentos==6){
            imagenn6.setVisible(true);}
    
     if(intentos==0){
             getContentPane().add(imagenn); }
     if(intentos==1){
             imagenn.setVisible(false);                          
             getContentPane().add(imagenn1); }
     if(intentos==2){
             imagenn1.setVisible(false);                         
             getContentPane().add(imagenn2); }
     if(intentos==3){
             imagenn2.setVisible(false);                        
             getContentPane().add(imagenn3); }
     if(intentos==4){
             imagenn3.setVisible(false);
             getContentPane().add(imagenn4); }
     if(intentos==5){
             imagenn4.setVisible(false);                       
             getContentPane().add(imagenn5);  }
     if(intentos==6){
             imagenn5.setVisible(false);                        
             getContentPane().add(imagenn6); }
   }

	public void actionPerformed(ActionEvent e){
            
            if(e.getSource().equals(botonSalir)){
                  System.exit(0);
             }
            if(e.getSource().equals(botonBuscar)){
                             
                  char letra =caracter(edt2.getText());
                  String letra2=(edt2.getText());
                  String temp=edt1.getText();
                  intentos++;

                  for(int i=0;i<palabra.length();i++){

                        if(letra==palabra.charAt(i)){
                           lineas[i]=letra2;
                           correctas++;
                           edt1.setText(null);
                           intentos=intentos-1;
                        
                              for(int j=0;j<palabra.length();j++){

                                  edt1.setText(edt1.getText()+lineas[j]+" ");
                              }
                        }
                  }
               }		                  
               imagenes();
                  
               if(correctas==contador){
                     JOptionPane.showMessageDialog(null,"a ganado!!!");
                      edt2.setEditable(false);
                }
                if(intentos==6){
                       JOptionPane.showMessageDialog(null,"a perdido!!!");
                       edt2.setEditable(false);
                }
                edt2.setText(null);
               
         if(e.getSource().equals(botonNuevo)){
              edt1.setText(null);
              contador=0;
              crearPalabra();             
              intentos=0;
              correctas=0;
              edt2.setEditable(true);

             imagenn.setVisible(true);
             imagenn1.setVisible(true);
             imagenn2.setVisible(true);
             imagenn3.setVisible(true);
             imagenn4.setVisible(true);
             imagenn5.setVisible(true);
             imagenn6.setVisible(true);
         }
    }
    public static void main(String[] args) {
      ahorcado22 x = new ahorcado22();
    }
    private char caracter(String text) {
       return text.charAt(0);
    }

    

}
