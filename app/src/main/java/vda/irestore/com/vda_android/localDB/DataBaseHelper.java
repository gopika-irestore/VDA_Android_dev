package vda.irestore.com.vda_android.localDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 04-01-2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "UNSYNCH_REPORT.DB";
    static final int DB_VERSION = 1;
    static final String TABLE_NAME = "REPORT";
    public static final String REPORT = "REPORT_NEW";
    public static final String POLE_ID = "poleid";
    public static final String POLE_HEIGHT = "poleheight";
    public static final String DATE = "datedformat";
    public static final String ADDRESS = "address";
    public static final String _ID = "_id";
    public static final String POLETOP = "poleTop";
    public static final String POLE = "pole";
    public static final String UNDERGROUND = "undeground";
    public static final String OTHER = "other";

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY, " + REPORT + " TEXT,"
            + ADDRESS + " TEXT,"
            + DATE + " TEXT,"
            + POLE_HEIGHT + " TEXT,"
            + POLE_ID + " TEXT,"
            + POLETOP + " TEXT,"
            + POLE + " TEXT,"
            + UNDERGROUND + " TEXT,"
            + OTHER + " TEXT);";

    //    AUTOINCREMENT
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
