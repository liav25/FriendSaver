package liav.com.sadna_ex1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddFriendDialog extends AppCompatDialogFragment {

    EditText editTextName;
    EditText editTextNumber;
    CheckBox isDesigner;
    CheckBox isDeveloper;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.activity_add_friend_dialog, null);

        builder.setView(view).setTitle("Be My Friend !")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editTextName.getText().toString();
                        String phone = editTextNumber.getText().toString();
                        MainActivity.names.add(name);
                        MainActivity.numbers.add(phone);
                        MainActivity.adapter.notifyDataSetChanged();

                    }
                });

        editTextName = view.findViewById(R.id.name);
        editTextNumber = view.findViewById(R.id.number);

        return builder.create();



    }
}
