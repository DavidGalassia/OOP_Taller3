package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
    public static final double IMPUESTO = 0.28;
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    public int calcularTarifa(Vuelo vuelo, Cliente cliente){
        int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        return (int) (costoBase * (1 - porcentajeDescuento));
    }

    protected int calcularDistanciaVuelo(Ruta ruta){
        Aeropuerto AeropuertoOrigen = ruta.getOrigen();
        Aeropuerto AeropuertoDestino = ruta.getDestino();

        int distancia = Aeropuerto.calcularDistancia(AeropuertoOrigen, AeropuertoDestino);

        return distancia;
    }
    protected int calcularValorImpuestos(int costoBase){
        return (int) (costoBase * IMPUESTO);
    }

}
