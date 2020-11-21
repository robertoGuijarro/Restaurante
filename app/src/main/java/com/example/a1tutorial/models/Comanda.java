package com.example.a1tutorial.models;

import java.util.ArrayList;

public class Comanda {
    String idCamarero;
    int mesa;
    ArrayList<Carta> platos;
    double precioTotal;
    boolean servido;

    public Comanda(String idCamarero, int mesa, ArrayList<Carta> platos, double precioTotal, boolean servido) {
        this.idCamarero = idCamarero;
        this.mesa = mesa;
        this.platos = platos;
        this.precioTotal = precioTotal;
        this.servido = servido;
    }

    public Comanda() {
    }

    public String getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(String idCamarero) {
        this.idCamarero = idCamarero;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Carta> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Carta> platos) {
        this.platos = platos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isServido() {
        return servido;
    }

    public void setServido(boolean servido) {
        this.servido = servido;
    }
}
