/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.ClientesData;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.excepciones.ProblemasConArchivoException;
import modelo.CuentaBancaria;
import modelo.NoHayFondosExcepcion;


public class BancoUI {
    private Banco b;
    private Scanner sc;
    
    public BancoUI(){
        try{
            sc = new Scanner(System.in);
            b = new Banco();
        }catch(ProblemasConArchivoException ex){
            //no podemos continuar sino podemos leer la informacion 
            //de los clientes, terminamos la ejecucion del programa
            System.out.println("Problemas cargando informacion");
            System.out.println("Archivo: "+ex.getNombre_archivo());
            System.out.println(ex.getMessage());
            System.exit(0);//no nos podemos recuperar - detenemos 
            //la ejecucion del programa
        }
    }
    
    public void menuPrincipal(){
        String opcion="";
        do{
            mostrarPrincipal();
            System.out.println("Ingrese opcion:");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    crearCuentaBancaria();
                    break;
                case "2":
                    retirarDinero();
                    break;
                case "3":
                    retirarDinero();
                    break;
                case "4":
                    System.out.println("Salir");
                    break;
            }
        }while(!opcion.equals("4"));
    }
    
    public void mostrarPrincipal(){
        System.out.println("1. Crear cuenta bancaria"); 
        System.out.println("2. Depositar Dinero"); 
        System.out.println("3. Retirar Dinero"); 
        System.out.println("4. Salir"); 
    }
    
    public void crearCuentaBancaria(){
        System.out.println("Ingrese cedula del cliente ");
        //obtener el cliente a partir de la cedula, si el cliente no existe
        //imprima un mensaje y salga del metodo
        String cedula = sc.nextLine();
        Cliente client = b.buscarCliente(cedula);
        if(client == null){
            System.out.println("El cliente no existe");
            System.exit(0);
        }
        
        //pida el numero de cuenta
        System.out.println("Ingrese numero de cuenta");
        String numeroCuenta = sc.nextLine();
        //pida el monto inicial
        //manejamos las excepciones de tipo NumberFormatException
        boolean continuar = true;
        double monto = 0;
        do{
            try{
                System.out.println("Ingrese el monto inicial de la cuenta: ");
                monto = Double.parseDouble(sc.nextLine());
                continuar = false;
            }catch(NumberFormatException exception){
                System.out.println("Monto inicial invalido.");
            }
        } while(continuar);
        try{
            b.crearCuenta(client, numeroCuenta, monto);
            System.out.println("Cuenta creada.");
        }catch(ProblemasConArchivoException exception){
            System.out.println("No se puede agregar la cuenta.");
            System.out.println(exception.getMessage());
        }
    }

    public void depositarDinero() throws ProblemasConArchivoException{
        //pida el numero de cuenta del que quiere realiza la transaccion
        //pida el numeo de cuenta, si la cuenta no existe
        //imprima un mensaje y salga del metodo
        System.out.println("Ingrese numero de cuenta");

        
        //pida el monto a depositar
        //llame al metodo depositarDinero de Banco
        //mostrar el nuevo saldo de la cuenta
        //si se produce una excepcion de tipo IlegarlArgumentException 
        //vuelva a pedir el valor
        //si se produce una excepcion de tipo ProblemasConArchivoException,
        //muestre el mensaje de la excepcion y salga del metodo
        boolean continuar = true;
        double monto = 0;
        do{
            try{
                /*
                Realizar lo indicado arriba
                dentro del bloque
                */

                continuar = false;
            }catch(IllegalArgumentException ex){
                System.out.println("Valor incorrecto. Ingreselo nuevamente: ");
                monto = Double.parseDouble(sc.nextLine().trim());
            }catch(ProblemasConArchivoException ex){
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        } while(continuar);
    }
    
    public void retirarDinero(){
        ///pida el numeo de cuenta, si la cuenta no existe
        //imprima un mensaje y salga del metodo
        System.out.println("Ingrese numero de cuenta"); 
        /*
        No olvide usar el metodo buscar cuenta de la clase Banco sobre el objeto
        b
        */
      
        //pedir el monto a retirar
        //llame al metodo retirarDinero de Banco
        //mostrar el nuevo saldo de la cuenta
        //si se produce una excepcion de tipo IlegarlArgumentException 
        //vuelva a pedir el valor
        //si se produce una excepcion de tipo NoHayFondosExcepcion, muestre el 
        //el mensaje de la excepcion y salga del metodo
        //si se produce una excepcion de tipo ProblemasConArchivoException,
        //muestre el mensaje de la excepcion y salga del metodo
        boolean continuar = true;
        double monto = 0;
        do{
            try{
                System.out.println("Ingrese el monto a retirar");


                //System.out.println("El nuevo saldo de la cuenta es: " +(cuenta.getMonto()-monto));
                continuar = false;
            }catch(IllegalArgumentException ex){
                System.out.println("Valor incorrecto. Ingreselo nuevamente: ");
                monto = Double.parseDouble(sc.nextLine().trim());
            }catch(ProblemasConArchivoException ex){
                System.out.println(ex.getMessage());
                return;}
        } while(continuar);
    }
}