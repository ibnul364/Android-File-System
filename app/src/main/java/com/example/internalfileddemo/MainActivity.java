package com.example.internalfileddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mOutputText;
    private Button mBtnCreateFile, mBtnReadFile, mBtnFileList,mBtnDeleteFile;
    private EditText mFileContent;

    private static final String FILE_NAME = "mytextfile.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutputText = findViewById(R.id.textView);
        mBtnCreateFile = findViewById(R.id.button);
        mBtnReadFile = findViewById(R.id.button2);
        mBtnFileList = findViewById(R.id.button3);
        mBtnDeleteFile = findViewById(R.id.button4);
        mFileContent = findViewById(R.id.file_content);

        initView();

        String path = getFilesDir().getAbsolutePath();

        mOutputText.setText(path);
        this.mBtnCreateFile.setOnClickListener(this::createFile);
        this.mBtnReadFile.setOnClickListener(this::readFile);
        this.mBtnFileList.setOnClickListener(this::showFileList);
        this.mBtnDeleteFile.setOnClickListener(this::deleteFile);



    }

    private void initView() {
    }

    public void readFile(View view) {
    }

    public void showFileList(View view) {
    }

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
    }

    public void deleteFile(View view) {
    }
}