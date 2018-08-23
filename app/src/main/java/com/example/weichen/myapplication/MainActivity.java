package com.example.weichen.myapplication;

import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttoncall = (Button) findViewById(R.id.am_bt_call);
        final EditText etnum = (EditText) findViewById(R.id.am_et_num);

        final EditText etmsg = (EditText) findViewById(R.id.am_et_msg);
        Button buttonsend = (Button) findViewById(R.id.am_bt_sendmsg);
        buttonsend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String num = etnum.getText().toString();
                String msg = etmsg.getText().toString();

                //����һ��
                SmsManager smsmanager = SmsManager.getDefault();
                List<String> divideContents = smsmanager.divideMessage(msg);
                for (String text : divideContents) {
                    smsmanager.sendTextMessage(num, null, text, null, null);
//
                }
                //��������
//			Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+ num));
//			intent.putExtra("sms_body", msg);
//			startActivity(intent);
            }
        });
        buttoncall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String num = etnum.getText().toString();
                // ��绰
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                        + num));
                // ����
                startActivity(intent);
            }
        });
    }


}
