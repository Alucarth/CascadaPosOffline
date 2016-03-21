/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.http;

import com.mobiwire.startup.StartApp;
import java.io.IOException;

/**
 *
 * @author David
 */
public class RestProductor extends Thread
{
    StartApp startApp;
    BufferRest bufferRest;
    int consultaHttp;
    String parametros;
    String llave;
    
    public RestProductor(StartApp startApp,BufferRest bufferRest,int consultaHttp,String parametros,String llave)
    {
        this.bufferRest = bufferRest;
        this.consultaHttp = consultaHttp;
        this.parametros = parametros;
        this.llave = llave;
        this.startApp = startApp;
    }

    public void run() {
        
        try {
            this.startApp.switchDisplayable(null,startApp.getFormLoading());
            ConectorRest cr = new ConectorRest();
            
            this.bufferRest.setRespuesta(cr.EnviarGet(ConexionIpx.getURL(consultaHttp), this.llave));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
