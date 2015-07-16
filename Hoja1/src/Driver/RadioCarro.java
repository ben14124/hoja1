/*
 * Algoritmo y estructura de datos / Seccion 30
 * Hoja de trabajo 1
 * Daniela Pocasangre - 14162
 * Alejandro Rivera - 14213
 * Juan Diego Benitez - 14124
 * Programa que implementa la interfaz Radio.
 */

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Daniela, Alejandro, JuanDiego
 */
public class RadioCarro implements Radio {

	private boolean ESTADO = true, uD;
	private int Band = 0;
	private int Pos = 0;
	private double AM = 530;
	private double FM = 87.9;
	private double regreso; 
	private double Emisoras[] = new double[12];
	private Scanner escaner = new Scanner(System.in);
	private String ingreso;
	private int subirbajar; //Variable para pedir si se desea subir o bajar
	private boolean sintonizacion = true;
    private boolean movimiento = true;

	public void setESTADO(boolean ESTADO){
		this.ESTADO = ESTADO;
	}
	
	public boolean getEstado(){
		return ESTADO;
	}
	
	public int getAMFM(){
            return Band;
	}
	
	public void setAMFM(int Band){ //Sirve para preguntar en el driver si es AM o FM (0 y 1 respectivamente)
		this.Band = Band;
	}
	
	public void Sintonizar(boolean uD){ //uD si es AM o FM

		if (uD==true){ //Si se desea subir

			if(Band==0){ //Si lo que mandamos antes fue un 0...
				if(AM == 1610){
					AM = 520;
				}
				AM = AM + 10;
				System.out.println("\nLa emisora sintonizada es la "+AM);
                                            regreso = AM;
			}

			else if (Band==1){ //Si lo que mandamos antes fue un 1...
				if(FM >= 107.9){
					FM = 87.7;
				}
				FM = FM + 0.2;
				System.out.println("\nLa emisora sintonizada es la "+Math.round((FM)*100.0)/100.0);
                                            regreso = Math.round((FM)*100.0)/100.0;
			}
					
		}
                    
		if (uD==false){ 
			if(Band==0){
				if(AM <= 530){
					AM = 1620;
				}
				AM = AM - 10;
				System.out.println("\nLa emisora sintonizada es la "+AM);
                                            regreso = AM;
			}
			else if (Band==1){
				if(FM <= 87.9){
					FM = 108.1;
				}
				FM = FM - 0.2;
				System.out.println("\nLa emisora sintonizada es la "+Math.round((FM)*100.0)/100.0);
                                            regreso = Math.round((FM)*100.0)/100.0;
			}

		}

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
