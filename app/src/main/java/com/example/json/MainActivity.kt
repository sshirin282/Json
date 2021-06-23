package com.example.json

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val url:String="https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Object.JSON"
    lateinit var textView1: TextView
    lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = findViewById(R.id.text1)
        textView2 = findViewById(R.id.text2)
        val request: StringRequest =
            StringRequest(Request.Method.GET, url, Response.Listener {
                    response ->
                Log.e("response>>", response)
                val jsonObject:JSONObject= JSONObject(response)
                val jsonObject1:JSONObject= jsonObject.getJSONObject("colorObject")
                val name:String=jsonObject1.getString("colorName")
                textView1.text=name
                val name2:String=jsonObject1.getString("description")
                textView2.text=name2

            },Response.ErrorListener {

            })
        val  requestQueue = Volley.newRequestQueue(this)
        requestQueue?.add(request)
    }
}
