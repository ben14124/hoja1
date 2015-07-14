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
	
	public void setAMFM(int Band);
	
	public void Sintonizar(boolean uD);
	
	public void Guardar(int Pos);
	
	public void Memoria(int Pos);
	
	public float getEmisora();
	
}
