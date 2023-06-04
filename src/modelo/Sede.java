package modelo;

import java.util.ArrayList;

public class Sede {
	private String barrio;
	private double precioAlquiler;
	private Nivel nivel;
	private ArrayList<Articulo> articulos;
	private ArrayList<Clase> clases;
	private ArrayList<Clase> clasesAlmacenadas; // DB Streaming - TODO
	private ArrayList<Emplazamiento> emplazamientos;

	public Sede(String barrio, double precioAlquiler, Nivel nivel) {
		this.barrio = barrio;
		this.precioAlquiler = precioAlquiler;
		this.nivel = nivel;
	}

	public void agregarArticulo(Articulo x) {
		articulos.add(x);
	}
	
	public String getBarrio() {
		return barrio;
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public ArrayList<Clase> getClasesAlmacenadas() {
		return clasesAlmacenadas;
	}

	public ArrayList<Emplazamiento> getEmplazamientos() {
		return emplazamientos;
	}

}
