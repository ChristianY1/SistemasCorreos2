package chat.modelo;

import java.io.Serializable;

public class DetalleMensaje implements Serializable {
	

	private String nick;
	private String ip;
	private String mensaje;
	private int puerto;
        private int puerto2;
        private boolean multichat;

	public int getPuerto() {
		return puerto;
	}
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
        
    public int getPuerto2() {
        return puerto2;
    }

    public void setPuerto2(int puerto2) {
        this.puerto2 = puerto2;
    }

    public boolean isMultichat() {
        return multichat;
    }

    public void setMultichat(boolean multichat) {
        this.multichat = multichat;
    }

    @Override
    public String toString() {
        return "DetalleMensaje{" + "nick=" + nick + ", ip=" + ip + ", mensaje=" + mensaje + ", puerto=" + puerto + ", puerto2=" + puerto2 + ", multichat=" + multichat + '}';
    }
	
	

}
