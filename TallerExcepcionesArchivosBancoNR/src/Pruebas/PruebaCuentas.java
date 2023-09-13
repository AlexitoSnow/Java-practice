
package Pruebas;

import data.ClientesData;
import java.util.List;
import modelo.Cliente;
import modelo.excepciones.ProblemasConArchivoException;
import data.CuentasData;
import modelo.CuentaBancaria;


public class PruebaCuentas {
    public static void main(String[] args) throws ProblemasConArchivoException{
        //imprimir la informacion de las cuentas bancarias
        List<CuentaBancaria> cuentas = CuentasData.obtenerCuentasBancaria();
        List<Cliente> clientes = ClientesData.leerClientes();
        
        for (CuentaBancaria cuenta: cuentas){
            System.out.println(cuenta.toString());
        }
        
        boolean clienteEsta = false;
        Cliente clienteNuevo = new Cliente("elias hernandez","1765568938");
        for(Cliente client: clientes){
            if(client.getCedula().equals("1765568938")){
                clienteEsta = true;
            }
        }
        if(!clienteEsta){
            clientes.add(clienteNuevo);
            ClientesData.agregarCliente(clienteNuevo);
            CuentaBancaria cuentaNueva = new CuentaBancaria("1125",10000,clienteNuevo);
            cuentas.add(cuentaNueva);
            CuentasData.agregarCuenta(cuentaNueva);
        }
        
        for(CuentaBancaria cuenta : cuentas){
            if(cuenta.getNcuenta().equals("1111")){
                cuenta.setMonto(10000);
            }
        }
        
        CuentasData.actualizarCuentas(cuentas);
    }
}