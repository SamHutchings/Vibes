package com.vibes.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Sql helper for the vibes DB
 */
public class VibesSQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_VIBE = "comments";
    public static final String TABLE_CONTACT = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_VIBE_CONTACTID = "contactid";
    public static final String COLUMN_VIBE_VIBETYPE = "vibetype";
    public static final String COLUMN_VIBE_SENT = "sent";
    public static final String COLUMN_CONTACT_PHONENUMBER = "phonenumber";

    private static final String DATABASE_NAME = "vibes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_VIBES = "create table "
            + TABLE_VIBE + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_VIBE_CONTACTID
            + " integer not null, " + COLUMN_VIBE_SENT
            + " integer not null, " + COLUMN_VIBE_VIBETYPE
            + " text not null, "
            + " FOREIGN KEY(" + COLUMN_VIBE_CONTACTID + ") REFERENCES " + TABLE_CONTACT + "(" + COLUMN_ID + ")";

    private static final String CREATE_CONTACTS = "create table "
            + TABLE_CONTACT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_CONTACT_PHONENUMBER
            + " text not null);";

    public VibesSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_VIBES);
        database.execSQL(CREATE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(VibesSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIBE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }
}
