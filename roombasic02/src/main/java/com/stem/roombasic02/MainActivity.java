package com.stem.roombasic02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.Update;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDatabase mWordDatabase;
    WordDao mWordDao;
    Button insert,update,clear,delete;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database").allowMainThreadQueries().build();
        mWordDao = mWordDatabase.getWordDao();
        initView();
        updateView();

    }

    private void initView() {
        mTextView = (TextView)findViewById(R.id.textView);
        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        clear = (Button) findViewById(R.id.clear);
        delete = (Button) findViewById(R.id.delete);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("hello", "您好");
                Word word2 =new Word("world", "世界");
                mWordDao.insertWords(word1,word2);
                updateView();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordDao.deleteAllWords();
                updateView();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word =new Word("Hi", "您好啊");
                word.setId(11);
                mWordDao.updateWords(word);
                updateView();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word =new Word("Hi", "您好啊");
                word.setId(15);
                mWordDao.deleteWords(word);
                updateView();
            }
        });
    }

    void updateView(){
        List<Word> list =mWordDao.getAllWords();
        String text ="";
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            text += word.getId()+":"+word.getWord()+"+"+word.getChineseMeaning()+"\n";
        }
        mTextView.setText(text);
    }
}
