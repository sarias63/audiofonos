package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    EditText plain_text_input;
    Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plain_text_input = (EditText)findViewById(R.id.plain_text_input);
        button =(Button)findViewById(R.id.button);
        button2 =(Button)findViewById(R.id.button2);

        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule( "audio");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PyObject btn2 = pyobj.callAttr("main",plain_text_input.getText().toString());
                //mensaje.setText(btn2.toString());
            }
        });
    }
}