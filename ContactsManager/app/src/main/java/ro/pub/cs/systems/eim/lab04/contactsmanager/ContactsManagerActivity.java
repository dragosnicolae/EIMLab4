package ro.pub.cs.systems.eim.lab04.contactsmanager;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactsManagerActivity extends AppCompatActivity {

    private Button save, cancel;
    private EditText name, phone, address, email;

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.save_button:
                    String nameText = name.getText().toString();
                    String emailText = email.getText().toString();
                    String addressText = address.getText().toString();
                    String phoneText = phone.getText().toString();

                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    if (name != null) {
                        intent.putExtra(ContactsContract.Intents.Insert.NAME, nameText);
                    }
                    if (phone != null) {
                        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneText);
                    }
                    if (email != null) {
                        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, emailText);
                    }
                    if (address != null) {
                        intent.putExtra(ContactsContract.Intents.Insert.POSTAL, addressText);
                    }
                    startActivity(intent);

                    break;
                case R.id.cancel_button:
                    finish();
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);

        ButtonListener buttonListenr = new ButtonListener();

        save = (Button)findViewById(R.id.save_button);
        save.setOnClickListener(buttonListenr);
        cancel = (Button)findViewById(R.id.cancel_button);
        cancel.setOnClickListener(buttonListenr);

        name = (EditText)findViewById(R.id.name_edit_text);
        email = (EditText)findViewById(R.id.email_edit_text);
        address = (EditText)findViewById(R.id.address_edit_text);
        phone = (EditText)findViewById(R.id.phone_edit_text);


    }
}
