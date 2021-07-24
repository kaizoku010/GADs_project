package com.kaizoku.gadsporject

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.snackbar.Snackbar
import com.kaizoku.gadsporject.databinding.ActivityListBinding
import com.kaizoku.gadsporject.databinding.ContentListBinding
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*
import kotlinx.android.synthetic.main.activity_list.toolbar as toolbar1


class ListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityListBinding
    private lateinit var binding2: ContentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        binding2 = ContentListBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_list)

        setSupportActionBar(toolbar1)

            fab.setOnClickListener {
                val secondActivity = Intent(this@ListActivity,
                MainActivity::class.java)
                startActivity(secondActivity)

              }
        listView.adapter = ArrayAdapter(this@ListActivity,
            android.R.layout.simple_list_item_1,
            DataManager.notes )

            listView.setOnItemClickListener { parent,
                                              view, position, id ->
                val activityintent = Intent(this@ListActivity,
                    MainActivity::class.java)
                activityintent.putExtra(EXTRA_POSITION, position)
                startActivity(activityintent)
            }

    }

    override fun onResume() {
        super.onResume()
        (listView.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }


}