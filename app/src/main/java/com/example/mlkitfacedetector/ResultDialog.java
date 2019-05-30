package com.example.mlkitfacedetector;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

public class ResultDialog extends DialogFragment {

    Button ok;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resultdialog,container,false);
        ok=view.findViewById(R.id.result_ok_button);
        textView=view.findViewById(R.id.result_text_view);

        String resultText="";

        Bundle bundle = getArguments();

        resultText=bundle.getString(FaceDetection.RESULT_TEXT);

        textView.setText(resultText);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}
