
package Libreria;

public interface I_Monedero {
    int consultarSaldo();
    boolean cargar(int monto);
    int obtenerSaldoEmergenciaUtilizado();
    boolean actualizarSaldoEmergenciaUtilizado(int monto); // Verifica que este método esté declarado correctamente
    boolean actualizarSaldoAnterior();
    boolean pagar(int monto);
    boolean cambiarEstado(String estado);
}

