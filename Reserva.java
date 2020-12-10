import java.util.Date;
public class Reserva {
	private String tituloLivro;
	private Date dataReserva;
	
	public Reserva(String tituloLivro, Date dataReserva) {
		this.tituloLivro = tituloLivro;
		this.dataReserva = dataReserva;
	}
	
	public String getTituloLivro() {
		return this.tituloLivro;
	}
	
	public Date getDataReserva() {
		return this.dataReserva;
	}
	
}
