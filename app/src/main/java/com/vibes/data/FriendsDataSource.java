package com.vibes.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vibes.domain.Friend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes methods for retrieving and updating friend information
 */
public class FriendsDataSource {
    // Database fields
    private SQLiteDatabase database;
    private VibesSQLiteHelper dbHelper;
    private String[] allColumns = {VibesSQLiteHelper.COLUMN_ID,
            VibesSQLiteHelper.COLUMN_FRIEND_PHONENUMBER,
            VibesSQLiteHelper.COLUMN_FRIEND_USERNAME};

    public FriendsDataSource(Context context) {
        dbHelper = new VibesSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Friend createFriend(Friend friend) {
        ContentValues values = new ContentValues();
        values.put(VibesSQLiteHelper.COLUMN_FRIEND_PHONENUMBER, friend.getPhoneNumber());
        values.put(VibesSQLiteHelper.COLUMN_FRIEND_USERNAME, friend.getUsername());
        long insertId = database.insert(VibesSQLiteHelper.TABLE_FRIEND, null,
                values);
        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_FRIEND,
                allColumns, VibesSQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Friend newFriend = cursorToFriend(cursor);
        cursor.close();
        return newFriend;
    }

    public void deleteFriend(Friend friend) {
        long id = friend.getId();
        System.out.println("Friend deleted with id: " + id);
        database.delete(VibesSQLiteHelper.TABLE_FRIEND, VibesSQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public Friend getFriend(long id) {
        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_FRIEND,
                allColumns, VibesSQLiteHelper.COLUMN_ID + " = " + id, null,
                null, null, null);

        cursor.moveToFirst();

        return cursorToFriend(cursor);
    }

    public List<Friend> getAllFriends() {
        List<Friend> friends = new ArrayList<Friend>();

        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_FRIEND,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Friend friend = cursorToFriend(cursor);
            friends.add(friend);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return friends;
    }

    private Friend cursorToFriend(Cursor cursor) {
        Friend friend = new Friend();
        friend.setId(cursor.getLong(0));
        friend.setPhoneNumber(cursor.getString(1));
        friend.setUsername(cursor.getString(2));
        return friend;
    }
}
