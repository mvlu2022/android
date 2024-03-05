package com.android.myapplication.practical3b

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidpracticals3.R

//  Adapter acts as a bridge between the UI component and data sources
class MainAdapter(
    private val context: Context,
    private val gridText: Array<String>,
    private val gridImage: IntArray
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun getCount(): Int {
        return gridText.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup): View? {

        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.row_item, null)
        }

        imageView = convertView!!.findViewById(R.id.imageView)
        textView = convertView.findViewById(R.id.textView)

        imageView.setImageResource(gridImage[position])
        textView.text = gridText[position]

        return convertView
    }
}
