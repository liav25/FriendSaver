package liav.com.sadna_ex1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import static android.app.Activity.RESULT_OK;

public class AddFriendDialog extends AppCompatDialogFragment {
    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int CAMERA_REQUEST = 1888;

    EditText editTextName;
    EditText editTextNumber;
    RadioButton isDesigner;
    RadioButton isDeveloper;
    ImageButton upload;
    ImageView imageView;
    Bitmap photo;

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
                        MainActivity.images.add(photo);
                        MainActivity.adapter.notifyDataSetChanged();


                    }
                });

        editTextName = view.findViewById(R.id.name);
        editTextNumber = view.findViewById(R.id.number);
        editTextNumber.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        editTextNumber.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        isDesigner = view.findViewById(R.id.des_radio);
        isDeveloper = view.findViewById(R.id.dev_radio);

        upload = view.findViewById(R.id.upload_pic);
        imageView = view.findViewById(R.id.profile_pic);


        //camera button onclick listener
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);//zero can be replaced with any action code (called requestCode)
            }
        });

        return builder.create();



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        //{
            photo = (Bitmap) data.getExtras().get("data");
            BitmapDrawable bd = new BitmapDrawable(getResources(), photo);
            imageView.setBackground(bd);

        //}

    }
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }


}
