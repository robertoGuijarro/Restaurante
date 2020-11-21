package com.example.a1tutorial.models;

import java.io.Serializable;

public class Carta implements Serializable {
    String nombre;
    long precio;
    String tipo;
    String url;
    long stock;
    long unidades;

    public Carta() {
    }

    public Carta(String nombre, long precio, String tipo, String url, long stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.url = url;
        this.stock = stock;
    }

    public Carta(String nombre, long precio, long unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public long getUnidades() {
        return unidades;
    }

    public void setUnidades(long unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", url='" + url + '\'' +
                ", stock=" + stock +
                '}';
    }
}

