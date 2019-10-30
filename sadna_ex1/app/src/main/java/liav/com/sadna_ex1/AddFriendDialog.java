package liav.com.sadna_ex1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddFriendDialog extends AppCompatDialogFragment {

    EditText editTextName;
    EditText editTextNumber;
    RadioButton isDesigner;
    RadioButton isDeveloper;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.activity_add_friend_dialog, null);

        //set the dialog view
        builder.setView(view).setTitle("Be My Friend !")
                //when negative button pressed
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                //when positive button pressed
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editTextName.getText().toString();
                        String phone = editTextNumber.getText().toString();
                        String abillity = "Developer";
                        if(isDesigner.isChecked()){
                            abillity = "Designer";
                        }
                        MainActivity.names.add(name);
                        MainActivity.numbers.add(phone);
                        MainActivity.abillities.add(abillity);
                        MainActivity.adapter.notifyDataSetChanged();

                    }
                });

        editTextName = view.findViewById(R.id.name);
        editTextNumber = view.findViewById(R.id.number);
        editTextNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        isDesigner = view.findViewById(R.id.des_radio);
        isDeveloper = view.findViewById(R.id.dev_radio);

        return builder.create();



    }
}
