
public class Carta {

	private int codi;
	private Boolean estado = false;

	public Carta(int codi) {
		this.codi = codi;
	}

	public int getCodi() {
		return codi;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
