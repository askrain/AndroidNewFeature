package com.stem.roombasic02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import androidx.room.Update;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/*
* 逻辑调用层级：
* 1. activity 调用ViewModel的接口（包含LiveData）
* 2. ViewModel 绑定数据仓库，调用数据仓库接口，执行相关业务
* 3. 数据仓库绑定 数据库和dao，直接对数据库进行异步操作，暴露接口给ViewModel
* 4. dao直接运用Room技术操作数据库*/
public class MainActivity extends AppCompatActivity {
//    WordDatabase mWordDatabase;
//    WordDao mWordDao;
    Button insert,update,clear,delete;
    TextView mTextView;
//    LiveData<List<Word>> allWordLive;
    WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mWordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database").allowMainThreadQueries().build();
//        mWordDatabase = WordDatabase.getDatabase(this);
//        mWordDao = mWordDatabase.getWordDao();
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        //        allWordLive = mWordDao.getAllWordLive();
        initView();
        mWordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("+").append(word.getChineseMeaning()).append("\n");
                }
                mTextView.setText(text.toString());
            }
        });
//        updateView();

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
//                mWordDao.insertWords(word1,word2);
                //                updateView();
//                new InsertAsyncTask(mWordDao).execute(word1,word2);
                mWordViewModel.insertWords(word1,word2);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mWordDao.deleteAllWords();
//                updateView();
//                new DeleteAllAsyncTask(mWordDao).execute();
                mWordViewModel.deleteAllWord();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word =new Word("Hi", "您好啊");
                word.setId(11);
//                new UpdateAsyncTask(mWordDao).execute(word);
//                mWordDao.updateWords(word);
                mWordViewModel.updateWords(word);
//                updateView();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word =new Word("Hi", "您好啊");
                word.setId(15);
//                new DeleteAsyncTask(mWordDao).execute(word);
//                mWordDao.deleteWords(word);
                mWordViewModel.deleteWord(word);
//                updateView();
            }
        });
    }

//    void updateView(){
//        List<Word> list =mWordDao.getAllWords();
//        String text ="";
//        for (int i = 0; i < list.size(); i++) {
//            Word word = list.get(i);
//            text += word.getId()+":"+word.getWord()+"+"+word.getChineseMeaning()+"\n";
//        }
//        mTextView.setText(text);
//    }

   /* static class InsertAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }
    static class UpdateAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private WordDao wordDao;

        public DeleteAllAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }*/
}
