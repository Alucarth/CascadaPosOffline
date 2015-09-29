/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class SendInvoices 
{
    private Vector Factura;
    
     public static String toJSON(SendInvoices solfac)
    {
        return toJSONObject(solfac).toString();
    }
     /**
     * This method should be used by this class only, that's why it is private.
     * Allows to get a JSONObject from the Client passed as parameter
     * @param client Client Object to convert to JSONObject
     * @return JSONObject representation of the Client passed as parameter
     */
    private static JSONObject toJSONObject(SendInvoices facturas) 
    {
        JSONObject json = new JSONObject();
        try {
//            json.put("invoice_items",solfac.getProductos() );
           
            json.put("facturas",facturas.getFacturas() );
            
      } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    
   public JSONArray getFacturas()
    {
        return FacturaOffline.toJSONs(this.Factura);
    }

    public void setFactura(Vector Factura) {
        this.Factura = Factura;
    }
    
   
}
