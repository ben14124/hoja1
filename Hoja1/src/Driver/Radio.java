/*
 * Algoritmo y estructura de datos / Seccion 30
 * Hoja de trabajo 1
 * Daniela Pocasangre - 14162
 * Alejandro Rivera - 14213
 * Juan Diego Benitez - 14124
 * Programa utilizado como interface.
 */

/**
 *
 * @author Daniela, Alejandro, Juan Diego
 */
public abstract interface Radio {
	
	public void setESTADO(boolean ESTADO);
	
	public boolean getEstado();
	
	public int getAMFM();
	
	public void setAMFM(int Band);  //0 AM, 1 FM
	
	public void Sintonizar(boolean uD); //true para subir, false para bajar
	
	public void Guardar(int Pos); 
	
	public void Memoria(int Pos); 
	
	public double getEmisora();
	
}
