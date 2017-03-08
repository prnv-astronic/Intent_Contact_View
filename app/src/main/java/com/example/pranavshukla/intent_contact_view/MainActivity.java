package com.example.pranavshukla.intent_contact_view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_CONTACT = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create and register button
        Button open_contact_list_button = (Button) findViewById(R.id.button);
        // set on click listner on button
        open_contact_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new intenet
                Intent open_contact = new Intent(Intent.ACTION_VIEW,ContactsContract.Contacts.CONTENT_URI);
                // start activity
                startActivityForResult(open_contact, PICK_CONTACT);



            }
        });


    }
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                    }
                }
                break;
        }
    }

}