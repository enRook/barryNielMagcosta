package com.barry.classmonitoring;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyDialog extends DialogFragment
{public static final String CLASS_ADD_DIALOG="addClass";
    private OnClickListener listener;
    public interface OnClickListener{

        void onClick(String text1, String text2);
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog= null;
        if(getTag().equals(CLASS_ADD_DIALOG)){
            dialog = getAddClassDialog();
        }
        return dialog;
    }


    private Dialog getAddClassDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        title.setText("Add New Class");

        EditText class_edt = view.findViewById(R.id.edt01);
        EditText subject_edt = view.findViewById(R.id.edt02);

        class_edt.setHint("Class Name");
        subject_edt.setHint("Subject Name");
        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);

        // Declare dialog as final to access inside the lambda
        final Dialog dialog = builder.create();

        cancel.setOnClickListener(v -> dialog.dismiss());
        add.setOnClickListener(v -> {
            String className = class_edt.getText().toString();
            String subName = subject_edt.getText().toString();
            if (listener != null) {
                listener.onClick(className, subName);
            }
            dialog.dismiss();
        });
        return dialog;
    }


}
