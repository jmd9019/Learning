package com.testapp.roomdbbasicslearn.db

import androidx.room.*
import com.testapp.roomdbbasicslearn.models.Subscriber
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriberDao {

    /**
     * @return Inserted row id as [Long] value for single row
     * and [Collection] of [Long] when multiple rows were inserted.
     *
     * [-1] on ERROR
     */
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    /**
     * @return Number of rows updated
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSubscriber(subscriber: Subscriber):Int

    @Query("SELECT * FROM subscribers_table")
    fun getAllSubscribers(): Flow<List<Subscriber>>

    /**
     * @return Number of rows deleted
     */
    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Int

    /**
     * @return Number of rows deleted
     */
    @Query("DELETE FROM subscribers_table")
    suspend fun deleteAllSubscribers() : Int
}