
package Libreria;

public class Monedero implements I_Monedero {
    private int numero;
    private int saldoEmergencia;
    private int saldoEmergenciaUtilizado;
    private int saldoAnterior;
    private int saldoActual;
    private String estado;

    public Monedero() {
        numero = 1;
        saldoEmergencia = 1500;
        saldoEmergenciaUtilizado = 0;
        saldoAnterior = 0;
        saldoActual = 0;
        estado = "habilitada";
    }

    @Override
    public int consultarSaldo() {
        return saldoEmergencia + saldoActual;
    }

    @Override
    public boolean cargar(int monto) {
        if (monto > 0) {
            saldoAnterior = saldoActual;
            saldoActual += monto;
            return true;
        }
        return false;
    }

    @Override
    public boolean pagar(int monto) {
        if (monto > 0 && monto <= saldoActual) {
            saldoAnterior = saldoActual;
            saldoActual -= monto;
            return true;
        }
        return false;
    }

    @Override
    public boolean cambiarEstado(String nuevoEstado) {
        if (nuevoEstado.equalsIgnoreCase("habilitada") || nuevoEstado.equalsIgnoreCase("deshabilitada")) {
            estado = nuevoEstado;
            return true;
        }
        return false;
    }

    @Override
    public int obtenerSaldoEmergenciaUtilizado() {
        return saldoEmergenciaUtilizado;
    }

    @Override
    public boolean actualizarSaldoEmergenciaUtilizado(int monto) {
        if (monto > 0 && monto <= saldoEmergencia) {
            saldoEmergenciaUtilizado += monto;
            saldoEmergencia -= monto;
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarSaldoAnterior() {
        saldoAnterior = saldoActual;
        return true;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public int getSaldoEmergencia() {
        return saldoEmergencia;
    }

    public int getSaldoAnterior() {
        return saldoAnterior;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public String getEstado() {
        return estado;
    }
}
