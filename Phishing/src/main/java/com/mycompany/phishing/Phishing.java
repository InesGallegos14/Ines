/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.phishing;


import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.HashMap;
import java.util.Map;
import java.util.List ;

    /**
 *
 * @author Pia Gallegos
 */
    public class Phishing {
    
/**
// param argumenta los argumentos de la línea de comando
*/
public static void principal ( String [ ] args ) {
 String filePath = "texto.txt" ; // Nombre del archivo a explorar

// Lista de palabras, frases y nombres de compañías frecuentes en phishing 
 String[] phishingList = { 
   "Verificación de cuenta" , "Urgente" , "Actualizar\" información" , "Problemas con tu cuenta" ,
   "Oferta especial" , "Ganador de premio" , "Confirmar tus datos" , "Caducidad de contraseña" ,
   "Ganaste un iPhone/Smartphone" , "Iniciar sesión para evitar el bloqueo" , "Cuenta suspendida" ,
   "¡Felicidades!" , "Gana dinero rápido" , "Herencia inesperada" , "Promoción exclusiva" ,
   "Oficial de seguridad" , "Aviso importante" , "Querido cliente" , "Gestión de cuenta" ,
   "Restricción de cuenta" , "Reclamar premio ahora" , "Cambio de política" , "Phishing detectado" ,
   "Comprueba esto" , "Actualizar seguridad" , "Centro de seguridad" , "Oferta de trabajo" ,
   "Aviso de pago" , "Transacción sospechosa" , "Restablecer contraseña"
};   

 
// Mapa para almacenar los términos y su frecuencia de ocurrencia
        Map<String, Integer> termFrequency = new HashMap<>(); 

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String term : phishingList) {
                    if (line.contains(term)) {
                        termFrequency.put(term, termFrequency.getOrDefault(term, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

     // Imprimir los términos y su frecuencia de ocurrencia
        for (String term : phishingList) {
            int frequency = termFrequency.getOrDefault(term, 0);
            System.out.println(term + " - Ocurrencias: " + frequency);
        }
    }
}