package com.vibes.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vibes.domain.Contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes methods for retrieving and updating contact information
 */
public class ContactsDataSource {
    // Database fields
    private SQLiteDatabase database;
    private VibesSQLiteHelper dbHelper;
    private String[] allColumns = {VibesSQLiteHelper.COLUMN_ID,
            VibesSQLiteHelper.COLUMN_CONTACT_PHONENUMBER,
            VibesSQLiteHelper.COLUMN_CONTACT_USERNAME};

    public ContactsDataSource(Context context) {
        dbHelper = new VibesSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Contact createContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(VibesSQLiteHelper.COLUMN_CONTACT_PHONENUMBER, contact.getPhoneNumber());
        values.put(VibesSQLiteHelper.COLUMN_CONTACT_USERNAME, contact.getUsername());
        long insertId = database.insert(VibesSQLiteHelper.TABLE_CONTACT, null,
                values);
        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_CONTACT,
                allColumns, VibesSQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Contact newContact = cursorToContact(cursor);
        cursor.close();
        return newContact;
    }

    public void deleteContact(Contact contact) {
        long id = contact.getId();
        System.out.println("Contact deleted with id: " + id);
        database.delete(VibesSQLiteHelper.TABLE_CONTACT, VibesSQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public Contact getContact(long id) {
        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_CONTACT,
                allColumns, VibesSQLiteHelper.COLUMN_ID + " = " + id, null,
                null, null, null);

        cursor.moveToFirst();

        return cursorToContact(cursor);
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<Contact>();

        Cursor cursor = database.query(VibesSQLiteHelper.TABLE_CONTACT,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = cursorToContact(cursor);
            contacts.add(contact);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return contacts;
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getLong(0));
        contact.setPhoneNumber(cursor.getString(1));
        contact.setUsername(cursor.getString(2));
        return contact;
    }
}
