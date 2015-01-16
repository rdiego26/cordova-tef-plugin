package com.phonegap.plugins.sitefhelper;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.*;

import br.com.softwareexpress.sitef.android.CliSiTefI;

public class SiTefHelper extends CordovaPlugin
{

    private static CliSiTefI clisitef;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        clisitef = new CliSiTefI( this.cordova.getActivity() );

        clisitef.configuraIntSiTefInterativoEx("172.27.170.247", "00000000","SE000001", "[TipoPinPad=ANDROID_BT;]");
        clisitef = CliSiTefI.getInstance();

        if ("getFableSerial".equals(action)) {
            String serial = "15345344132354";
            callbackContext.success(serial);
            //callbackContext.sendPluginResult(new PluginResult(Status.OK, serial));
            return true;
        } else if( "sitef".equals(action) ) {
            callbackContext.success( clisitef.iniciaFuncaoSiTefInterativo(3, "1930", "758", "20150116", "115200", "Operador1", "") );
            return true;
        }
        else{
            callbackContext.error("method not found");
            return false;
        }
    }
}

