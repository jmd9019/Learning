package com.testapp.roomdbbasicslearn.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.testapp.roomdbbasicslearn.R
import com.testapp.roomdbbasicslearn.databinding.ListItemSubscriberBinding
import com.testapp.roomdbbasicslearn.models.Subscriber

class SubscribersListAdapter(
    private val subscribersList: List<Subscriber>,
    private val subscriberClickListener: (Subscriber) -> Unit
) : RecyclerView.Adapter<SubscribersViewHolder>() {

    private val subscribersArrayList:ArrayList<Subscriber> = ArrayList()

//    fun subscribersListData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribersViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemSubscriberBinding =
            DataBindingUtil.inflate(layoutInflater,R.layout.list_item_subscriber,parent,false)

        return SubscribersViewHolder(binding,subscriberClickListener)
    }

    override fun onBindViewHolder(holder: SubscribersViewHolder, position: Int) {
        holder.binding(subscribersList[position])
    }

    override fun getItemCount(): Int {
       return subscribersList.size
    }

}

class SubscribersViewHolder(val binding:ListItemSubscriberBinding,
val subscriberClickListener: (Subscriber) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun binding(subscriber: Subscriber) {
        binding.tvName.text = subscriber.name
        binding.tvEmail.text = subscriber.emailId
        binding.cvSubscriberData.setOnClickListener {
            subscriberClickListener(subscriber)
        }
    }
}