package com.example.psantosh.encriptiondecription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText  email,pass;
    Button  buttn;
    TextView texttv,textemail,textpass;
    String seedValue = "This Is MySecure";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= (EditText) findViewById(R.id.loginemail);
        pass= (EditText) findViewById(R.id.loginpass);
        buttn= (Button) findViewById(R.id.loginbtn);
        texttv= (TextView) findViewById(R.id.tv);
        textemail= (TextView) findViewById(R.id.tvemail);
        textpass= (TextView) findViewById(R.id.tvpass);

        String encemail=email.getText().toString();
        textemail.setText(encemail);
        String encpass=pass.getText().toString();
        textpass.setText(encpass);




        String normalText = "Prudhvi Raju";
        String normalTextEnc;
        try {
            normalTextEnc = AESHelper.encrypt(seedValue,normalText);
            String normalTextDec = AESHelper.decrypt(seedValue, normalTextEnc);
            TextView txe = new TextView(this);
            txe.setTextSize(14);
            Toast.makeText(getApplicationContext(), "Normal text"+normalText, Toast.LENGTH_SHORT).show();
            texttv.setText("Normal Text ::"+normalText +" \n Encrypted Value :: "+normalTextEnc +" \n Decrypted value :: "+normalTextDec);
           // setContentView(txe);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
