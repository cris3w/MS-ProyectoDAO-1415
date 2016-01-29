package negocio.actividades;

public class TransferActividad {

	private int id;
	private String nombre;
	private String diaSemana;
	private int aforo;
	private int activo;
	private int matriculados;
	
	public TransferActividad() {
		this.id = 0;
		this.nombre = "";
		this.diaSemana = "";
		this.aforo = 0;
		this.activo = 0;
	}
	
	public TransferActividad(int id, String nombre, String diaSemana, int aforo, int activo, int matriculados) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDiaSemana(diaSemana); 
		this.setAforo(aforo);
		this.setActivo(activo);
		this.setMatriculados(matriculados);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDiaSemana() {
		return this.diaSemana;
	}
	
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getAforo() {
		return this.aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public boolean isActivo() {
		if (activo == 1) return true;
		else return false;
	}
	
	public int getMatriculados() {
		return this.matriculados;
	}
	
	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}
	
	public boolean isCompleta() {
		return this.matriculados >= this.aforo;
	}
}
