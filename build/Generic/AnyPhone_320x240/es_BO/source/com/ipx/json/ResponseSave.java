/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class ResponseSave
{
//    {
//    resultado : 0
//    respuesta: 2
//    }
    private String resultado;
    private String respuesta;
    public ResponseSave(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("resultado"))
            {
                this.setResultado(json.getString("resultado"));
            }
            if(json.has("respuesta"))
            {
                this.setRespuesta(json.getString("respuesta"));
            }
        
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
