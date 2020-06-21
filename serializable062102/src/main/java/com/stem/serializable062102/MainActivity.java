package com.stem.serializable062102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyStore;

public class MainActivity extends AppCompatActivity {
    private Button saveBtn,loadBtn;
    private TextView mTextView;
    public static final String FILE_NAME = "profile.dat";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn = findViewById(R.id.buttonSave);
        loadBtn = findViewById(R.id.buttonLoad);
        mTextView = findViewById(R.id.textView);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student =new Student("lilu", 23, new Score(90, 93, 98));
                try {
                    ObjectOutputStream objectOutputStream =new ObjectOutputStream(openFileOutput(FILE_NAME,MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(MainActivity.this, "save success!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
                    Student student = (Student) objectInputStream.readObject();
                    mTextView.setText(student.toString());
                    Toast.makeText(MainActivity.this, "read success!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick student:  "+student);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        });

    }
}
