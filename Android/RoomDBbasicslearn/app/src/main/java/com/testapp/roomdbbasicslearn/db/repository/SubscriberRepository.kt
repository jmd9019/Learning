package com.testapp.roomdbbasicslearn.db.repository

import com.testapp.roomdbbasicslearn.db.SubscriberDao
import com.testapp.roomdbbasicslearn.models.Subscriber

class SubscriberRepository(private val subscriberDao: SubscriberDao) {

    val allSubscribers = subscriberDao.getAllSubscribers()

    suspend fun insert(subscriber: Subscriber): Long {
        return subscriberDao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber): Int {
       return subscriberDao.updateSubscriber(subscriber)
    }
    suspend fun delete(subscriber: Subscriber): Int {
       return subscriberDao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(): Int {
      return subscriberDao.deleteAllSubscribers()
    }
}