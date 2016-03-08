package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.net.Uri;

public class PhoneDialerActivity extends Activity {


    static int[] buttons = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        final EditText phoneNo = (EditText) findViewById(R.id.phoneno);
        ImageButton backspace = (ImageButton) findViewById(R.id.backspace);
        ImageButton call = (ImageButton) findViewById(R.id.call);
        ImageButton hangup = (ImageButton) findViewById(R.id.hangup);

        for (int i = 0; i <= 9; i++) {
            Button btn = (Button) findViewById(buttons[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String btnText = ((Button) v).getText().toString();
                    btnText = phoneNo.getText().toString() + btnText;
                    phoneNo.setText(btnText);
                }
            });
        }

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnText = phoneNo.getText().toString();
                if (btnText.length() > 0)
                    phoneNo.setText(btnText.substring(0, btnText.length() - 1));
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNo.getText().toString()));
                startActivity(intent);
            }
        });

        hangup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
