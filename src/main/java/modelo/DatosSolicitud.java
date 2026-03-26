package modelo;

import java.util.Map;

public class DatosSolicitud {
	private Map<Integer, Integer> nums;
	private boolean done;
	private long tokenSolicitud;
	private String errorMessage;
	private String data;

	public DatosSolicitud() {}
	public DatosSolicitud(Map<Integer,Integer> nums) {
		this.nums = nums;
	}
	public Map<Integer, Integer> getNums(){
		return nums;
	}

	public boolean isDone() { return done; }
	public void setDone(boolean done) { this.done = done; }

	public long getTokenSolicitud() { return tokenSolicitud; }
	public void setTokenSolicitud(long tokenSolicitud) { this.tokenSolicitud = tokenSolicitud; }

	public String getErrorMessage() { return errorMessage; }
	public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
}
