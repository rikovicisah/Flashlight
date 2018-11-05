package com.example.irhad.flashlight;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtStanje;
    Camera camera;
    Camera.Parameters parameters;
    boolean upaljeno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStanje = findViewById(R.id.txtStanje);
        camera = Camera.open();
        parameters = camera.getParameters();

    }

    public void onClick(View view){
        if(!upaljeno) upali();
        else ugasi();
    }

    private void upali(){
        txtStanje.setText("ON");
        txtStanje.setTextColor(getResources().getColor(R.color.green));
        upaljeno = true;

        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
    }

    private void ugasi(){
        txtStanje.setText("OFF");
        txtStanje.setTextColor(getResources().getColor(R.color.red));
        upaljeno = false;

        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
    }

}
