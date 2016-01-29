package negocio.factoria;

import java.io.IOException;

import negocio.actividades.SAActividades;
import negocio.actividades.SAActividadesImp;
import negocio.clientes.SAClientes;
import negocio.clientes.SAClientesImp;
import negocio.matriculas.SAMatriculas;
import negocio.matriculas.SAMatriculasImp;

public class FactoriaSAImp extends FactoriaSA {
	
	public SAClientes crearSAClientes() throws IOException {
		SAClientes clientes = new SAClientesImp(); 
		return clientes; 
	}

	public SAActividades crearSAActividades() throws IOException {
		SAActividades actividades = new SAActividadesImp(); 
		return actividades;
	}

	public SAMatriculas crearSAMatriculas() throws IOException {
		SAMatriculas matriculas = new SAMatriculasImp(); 
		return matriculas; 
	}
}
