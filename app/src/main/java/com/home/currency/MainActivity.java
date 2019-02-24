package com.home.currency;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        edntd = findViewById(R.id.ntd);
    }

    public void GO(View view) {
        String s_NTD = edntd.getText().toString();

        if (s_NTD.equals("")) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter ou NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            float NTD = Float.parseFloat(s_NTD);
            float USD = NTD / 30.9f;
            Log.d("MainActivity", "USD is " + USD);
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + USD)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edntd.setText("");
                        }
                    })
                    .show();
        }
    }
}



