/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dbs_jd
 */
public abstract interface Interfaz {
	
	public void setESTADO(boolean ESTADO);
	//
	public boolean getEstado();
	
	public int getAMFM();
	
	public void setAMFM(int Band);  //0 AM, 1 FM
	
	public void Sintonizar(boolean uD); //true para subir, false para bajar
	
	public void Guardar(int Pos);
	
	public void Memoria(int Pos);
	
	public double getEmisora();
	
}

