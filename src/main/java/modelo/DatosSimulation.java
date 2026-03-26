package modelo;

import java.util.*;

public class DatosSimulation {
	public DatosSimulation() {}
	
	private int maxSegundos;
	private int anchoTablero;
	private Map<Integer,List<Punto>> puntos;

	public static DatosSimulation desdeString(String rawData) {
		DatosSimulation ds = new DatosSimulation();
		Map<Integer, List<Punto>> puntosMap = new HashMap<>();
		String[] lineas = rawData.split("\n");
		// Primera línea: ancho
		int ancho = Integer.parseInt(lineas[0].trim());
		ds.setAnchoTablero(ancho);
		int maxT = 0;
		for (int i = 1; i < lineas.length; i++) {
			String[] partes = lineas[i].split(",");
			if (partes.length == 4) {
				int t = Integer.parseInt(partes[0].trim());
				Punto p = new Punto();
				p.setX(Integer.parseInt(partes[1].trim()));
				p.setY(Integer.parseInt(partes[2].trim()));
				p.setColor(partes[3].trim());
				puntosMap
						.computeIfAbsent(t, k -> new ArrayList<>())
						.add(p);
				if (t > maxT) maxT = t;
			}
		}
		ds.setMaxSegundos(maxT + 1);
		ds.setPuntos(puntosMap);
		return ds;
	}
	public int getMaxSegundos() {
		return maxSegundos;
	}
	
	public void setMaxSegundos(int s) {
		this.maxSegundos = s;
	}
	
	public int getAnchoTablero() {
		return anchoTablero;
	}
	
	public void setAnchoTablero(int s) {
		this.anchoTablero = s;
	}
	
	public Map<Integer,List<Punto>> getPuntos(){
		return puntos;
	}
	
	public void setPuntos(Map<Integer,List<Punto>> s) {
		this.puntos = s;
	}
}
