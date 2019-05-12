package com.example.popularmovie;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

        private Context mCtx;
        private static DatabaseClient mInstance;

        //our app database object
        private FavDatabase appDatabase;

        public DatabaseClient(Context mCtx) {
            this.mCtx = mCtx;


            appDatabase = Room.databaseBuilder(mCtx, FavDatabase.class, "MyToDos").build();
        }

        public static synchronized DatabaseClient getInstance(Context mCtx) {
            if (mInstance == null) {
                mInstance = new DatabaseClient(mCtx);
            }
            return mInstance;
        }

        public FavDatabase getAppDatabase() {
            return appDatabase;
        }
    }