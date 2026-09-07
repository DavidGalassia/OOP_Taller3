package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.Collection;

public class Vuelo {
    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private Collection<Tiquete> Tiquete;

    public Vuelo(Ruta ruta, String fecha, Avion avion){
        this.fecha = fecha;
    }

    public Ruta getRuta(){return ruta;}
    public String getFecha(){return fecha;}
    public Avion getAvion(){return avion;}
    public Collection<Tiquete> getTiquetes(){return Tiquete;}

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad){
        return 0;
    }
    public boolean equals(Object obj){
        return false;
    }

}
