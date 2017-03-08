/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jenny
 */

public class TablaErrores
{
    public static boolean error = false;
    public static String tabla = "";

    public static void insertarError(String descripcion,int fila, int columna)
    {
        fila++;
        columna++;
        tabla += "<tr>\n<td>" + descripcion + "</td>";
        tabla += "<td>" + fila + "</td>";
        tabla += "<td>" + columna + "</td>\n</tr>\n";
        error = true;
    }

    public static String generarTablaErrores()
    {
        String ret= "<table border=2>\n";
        ret += "<tr>\n<th>DESCRIPCION</th><th>FILA</th><th>COLUMNA</th>\n</tr>\n";
        ret += tabla;
        tabla = "";
        ret += "</table>\n";
        return ret;
    }


}

