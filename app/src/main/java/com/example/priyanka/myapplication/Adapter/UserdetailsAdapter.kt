package com.example.priyanka.myapplication.Adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import butterknife.internal.Utils
import com.example.priyanka.myapplication.Adapter.UserdetailsAdapter.MyViewHolder
import com.example.priyanka.myapplication.Model.Userinfo
import android.view.LayoutInflater
import com.example.priyanka.myapplication.R


/*** Created by nikita on 21/7/17.
 */
class UserdetailsAdapter(private var mContext: Context?, private var userList: ArrayList<Userinfo>?) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.getContext())
                .inflate(R.layout.adapter_user_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int {
        return userList?.size!!
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }

    init {
        notifyDataSetChanged()
        Log.d("Length", "" + userList?.size)
    }

}