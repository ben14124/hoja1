/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dbs_jd
 */
public class Radio implements Interfaz {

	boolean ESTADO, uD;
	float Band;
	int Pos = 0;
	int Emisoras[] = new int[12];

	public void setESTADO(boolean ESTADO){
		this.ESTADO = ESTADO;
	}
	
	public boolean getEstado(){
		return ESTADO;
	}
	
	public int getAMFM(){
		return Pos;
	}
	
	public void setAMFM(int Band){
		this.Band = Band;
	}
	
	public void Sintonizar(boolean uD){
		Pos = 2;
	}
	
	public void Guardar(int Pos){
		Pos = 4;
	}
	
	public void Memoria(int Pos){
		Pos = 5;
	}

	public float getEmisora(){
		return Band;
	}

    
}
