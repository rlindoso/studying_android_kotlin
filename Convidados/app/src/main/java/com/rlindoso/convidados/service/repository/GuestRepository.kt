package com.rlindoso.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.rlindoso.convidados.service.constants.DataBaseConstants
import com.rlindoso.convidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    // CRUD - Create, Read, Update, Delete

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            var cursor: Cursor? = null

            try {
                cursor = db.query(
                    DataBaseConstants.GUEST.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null
                )
                if (cursor != null && cursor.count > 0) {
                    while (cursor.moveToNext()) {
                        val id = cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID) ?: -1
                        )
                        val name = cursor.getString(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME) ?: -1
                        )
                        val presence = (cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE) ?: -1
                        ) == 1)

                        val guest = GuestModel(id, name, presence)
                        list.add(guest)
                    }
                }
            } finally {
                cursor?.close()
            }

            list
        } catch (e: Exception) {
            list
        }
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " =?"
            val args = arrayOf("1")

            var cursor: Cursor? = null

            try {
                cursor = db.query(
                    DataBaseConstants.GUEST.TABLE_NAME,
                    projection,
                    selection,
                    args,
                    null,
                    null,
                    null
                )
                if (cursor != null && cursor.count > 0) {
                    while (cursor.moveToNext()) {
                        val id = cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID) ?: -1
                        )
                        val name = cursor.getString(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME) ?: -1
                        )
                        val presence = (cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE) ?: -1
                        ) == 1)

                        val guest = GuestModel(id, name, presence)
                        list.add(guest)
                    }
                }
            } finally {
                cursor?.close()
            }

            list
        } catch (e: Exception) {
            list
        }
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " =?"
            val args = arrayOf("0")

            var cursor: Cursor? = null

            try {
                cursor = db.query(
                    DataBaseConstants.GUEST.TABLE_NAME,
                    projection,
                    selection,
                    args,
                    null,
                    null,
                    null
                )
                if (cursor != null && cursor.count > 0) {
                    while (cursor.moveToNext()) {
                        val id = cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID) ?: -1
                        )
                        val name = cursor.getString(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME) ?: -1
                        )
                        val presence = (cursor.getInt(
                            cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE) ?: -1
                        ) == 1)

                        val guest = GuestModel(id, name, presence)
                        list.add(guest)
                    }
                }
            } finally {
                cursor?.close()
            }

            list
        } catch (e: Exception) {
            list
        }
        return list
    }

    fun get(id: Int): GuestModel? {

        var guest: GuestModel? = null

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " =?"
            val args = arrayOf(id.toString())

            var cursor: Cursor? = null

            try {
                cursor = db.query(
                    DataBaseConstants.GUEST.TABLE_NAME,
                    projection,
                    selection,
                    args,
                    null,
                    null,
                    null
                )
                if (cursor != null && cursor.count > 0) {
                    cursor.moveToFirst()

                    val name = cursor.getString(
                        cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME) ?: -1
                    )
                    val presence = (cursor.getInt(
                        cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE) ?: -1
                    ) == 1)

                    guest = GuestModel(id, name, presence)
                }
            } finally {
                cursor?.close()
            }

            guest
        } catch (e: Exception) {
            guest
        }
    }

    fun save(guest: GuestModel): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)

            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " =?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)

            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " =?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)

            true
        } catch (e: Exception) {
            false
        }
    }
}