package br.edu.ifg.interfaces;

import java.util.ArrayList;
import java.util.Map;

import br.edu.ifg.Aeromoca;
import br.edu.ifg.Aviao;
import br.edu.ifg.CoPiloto;
import br.edu.ifg.Piloto;

public interface IVoo {
	public void definirNumeroDoVoo();
	public void definirQuantPassageiros();
	public void definirQuantAeromocas();
	public void definirHorario();
	public Aviao definirAviao(Map<String,Aviao> avioes);
	public void criarPassageiros();
	public Piloto criarPiloto();
	public CoPiloto criarCoPiloto();
	public ArrayList<Aeromoca> criarAeromocas();
}
