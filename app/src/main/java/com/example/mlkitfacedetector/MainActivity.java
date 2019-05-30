package com.example.mlkitfacedetector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button cameraButton;
    final static int REQUEST_CAMERA_IMAGE=777;
    FirebaseVisionImage image;
    FirebaseVisionFaceDetector firebaseVisionFaceDetector;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if((requestCode == REQUEST_CAMERA_IMAGE) &&(resultCode == RESULT_OK)){

            Log.d("tag", "onActivityResult:  "+requestCode +" "+resultCode);

            Bundle extras = data.getExtras();

            Bitmap bitmap = (Bitmap) extras.get("data");

            detectFace(bitmap);

        }
    }

    private void detectFace(Bitmap bitmap) {

        FirebaseVisionFaceDetectorOptions highAccuracyOpts =
                new FirebaseVisionFaceDetectorOptions.Builder()
                        .setModeType(FirebaseVisionFaceDetectorOptions.ACCURATE_MODE)
                        .setClassificationType(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                        .setClassificationType(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                        .setTrackingEnabled(true)
                        .setMinFaceSize(0.15f)
                        .build();

        try {
            image = FirebaseVisionImage.fromBitmap(bitmap);
            firebaseVisionFaceDetector = FirebaseVision.getInstance().getVisionFaceDetector(highAccuracyOpts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        firebaseVisionFaceDetector.detectInImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionFace>>() {
            @Override
            public void onSuccess(List<FirebaseVisionFace> firebaseVisionFaces) {

                   int i=1;
                   String resultText = "";

                   for( FirebaseVisionFace face : firebaseVisionFaces){
                      resultText= resultText
                               .concat("\n"+i+".")
                               .concat("\nSmile :"+face.getSmilingProbability()*100+"%")
                               .concat("\nLeft Eye open :"+face.getLeftEyeOpenProbability()*100+"%")
                               .concat("\nRight Eye open :"+face.getRightEyeOpenProbability()*100+"%")
                               .concat("\nHead Angle y :"+face.getHeadEulerAngleY()*100+"%")
                               .concat("\nHead Angle y :"+face.getHeadEulerAngleZ()*100+"%");
                       i++;
                   }

                   if(firebaseVisionFaces.size() ==0){
                       Toast.makeText(MainActivity.this,"No Face Detected",Toast.LENGTH_SHORT).show();
                   }else{
                       Bundle bundle = new Bundle();

                       bundle.putString(FaceDetection.RESULT_TEXT,resultText);

                       DialogFragment resultDialog = new ResultDialog();

                       resultDialog.setArguments(bundle);

                       resultDialog.setCancelable(false);

                       resultDialog.show(getSupportFragmentManager(),FaceDetection.RESULT_DIALOG);
                   }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        cameraButton=findViewById(R.id.camerabutton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(takeImage.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takeImage,REQUEST_CAMERA_IMAGE);
                }
            }
        });


    }
}
