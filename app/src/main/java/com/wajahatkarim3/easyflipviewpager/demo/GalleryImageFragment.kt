package com.wajahatkarim3.easyflipviewpager.demo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class GalleryImageFragment : Fragment() {

    internal var title = ""
    internal var description = ""
    internal var imageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            imageId = it.getInt("imageId", R.drawable.ic_launcher_background)
            title = it.getString("title", "")
            description = it.getString("description", "")
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_gallery_page_layout, container, false)

        val imageView = rootView.findViewById<ImageView>(R.id.imageView)
        val txtTitle = rootView.findViewById<TextView>(R.id.txtTitle)
        val txtDescription = rootView.findViewById<TextView>(R.id.txtDescription)

        txtTitle.text = title
        txtDescription.text = description
        imageView.setImageResource(imageId)

        return rootView
    }

    companion object {
        fun newInstance(title: String, subtitle: String, imageId: Int): GalleryImageFragment
        {
            val fragment = GalleryImageFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putString("description", subtitle)
            args.putInt("imageId", imageId)
            fragment.arguments = args
            return fragment
        }
    }


}