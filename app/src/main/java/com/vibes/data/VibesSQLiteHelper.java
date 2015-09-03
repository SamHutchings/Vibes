package com.vibes.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Sql helper for the vibes DB
 */
public class VibesSQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_VIBE = "vibe";
    public static final String TABLE_FRIEND = "contact";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_VIBE_FRIENDID = "contactid";
    public static final String COLUMN_VIBE_VIBETYPE = "vibetype";
    public static final String COLUMN_VIBE_SENT = "sent";
    public static final String COLUMN_VIBE_DATE = "date";
    public static final String COLUMN_FRIEND_PHONENUMBER = "phonenumber";
    public static final String COLUMN_FRIEND_USERNAME = "username";

    private static final String DATABASE_NAME = "vibes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_VIBES = "create table "
            + TABLE_VIBE + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_VIBE_FRIENDID
            + " integer not null, " + COLUMN_VIBE_SENT
            + " integer not null, " + COLUMN_VIBE_VIBETYPE
            + " datetime not null, " + COLUMN_VIBE_DATE
            + " text not null, "
            + " FOREIGN KEY(" + COLUMN_VIBE_FRIENDID + ") REFERENCES " + TABLE_FRIEND + "(" + COLUMN_ID + "))";

    private static final String CREATE_FRIENDS = "create table "
            + TABLE_FRIEND + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_FRIEND_PHONENUMBER
            + " text not null, " + COLUMN_FRIEND_USERNAME
            + " text not null);";

    public VibesSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_VIBES);
        database.execSQL(CREATE_FRIENDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(VibesSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIBE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIEND);
        onCreate(db);
    }
}
