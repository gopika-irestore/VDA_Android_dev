package vda.irestore.com.vda_android.localDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dell on 04-01-2018.
 */

public class DataBaseManager {


    private DataBaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DataBaseManager(Context c) {
        context = c;
    }

    public DataBaseManager open() throws SQLException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String selectedPoleId, String selectedPoleHeight, String addressString, String dateFormat, String reportStructure,
                       String isPoleTop, String isPole, String isUnderground, String isOther) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DataBaseHelper.REPORT, reportStructure);
        contentValue.put(DataBaseHelper.DATE, dateFormat);
        contentValue.put(DataBaseHelper.ADDRESS, addressString);
        contentValue.put(DataBaseHelper.POLE_HEIGHT, selectedPoleHeight);
        contentValue.put(DataBaseHelper.POLE_ID, selectedPoleId);
        contentValue.put(DataBaseHelper.POLETOP, isPoleTop);
        contentValue.put(DataBaseHelper.POLE, isPole);
        contentValue.put(DataBaseHelper.UNDERGROUND, isUnderground);
        contentValue.put(DataBaseHelper.OTHER, isOther);
        database.insert(DataBaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DataBaseHelper._ID, DataBaseHelper.REPORT, DataBaseHelper.ADDRESS, DataBaseHelper.DATE,
                DataBaseHelper.POLE_HEIGHT, DataBaseHelper.POLE_ID, DataBaseHelper.POLETOP, DataBaseHelper.POLE, DataBaseHelper.UNDERGROUND, DataBaseHelper.OTHER};
        Cursor cursor = database.query(DataBaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.REPORT, name);
//        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DataBaseHelper.TABLE_NAME, contentValues, DataBaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper._ID + "=" + _id, null);
    }
}