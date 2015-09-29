/*
 *  Esta clase trata una respuesta json con la siguiente estructura:
 * {
    "clientes": [{
        "id": 1,
        "name": "Pollos Copacabana",
        "nit": "987654321"
    }, {
        "id": 2,
        "name": "APLP",
        "nit": "123456798"
    }, {
        "id": 3,
        "name": "Coca Cola",
        "nit": "2308379"
    }],
    "productos": [{
        "id": 1,
        "notes": "Servicios",
        "cost": "253.4000"
    }, {
        "id": 2,
        "notes": "consumo",
        "cost": "300.0000"
    }]
}
* se quito los clientes de la respuesta debido a excesivo trafico de datos
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class Cuenta 
{
    private Vector productos;
    private String jsonText;
    private String ice;
    private Vector clientes;
    private Sucursal sucursal;
    public Cuenta(){}
    public Cuenta(String jsonText)
    {
       //this.jsonText = jsonText;
        try {
           JSONObject json = new JSONObject(jsonText);
           if(json.has("productos"))
           {
               this.productos = Products.fromJsonArray(json.getString("productos"));
           }
           if(json.has("ice"))
           {
               this.ice = json.getString("ice");
           }
           if(json.has("clientes"))
           {
               this.clientes = Clients.fromJsonArray(json.getString("clientes"));
           }
           if(json.has("sucursal"))
           {
               this.sucursal = new Sucursal(json.getString("sucursal"));
           }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }   
    }
    public Vector getProductos()
    {
        return this.productos;
    }
    public String getIce()
    {
        return this.ice;
    }
    public Vector getClientes()
    {
        return this.clientes;
    }
    public Sucursal getSucursal()
    {
        return this.sucursal;
    }
    
//    public void run()
//    {
//         try {
//            JSONObject json = new JSONObject(jsonText);
//           if(json.has("productos"))
//           {
//               this.productos = Products.fromJsonArray(json.getString("productos"));
//           }
////           if(json.has("clientes"))
////           {
////               this.clientes = Clients.fromJsonArray(json.getString("clientes"));
////           }
//        } catch (JSONException ex) {
//            ex.printStackTrace();
//        }
//    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void setProductos(Vector productos) {
        this.productos = productos;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }
    
}
