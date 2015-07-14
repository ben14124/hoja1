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
public class Radio implements Interfaz {

	boolean ESTADO, uD;
	int Band = 0;
	int Pos = 0;
	double AM = 530;
	double FM = 87.9;
	double regreso; 
	double Emisoras[] = new double[12];
	Scanner escaner = new Scanner(System.in);
	String ingreso;
	int subirbajar; //Variable para pedir si se desea subir o bajar
	boolean sintonizacion = true;

	public void setESTADO(boolean ESTADO){
		this.ESTADO = ESTADO;
	}
	
	public boolean getEstado(){
		return ESTADO;
	}
	
	public int getAMFM(){
		return Pos;
	}
	
	public void setAMFM(int Band){ //Sirve para preguntar en el driver si es AM o FM (0 y 1 respectivamente)
		this.Band = Band;
	}
	
	public void Sintonizar(boolean uD){ //uD si es AM o FM

		//-----------------------------------------------
		// YA NO ES ASI -----1 es subir y 0 bajar, 2 es guardar, cuando se llega a la estacion deseada se presiona 2 y se sale del while
		/*if (uD==true){
			System.out.println("Ingrese 1 si desea subir de estacion, 0 para bajar y 2 para guardar. ");
			try{
				Band = escaner.nextInt();
				while (Band!=2){ //try-catch aqui
					Band = escaner.nextInt();
					if (Band==1){ //hacer los ifs para los rangos
						AM = AM + 10;
					}
					else if (Band==0){
						AM = AM - 10;
					}
					else if (Band==2){

					}
				}
			}
			catch (Exception e){
				System.out.println("Por favor ingrese una opcion valida. \n Ingrese 1 si desea subir de estacion, 0 para bajar y 2 para guardar. ");
			}
			
		}*/ //-------------------------------------------

		while (sintonizacion==true){
			if (uD==true){ //Si se desea subir
				System.out.println("Ingrese 1 si desea seguir subiendo, 2 para bajar y 3 para salir. ");
				while(uD==true){
					subirbajar = escaner.nextInt(); //Esto va dentro del while porque hace la "pausa" en 'el (' = tilde)
					//Aqui iria un try-catch

					if(subirbajar==1){
						if(Band==0){ //Si lo que mandamos antes fue un 0...
							AM = AM + 10;
							System.out.println(AM);
						}

						else if (Band==1){ //Si lo que mandamos antes fue un 1...
							FM = FM + 0.2000;
							System.out.println(FM);
						}
						
					} 
					

					else if (subirbajar==2){ //si desea bajar
						uD = false;
					}

					else if (subirbajar==3){
						sintonizacion = false;
						uD = false;
						System.out.println("Sali");
					}

				} //Corchete del while

			}
			if (uD==false){ //habria que comprobar si el uD de arriba, al pasar a false se mueve directamente a este. REMOVI ELSE
				System.out.println("Ingrese 0 si desea seguir bajando, 1 para subir y 2 para salir. ");
				while(uD==false){
					subirbajar = escaner.nextInt(); //Esto va dentro del while porque hace la "pausa" en 'el (' = tilde)
					//Aqui iria un try-catch
					if (subirbajar==0){

						if(Band==0){
							AM = AM - 10;
							System.out.println(AM);
						}
						else if (Band==1){
							FM = FM - 0.2000;
							System.out.println(FM);
						}
					}

					else if (subirbajar==1){ //si desea bajar /////Habria que meterlo todo en un while
						uD = true;
					}

					else if (subirbajar==2){
						sintonizacion = false;
					}

				} //Corchete del while
			}
		} //sintonizacion



		
	}
	
	public void Guardar(int Pos){ //En el driver preguntamos la posicion en la que vamos a almacenar 
		
		if (Band==1){
			Emisoras[Pos] = AM;
		}

		else if (Band==2){
			Emisoras[Pos] = FM;
		}
	}
	
	public void Memoria(int Pos){
		regreso = Emisoras[Pos];
	}

	public double getEmisora(){
		return regreso;
	}

    
}
