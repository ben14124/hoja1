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
        boolean frecuencia = true;
        Radio Alejuadiela = new Radio();
    	Scanner escaner = new Scanner(System.in);
        while (funcionamiento==0){
        	try{
        		System.out.println("Bienvenido a la Radio. Ingrese una opcion: \nEncender (1) o apagar la radio (2)");
        		int ingreso = escaner.nextInt();
                if (ingreso==1){
                    System.out.println("Que frecuencia desea seleccionar?: \nAM (1) \nFM (2) \nSalir (3)");
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
                        funcionamiento = 3;
                    }
                    System.out.println("Desea subir o bajar?: \nSubir (1) \nBajar (2) \nSalir (3)");
                    banda = escaner.nextInt();

                    if (banda==1){ //Mandamos true para subir
                        Alejuadiela.Sintonizar(true);
                    }

                    if (banda==2){ //Mandamos false para bajar
                        Alejuadiela.Sintonizar(false);
                    }
                    
                }
                else if (ingreso==2){ //Salida
                    funcionamiento = 3;
                }

        	}
        	catch (Exception e){
        		System.out.println("Por favor ingrese una opcion valida.");
        	}
        }
        System.out.println("Gracias por usar la radio.");

    }
    
}
