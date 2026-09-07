package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public class Tiquete {

    private final Vuelo vuelo;
    private final Cliente clienteComprador;
    private final String codigo;
    private final int tarifa;
    private boolean usado;

    public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.clienteComprador = clienteComprador;
        this.tarifa = tarifa;
        this.usado = false;
    }

    public Cliente getCliente() {return clienteComprador;}

    public Vuelo getVuelo() {return vuelo;}

    public String getCodigo() {return codigo;}

    public int getTarifa() {return tarifa;}

    public void marcarComoUsado() {usado = true;}

    public boolean esUsado() {return usado;}
}
