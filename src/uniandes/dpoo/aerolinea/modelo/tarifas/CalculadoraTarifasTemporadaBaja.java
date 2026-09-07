package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
    protected static final int COSTO_POR_KM_NATURAL = 600;
    protected static final int COSTO_POR_KM_CORPORATIVO = 1000;
    protected static double DESCUENTO_PEQ = 0.02;
    protected static double DESCUENTO_MEDIANAS = 0.1;
    protected static double DESCUENTO_GRANDES = 0.2;

    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        String tipoCliente = cliente.getTipoCliente();

        if (tipoCliente.equals("Natural")){
            return COSTO_POR_KM_NATURAL * calcularDistanciaVuelo(vuelo.getRuta());
        }else if (tipoCliente.equals("Corporativo")){
            return COSTO_POR_KM_CORPORATIVO * calcularDistanciaVuelo(vuelo.getRuta());
        }

        return 0;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        String tipoCliente = cliente.getTipoCliente();

        if (tipoCliente.equals("Corporativo")){
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            int tamano = corporativo.getTamanoEmpresa();

            return switch (tamano) {
                case 1 -> DESCUENTO_PEQ;
                case 2 -> DESCUENTO_MEDIANAS;
                case 3 -> DESCUENTO_GRANDES;
                default -> 0;
            };
        }
        return 0;
    }
}
