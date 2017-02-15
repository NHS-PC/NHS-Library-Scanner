package com.example.nhs.libraryscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.nhs.libraryscanner.DataReader;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Student> returnedList = DataReader.readCSV("~/Desktop/WILL_DONT_DELETE/test.csv");
        for (Student s: returnedList)
        {
            System.out.println(s);
        }

    }

    /*public void openCamera(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, i);
        if (scanResult != null) {
            // handle scan result
            TextView output = (TextView)findViewById(R.id.qrTextView);
            output.setText(scanResult.getContents());
        }
    }*/
}
