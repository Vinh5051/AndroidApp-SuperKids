package com.example.vinhmai.superkids;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vinhmai.superkids.models.Object;

import java.util.ArrayList;
import java.util.List;

public class MyDataBaseHelper extends SQLiteOpenHelper{

    private static final  String TAG = "SQLITE";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Kids_Salf_Learning";

    // tạo bảng informations
    private static final String TABLE_INFORMATIONS = "Inforations";

    private static final String COLUMN_INFORMATION_ID = "Information_ID";
    private static final String COLUMN_INFORMATION_WORD = "Information_Word";
    private static final String COLUMN_INFORMATION_IMAGE = "Information_Image";
    private static final String COLUMN_INFORMATION_SOUD = "Information_Sound";
    private static final String COLUMN_INFORMATION_TOPIC_ID = "Information_Topic_ID";

    // tạo bảng categories
    private static final String TABLE_TOPICS = "Topics";

    private static final String COLUMN_TOPIC_ID = "Topic_ID";
    private static final String COLUMN_TOPIC_NAME = "Topic_Name";

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: MyDatabaseHelper.onCreate ... ");

        //script tạo bảng
        String script = "CREATE TABLE" + TABLE_INFORMATIONS + "("
                + COLUMN_INFORMATION_ID + "INTEGER PRIMARY KEY"
                + COLUMN_INFORMATION_WORD + "TEXT"
                + COLUMN_INFORMATION_IMAGE + "TEXT"
                + COLUMN_INFORMATION_SOUD + "" + ")"
                + COLUMN_INFORMATION_TOPIC_ID + "INTEGER";
        //RUN
        db.execSQL(script);

    }

   public void onCreateTableCategories(){
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");

        String script = "CREATE TABLE" + TABLE_TOPICS + "("
                        + COLUMN_TOPIC_ID + "INTEGER NOT NULL CONSTRAINT COLUMN_INFORMATION_CATEGORY_ID"
                        + COLUMN_TOPIC_NAME + "TEXT";
       getReadableDatabase().execSQL(script);
   }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");

        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFORMATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOPICS;

        // Và tạo lại.
        onCreate(db);
        onCreateTableCategories();
    }

    public void createDefaut(){}

    public void addInformation(Object object){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_INFORMATION_WORD, object.getWord());
        values.put(COLUMN_INFORMATION_IMAGE, object.getImage());
        values.put(COLUMN_INFORMATION_SOUD, object.getSound());

        db.insert(TABLE_INFORMATIONS, null, values);

        db.close();
    }

    //cap phat id
    public Object getObject(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_INFORMATIONS
                                , new String[]{COLUMN_INFORMATION_ID
                                            , COLUMN_INFORMATION_WORD
                                            , COLUMN_INFORMATION_IMAGE
                                            , COLUMN_INFORMATION_SOUD
                                            , COLUMN_INFORMATION_TOPIC_ID}
                                ,COLUMN_INFORMATION_ID +"=?"
                                , new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Object object = new Object(Integer.parseInt(cursor.getString(0))
                ,cursor.getString(1)
                ,cursor.getString(2)
                , cursor.getString(3)
                , cursor.getInt(4));

        return object;
    }

    public List<Object> getAllObject(){

        List<Object> objectListlist = new ArrayList<Object>();
        String selectQuery = "SELECT  *FORM" + TABLE_INFORMATIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()){
            do {
                Object object = new Object();
                object.setId(Integer.parseInt(cursor.getString(0)));
                object.setWord(cursor.getString(1));
                object.setImage(cursor.getString(2));
                object.setImage(cursor.getString(3));
                object.setImage(cursor.getString(4));
            }while (cursor.moveToNext());
        }
        return objectListlist;
    }

    public int getObjectCount(){

        String countQuery = "SELECT *FORM" + TABLE_INFORMATIONS;
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        return count;
    }


}
// đây chỉ tạo bảng ìnormation, còn bảng topic chưa tạo,
// dổi tên class thành MyDatabaseInformation
//chỉnh sửa models

