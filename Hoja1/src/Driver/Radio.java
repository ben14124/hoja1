/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Daniela, Alejandro, JuanDiego
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
        boolean movimiento = true;

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
		while (sintonizacion==true){
                        movimiento = uD;
			if (uD==true){ //Si se desea subir
				System.out.println("\nIngrese 1 si desea seguir subiendo, 2 para bajar y 3 para salir. ");
				while(movimiento==true){
					subirbajar = escaner.nextInt(); //Esto va dentro del while porque hace la "pausa" en 'el (' = tilde)
					//Aqui iria un try-catch

					if(subirbajar==1){
						if(Band==0){ //Si lo que mandamos antes fue un 0...
							if(AM == 1610){
								AM = 520;
							}
							AM = AM + 10;
							System.out.println(AM);
						}

						else if (Band==1){ //Si lo que mandamos antes fue un 1...
							if(FM == 107.9000){
								FM = 87.7000;
							}
							FM = FM + 0.2000;
							System.out.println(FM);
						}
						
					} 

					else if (subirbajar==2){ //si desea bajar
						uD = false;
                                                movimiento = false;
					}

					else if (subirbajar==3){
						sintonizacion = false;
						movimiento = false;
						System.out.println("Sali");
					}

				} //Corchete del while
			}
                        
			if (uD==false){ //habria que comprobar si el uD de arriba, al pasar a false se mueve directamente a este. REMOVI ELSE
				System.out.println("\nIngrese 2 si desea seguir bajando, 1 para subir y 3 para salir. ");
				while(movimiento==false){
					subirbajar = escaner.nextInt(); //Esto va dentro del while porque hace la "pausa" en 'el (' = tilde)
					//Aqui iria un try-catch
					if (subirbajar==2){

						if(Band==0){
							if(AM == 530){
								AM = 1620;
							}
							AM = AM - 10;
							System.out.println(AM);
						}
						else if (Band==1){
							if(FM == 87.9000){
								FM = 108.1000;
							}
							FM = FM - 0.2000;
							System.out.println(FM);
						}
					}

					else if (subirbajar==1){ //si desea subir
						uD = true;
                                                movimiento = true;
					}

					else if (subirbajar==3){
						sintonizacion = false;
                                                uD = true;
                                                movimiento = true;
					}

				} //Corchete del while
			}
		} //sintonizacion
	}
	
	public void Guardar(int Pos){ //En el driver preguntamos la posicion en la que vamos a almacenar 
		
		if (Band==0){
			Emisoras[Pos-1] = AM;
		}

		else if (Band==1){
			Emisoras[Pos-1] = FM;
		}
	}
	
	public void Memoria(int Pos){
		regreso = Emisoras[Pos-1];
	}

	public double getEmisora(){
		return regreso;
	}   
}
