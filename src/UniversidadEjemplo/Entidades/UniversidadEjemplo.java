/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo.Entidades;

import UniversidadEjemplo.AccesoADatos.Conexion;
import UniversidadEjemplo.Vistas.MenuPrincipal;

/**
 *
 * @author noelia
 */
public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion.getConexion();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        
        
        // duda con radio button sobre el estado linea 209 dentro de gestionDeAlumnos
        // revisar el try-catch de alumnoData linea 102 -107 
    }
    
}
