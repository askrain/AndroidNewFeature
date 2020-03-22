package com.stem.roombasic02;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @描述 抽离activity中关于数据绑定的操作
 * @作者 stemt
 * @日期 2020-03-22 17:49
 * @版本
 */
public class WordViewModel extends AndroidViewModel {
//    private WordDao wordDao;
//    private LiveData<List<Word>> allWordsLive;
    private WordRepository mWordRepository;
    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository =new WordRepository(application);
       /* WordDatabase wordDatabase = WordDatabase.getDatabase(application);
        wordDao = wordDatabase.getWordDao();
        allWordsLive = wordDao.getAllWordLive();//系统直接放在子线程进行*/
    }

    LiveData<List<Word>> getAllWordsLive() {
        return mWordRepository.getAllWordsLive();
    }

    void insertWords(Word...words){
//        new InsertAsyncTask(wordDao).execute(words);
        mWordRepository.insertWords(words);
    }
    void updateWords(Word...words){
//        new UpdateAsyncTask(wordDao).execute(words);
        mWordRepository.updateWords(words);
    }
    void deleteWord(Word...words){
//        new DeleteAsyncTask(wordDao).execute(words);
        mWordRepository.deleteWord(words);
    }
    void deleteAllWord(){
//        new DeleteAllAsyncTask(wordDao).execute();
        mWordRepository.deleteAllWord();
    }


/*
    static class InsertAsyncTask extends AsyncTask<Word,Void,Void>{
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

    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void> {
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
