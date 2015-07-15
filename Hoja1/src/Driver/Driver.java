/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author Daniela, Alejandro, Juan Diego
 */
public class Driver {

    public static void main(String[] args) { //
        int banda;
        int funcionamiento = 0;
        int posicion;
        int estacion;
        boolean ESTADO=true;
        int ingreso=0; banda=0; posicion = 0;
        
        Radio Alejuadiela = new RadioCarro();
        
        while (funcionamiento==0){
            //try{
                System.out.println("\nBienvenido a la Radio. Ingrese una opcion: \nEncender (1) o apagar la radio (2)");
               boolean try1 = true;
                while (try1==true){
                    try {
                        Scanner escaner = new Scanner(System.in);
                        ingreso = escaner.nextInt();
                        try1=false;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Por favor ingrese una opcion valida. \n");
                    }
                }
                if (ingreso==1){
                    Alejuadiela.setESTADO(ESTADO);
                    while (ingreso==1){

                        System.out.println("\nQue frecuencia desea seleccionar?: \nAM (1) \nFM (2) \nSalir (3)");
                        boolean try2 = true;
                        while (try2==true){
                            try {
                            Scanner escanerbanda = new Scanner(System.in);
                            banda = escanerbanda.nextInt();
                            try2=false;
                            }
                             catch (InputMismatchException e){
                                 System.out.println("Por favor ingrese una opcion valida.\n");
                            }
                        }
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
                            ingreso = 2; //salida
                        }
                        if (ingreso==1){
                            estacion = Alejuadiela.getAMFM();
                            if(estacion == 0){
                                System.out.println("La radio sintonizada es la 530.0.");
                            }
                            else if(estacion == 1){
                                System.out.println("La radio sintonizada es la 87.9.");
                            }
                            
                            //se pregunta si se desea subir o bajar la primera vez
                            System.out.println("\nDesea subir o bajar?: \nSubir (1) \nBajar (2) \nSalir (3)");
                            boolean try3 = true;
                            while (try3==true){  
                                try {
                                    Scanner escanerbanda2 = new Scanner(System.in);
                                    banda = escanerbanda2.nextInt();
                                    try3 = false;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Por favor ingrese una opcion valida.\n");
                                }
                            }
                            while (banda!=3){
                                if (banda==1){ //Mandamos true para subir
                                    System.out.println("\nIngrese 1 si desea seguir subiendo, 2 para bajar y 3 para salir. ");
                                    while (banda==1){
                                        boolean try4 = true;
                                        while (try4==true){
                                            try{
                                                Scanner escanerbanda3 = new Scanner(System.in);
                                                banda = escanerbanda3.nextInt();
                                                Alejuadiela.Sintonizar(true);
                                                try4 = false;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("Por favor ingrese una opcion valida.\n");
                                            }
                                        }
                                        
                                    }
                                }

                                if (banda==2){ //Mandamos false para bajar
                                    System.out.println("\nIngrese 2 si desea seguir bajando, 1 para subir y 3 para salir. ");
                                    while (banda==2){
                                        Alejuadiela.Sintonizar(false);
                                        boolean try5 = true;
                                        while (try5==true){
                                            try{
                                                Scanner escanerbanda4 = new Scanner(System.in);
                                                banda = escanerbanda4.nextInt();
                                                try5 = false;
                                            }
                                            catch (InputMismatchException e){
                                                System.out.println("Por favor ingrese una opcion valida.\n");
                                            }
                                        }
                                    }
                                }
                                if (banda==3){
                                    funcionamiento = 3;
                                    ingreso = 2; //salida
                                }
                            }
                            
                            System.out.println("La radio sintonizada es la "+Alejuadiela.getEmisora());
                            
                            System.out.println("\nDesea guardar la radio sintonizada? Si(1). No(2). Salir (3)"); //se pregunta si se desea guardar la radio sintonizada
                            boolean try6 = true;
                            while (try6==true){
                                try {
                                    Scanner escanerposicion = new Scanner(System.in);
                                    posicion = escanerposicion.nextInt();
                                    try6 = false;
                                }
                                catch (InputMismatchException e){
                                    System.out.println("Por favor ingrese una opcion valida.\n");
                                }
                            }
                            
                            if(posicion == 1){ //si se desea guardar
                                System.out.println("\nEn que posicion lo desea almacenar? (1-12)"); //pregunta posicion en la que se guarda
                                boolean try7 = true;
                                while (try7==true){
                                    try {
                                        Scanner escanerposicion2 = new Scanner(System.in);
                                        posicion = escanerposicion2.nextInt();
                                        try7 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Por favor ingrese una opcion valida.\n");
                                    }
                                }
                                
                                Alejuadiela.Guardar(posicion); //se guarda en array
                                Alejuadiela.Memoria(posicion); //se coloca en una variable la emisora almacenada en cierta posicion
                                System.out.println("\nLa emisora guardada en la posicion "+posicion+" es "+Alejuadiela.getEmisora()); //se muestra en que posicion se guardó la emisora
                            }
                            
                            else if(posicion == 2){
                                funcionamiento = 0;
                            }
                            
                            System.out.println("\nDesea observar alguna de las radios almacenadas en memoria? Si(1). No(2). Salir (3)"); //se pregunta si se desea guardar la radio sintonizada
                            boolean try8 = true;
                            while (try8==true){
                                try {
                                    Scanner escanerposicion3 = new Scanner(System.in);
                                    posicion = escanerposicion3.nextInt();
                                    try8 = false;
                                }
                                catch (InputMismatchException e) {
                                    System.out.println("Por favor ingrese una opcion valida.\n");

                                }
                            }
                            
                            if(posicion == 1){ //si se desea observar
                                System.out.println("\nQue posicion desea observar? (1-12)"); //pregunta posicion en la que se guarda
                                boolean try9 = true;
                                while (try9==true){
                                    try {
                                        Scanner escanerposicion4 = new Scanner(System.in);
                                        posicion = escanerposicion4.nextInt();
                                        try9 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Por favor ingrese una opcion valida.\n");

                                    }
                                }
                                
                                Alejuadiela.Memoria(posicion); //se coloca en una variable la emisora almacenada en cierta posicion
                                System.out.println("\nLa emisora guardada en la posicion "+posicion+" es "+Alejuadiela.getEmisora()); //se muestra en que posicion se guardó la emisora
                                ingreso = 1;
                            }
                            
                            else if(posicion == 3){
                                funcionamiento = 3;
                                ingreso=2; //salida
                            }
                        } //If de segundo ingreso
                    } //While ingreso==1
                } //If de ingreso==1
                else if (ingreso==2){ //Salida
                    ESTADO = false;
                    Alejuadiela.setESTADO(ESTADO);
                    funcionamiento = 3;
                }

        }
        System.out.println("\nGracias por usar la radio.");
    }
}
