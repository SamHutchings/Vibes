package com.vibes.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vibes.domain.Contact;
import com.vibes.domain.Vibe;
import com.vibes.enums.VibeType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes methods for getting vibe data from DB
 */
public class VibesDataSource {  // Database fields
    private SQLiteDatabase database;
    private VibesSQLiteHelper dbHelper;
    private String[] allColumns = {VibesSQLiteHelper.COLUMN_ID,
            VibesSQLiteHelper.COLUMN_VIBE_CONTACTID,
            VibesSQLiteHelper.COLUMN_VIBE_VIBETYPE,
            VibesSQLiteHelper.COLUMN_VIBE_SENT};

    public VibesDataSource(Context context) {
        dbHelper = new VibesSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Vibe createVibe(Vibe vibe) {
        ContentValues values = new ContentValues();
        values.put(VibesSQLiteHelper.COLUMN_VIBE_CONTACTID, vibe.getContactId());
        values.put(VibesSQLiteHelper.COLUMN_VIBE_VIBETYPE, vibe.getVibeType().toString());
        values.put(VibesSQLiteHelper.COLUMN_VIBE_SENT, vibe.getSent());
        long insertId = database.insert(VibesSQLiteHelper.TABLE_VIBE, null,
                values);
        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_VIBE,
                allColumns, VibesSQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Vibe newVibe = cursorToVibe(cursor);
        cursor.close();
        return newVibe;
    }

    public void deleteVibe(Vibe vibe) {
        long id = vibe.getId();
        System.out.println("Vibe deleted with id: " + id);
        database.delete(VibesSQLiteHelper.TABLE_VIBE, VibesSQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Vibe> getAllVibes() {
        List<Vibe> vibes = new ArrayList<Vibe>();

        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_VIBE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Vibe vibe = cursorToVibe(cursor);
            vibes.add(vibe);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return vibes;
    }

    private Vibe cursorToVibe(Cursor cursor) {
        Vibe vibe = new Vibe();
        //TODO: GET CONTACT
        vibe.setId(cursor.getLong(0));
        vibe.setVibeType(VibeType.valueOf(cursor.getString(2)));
        vibe.setSent(cursor.getInt(3) != 0);
        return vibe;
    }
}
