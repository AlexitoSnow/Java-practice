/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import constantes.CONSTANTES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.ProblemasConArchivoException;

public class CuentasData {
    private static String ARCHIVOCUENTAS = CONSTANTES.RUTARECURSOS+"/cuentas.txt";
    
    /**
     * Metodo que lee el archivo de cuentas bancarias y retorna un ArrayList con  
     * las cuentas bancarias en el archivo
     * @return un ArrayList de CuentaBancaria con las cuentas bancarias del cliente
     * @throws java.io.ProblemasConArchivoException
     */
    
    public static List<CuentaBancaria> obtenerCuentasBancaria() throws ProblemasConArchivoException{
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        return cuentas;
    }
    
    /**
     * Metodo que agrega una cuenta al archivo de cuentas bancarias
     * @param cuenta 
     */
    
    public static void agregarCuenta(CuentaBancaria cuenta) throws ProblemasConArchivoException{
        /*
        IMPLEMENTAR
        */
    }
    
    public static void actualizarCuentas(List<CuentaBancaria> cuentas) throws ProblemasConArchivoException{
        /*
        Recorra la lista de cuentas y escriba cada una de las cuentas en el archivo
        de cuentas bancarias sobreescribiendo el contenido anterior. 
        No olvide como se encuentra separada cada parte de las lineas en el archivo
        */
    }
}