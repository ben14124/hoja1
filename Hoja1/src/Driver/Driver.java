/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author dbs_jd
 */
public class Driver {

    public static void main(String[] args) { //
        int banda;
        int funcionamiento = 0;
        int posicion;
        int estacion;
        Radio Alejuadiela = new Radio();
        Scanner escaner = new Scanner(System.in);
        while (funcionamiento==0){
            try{
                System.out.println("\nBienvenido a la Radio. Ingrese una opcion: \nEncender (1) o apagar la radio (2)");
                int ingreso = escaner.nextInt();
                if (ingreso==1){
                    System.out.println("\nQue frecuencia desea seleccionar?: \nAM (1) \nFM (2) \nSalir (3)");
                    banda = escaner.nextInt();
                    if (banda==1){
                        Alejuadiela.setAMFM(0); //Mandamos al objeto un 0 porque seleccionamos AM para que a la variable respectiva  
                                                //se le asigne 0
                    }

                    else if (banda==2){
                        Alejuadiela.setAMFM(1); //Mandamos al objeto un 1 porque seleccionamos FM para que a la variable respectiva
                                                //se le asigne 1
                    }
                    
                    else if (banda==3){
                        funcionamiento = 3; //se sale de la radio
                    }
                    
                    estacion = Alejuadiela.getAMFM();
                    if(estacion == 0){
                        System.out.println("La radio sintonizada es la 530.0.");
                    }
                    else if(estacion == 1){
                        System.out.println("La radio sintonizada es la 87.9.");
                    }
                    
                    //se pregunta si se desea subir o bajar la primera vez
                    System.out.println("\nDesea subir o bajar?: \nSubir (1) \nBajar (2) \nSalir (3)");
                    banda = escaner.nextInt();

                    if (banda==1){ //Mandamos true para subir
                        Alejuadiela.Sintonizar(true);
                    }

                    if (banda==2){ //Mandamos false para bajar
                        Alejuadiela.Sintonizar(false);
                    }
                    
                    System.out.println("\nDesea guardar la radio sintonizada? Si(1). No(2). Salir (3)"); //se pregunta si se desea guardar la radio sintonizada
                    posicion = escaner.nextInt();
                    
                    if(posicion == 1){ //si se desea guardar
                        System.out.println("\nEn que posicion lo desea almacenar? (1-12)"); //pregunta posicion en la que se guarda
                        posicion = escaner.nextInt();
                        
                        Alejuadiela.Guardar(posicion); //se guarda en array
                        Alejuadiela.Memoria(posicion); //se coloca en una variable la emisora almacenada en cierta posicion
                        System.out.println("\nLa emisora guardada en la posicion "+posicion+" es "+Alejuadiela.getEmisora()); //se muestra en que posicion se guardó la emisora
                    }
                    
                    else if(posicion == 2){
                        funcionamiento = 3;
                    }
                    
                    System.out.println("\nDesea observar alguna de las radios almacenadas en memoria? Si(1). No(2). Salir (3)"); //se pregunta si se desea guardar la radio sintonizada
                    posicion = escaner.nextInt();
                    
                    if(posicion == 1){ //si se desea observar
                        System.out.println("\nQue posicion desea observar? (1-12)"); //pregunta posicion en la que se guarda
                        posicion = escaner.nextInt();
                        
                        Alejuadiela.Memoria(posicion); //se coloca en una variable la emisora almacenada en cierta posicion
                        System.out.println("\nLa emisora guardada en la posicion "+posicion+" es "+Alejuadiela.getEmisora()); //se muestra en que posicion se guardó la emisora
                    }
                    
                    else if(posicion == 2){
                        funcionamiento = 3;
                    }
                    
                }
                else if (ingreso==2){ //Salida
                    funcionamiento = 3;
                }
                
            }
            catch (Exception e){
                System.out.println("Por favor ingrese una opcion valida.\n");
            }
        }
        System.out.println("\nGracias por usar la radio.");
    }
}
