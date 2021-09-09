package com.example.internalfileddemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView mOutputText;
    private Button mBtnCreateFile, mBtnReadFile, mBtnFileList,mBtnDeleteFile;
    private EditText mFileContent;
    ImageView mImageView;

    public static final String FILE_NAME = "mytextfile";
    public static final String IMAGE_NAME = "red_flower";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();

        String path = getFilesDir().getAbsolutePath();

        mOutputText.setText(path);
        this.mBtnCreateFile.setOnClickListener(this::createFile);
        this.mBtnReadFile.setOnClickListener(this::readFile);
        this.mBtnFileList.setOnClickListener(this::showFileList);
        this.mBtnDeleteFile.setOnClickListener(this::deleteFile);



    }

    public void readFile(View view) {
//        StringBuilder sb = new StringBuilder();
        Bitmap bitmap = null;
        InputStream inputStream = null;

        try {
            inputStream = openFileInput(IMAGE_NAME+".jpg");
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        mOutputText.setText(sb.toString());
        mImageView.setImageBitmap(bitmap);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    public void createFile(View view) {


        String data = mFileContent.getText().toString();
        FileOutputStream outputStream = null;

        try {

             outputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);
             outputStream.write(data.getBytes());
             outputStream.flush();
             mOutputText.setText("File Written");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        finally
        {
            if(outputStream != null){
                try{
                    outputStream.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }




//        Bitmap data = getImage();
//
//        BitmapDrawable drawable = (BitmapDrawable) getDrawable(R.drawable.red_flower);
//        data = drawable.getBitmap();
//
//        FileOutputStream outputStream = null;
//
//        try {
//
//            outputStream = openFileOutput(IMAGE_NAME+".jpg",MODE_PRIVATE);
//            data.compress(Bitmap.CompressFormat.JPEG,50,outputStream);
//
//            mOutputText.setText("Image Written");
//
//        } catch (FileNotFoundException e) {
//
//            e.printStackTrace();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//        finally
//        {
//            if(outputStream != null){
//                try{
//                    outputStream.close();
//                }
//                catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }


    }


    public void showFileList(View view) {
    }

    public void deleteFile(View view) {
    }

    private void initView() {
        mOutputText = findViewById(R.id.textView);
        mBtnCreateFile = findViewById(R.id.button);
        mBtnReadFile = findViewById(R.id.button2);
        mBtnFileList = findViewById(R.id.button3);
        mBtnDeleteFile = findViewById(R.id.button4);
        mFileContent = findViewById(R.id.file_content);
        mImageView = findViewById(R.id.imageView);
    }


//    private Bitmap getImage(){
//
//        Bitmap image = null;
//
//        try{
//                InputStream inputStream = getAssets().open("red_flower.jpg");
//                image = BitmapFactory.decodeStream(inputStream);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return image;
//    }
}