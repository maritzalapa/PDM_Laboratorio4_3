package com.example.noa.laboratorio_43_2;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by noa on 25/01/16.
 */
public class MiIntentService extends IntentService{

    public static final String ACTION_PROGRESO =
            "com.example.noa.intent.action.PROGRESO";
    public static final String ACTION_FIN =
            "com.example.noa.intent.action.FIN";


    public MiIntentService() {
        super("MiIntentService");
    }

    protected void onHandleIntent(Intent intent) {
        int iter = intent.getIntExtra("iteraciones", 0);
        for(int i=1; i<=iter; i++) {
            tareaLarga();
//Comunicamos el progreso
            Intent bcIntent = new Intent();
            bcIntent.setAction(ACTION_PROGRESO);
            bcIntent.putExtra("progreso", i*10);
            sendBroadcast(bcIntent);
        }
        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);
    }

    private void tareaLarga() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) { }
    }


}
