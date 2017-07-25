package com.example.priyanka.myapplication.volleyKotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.app.ProgressDialog
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import com.android.volley.*
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.TimeoutError
import com.android.volley.NoConnectionError
import com.android.volley.ParseError
import com.android.volley.AuthFailureError
import com.android.volley.NetworkError
import com.example.priyanka.myapplication.Adapter.UserdetailsAdapter
import com.example.priyanka.myapplication.Model.Userinfo
import com.example.priyanka.myapplication.R
import org.json.JSONObject
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager


class Volley : AppCompatActivity() {
    var userList: ArrayList<Userinfo>? = null
    var recyclerViewUserInfo: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        val tag_json_obj = "json_obj_req"

        val url = "https://api.androidhive.info/volley/person_object.json"

        val pDialog = ProgressDialog(this)
        pDialog.setMessage("Loading...")
        pDialog.show()

        val strReq = StringRequest(Request.Method.GET,
                url, object : Response.Listener<String> {

            override fun onResponse(response: String) {
                userList = ArrayList()
                Log.d("RES@@", response.toString())
                val info = Userinfo()
                val jsonobj = JSONObject(response)
                info.setEmail(jsonobj.getString("name"))
                info.setEmail(jsonobj.getString("name"))
                val phoneobj = jsonobj.getJSONObject("phone")
                info.setEmail(phoneobj.getString("home"))
                info.setEmail(phoneobj.getString("mobile"))
                userList?.add(info)
                if (userList?.size!! == 0) {
                    val adapter = UserdetailsAdapter(this@Volley, userList)
                    val mLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerViewUserInfo?.setLayoutManager(mLayoutManager)
                    recyclerViewUserInfo?.setItemAnimator(DefaultItemAnimator())
                    recyclerViewUserInfo?.setAdapter(adapter)
                    adapter.notifyDataSetChanged()
                }
                pDialog.hide()

            }
        }, object : Response.ErrorListener {

            override fun onErrorResponse(volleyError: VolleyError) {
                var message: String? = null
                if (volleyError is NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!"
                } else if (volleyError is ServerError) {
                    message = "The server could not be found. Please try again after some time!!"
                } else if (volleyError is AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!"
                } else if (volleyError is ParseError) {
                    message = "Parsing error! Please try again after some time!!"
                } else if (volleyError is NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!"
                } else if (volleyError is TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection."
                }
                Log.d("ERROR", "@@" + message)
                pDialog.hide()
            }
        })
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }


}
