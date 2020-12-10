
public interface Notificador {
	public void setObservador(Observador observador);
	public void removeObservador(Observador observador);
	public void notificarObservadores();
}
