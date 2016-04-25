package com.proyect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.barcode.BarcodeCaptureActivity;
import com.barcode.InfoTarjeta;
import com.google.android.gms.common.api.CommonStatusCodes;


/**
 * **************************************************************
 * Copyright (c) 2016 - 2016 Avanza, All rights reserved
 * <p/>
 * -
 *  Clase de ejmplo que hace uso del modulo para capturar la informacion de las cedulas por codigo de barras
 * -
 * Autor:		Carlos Arturo Reyes Romero
 * email:		carr900@gmail.com
 * Creado:   	25/04/2016
 * Proyecto: 	barcode-reader
 * ****************************************************************
 */
public class CapturarCodigoBarras extends Activity {

    private Context context;
    private int RC_BARCODE_CAPTURE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_barras);
        context = this;

        findViewById(R.id.read_barcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, BarcodeCaptureActivity.class);
                intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
                intent.putExtra(BarcodeCaptureActivity.UseFlash, false);
                startActivityForResult(intent, RC_BARCODE_CAPTURE);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    InfoTarjeta infoTarjeta = (InfoTarjeta)data.getSerializableExtra(BarcodeCaptureActivity.BarcodeObject);
                    Log.d("TAG", "->>>>>>" + infoTarjeta.toString());

                }

            }
        }
    }

}