
package modelo;


public class CuentaBancaria {
    private String numero_cuenta;
    private double monto;
    private Cliente cliente;
    
    public CuentaBancaria(String numero_cuenta,double monto, Cliente c){
        this.numero_cuenta = numero_cuenta;
        this.monto = monto;
        this.cliente = c;
    }

    public String getNcuenta() {
        return numero_cuenta;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public void setMonto(double monto){
        this.monto = monto;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    @Override
    public String toString(){
        return numero_cuenta+" "+monto+" "+cliente.getCedula()+" "+cliente.getNombre();
    }
    
    public void depositarDinero(double cantidad){
        if(cantidad <= 0){
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        this.monto += cantidad;
    }
    
    public void retirarDinero(double cantidadDinero) throws NoHayFondosExcepcion{ 
    }
}