package com.wajahatkarim3.easyflipviewpager.demo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GalleryImageFragment : Fragment() {

    internal var title = ""
    internal var description: String? = null
    internal var imageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            imageId = it.getInt("imageId", R.drawable.ic_launcher_background)
            title = it.getString("title", "")
            description = it.getString("description", null)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if(description != null)
        {
            val rootView = inflater.inflate(R.layout.fragment_gallery_page_layout, container, false)

            val imageView = rootView.findViewById<ImageView>(R.id.imageView)
            val txtTitle = rootView.findViewById<TextView>(R.id.txtTitle)
            val txtDescription = rootView.findViewById<TextView>(R.id.txtDescription)

            txtTitle.text = title
            txtDescription.text = description
            imageView.setImageResource(imageId)
            return rootView
        }
        else {
            val rootView = inflater.inflate(R.layout.fragment_demo_layout, container, false)

            val imageView = rootView.findViewById<ImageView>(R.id.imageView)
            val txtTitle = rootView.findViewById<TextView>(R.id.txtTitle)
            val btnLaunch = rootView.findViewById<Button>(R.id.btnLaunch)

            txtTitle.text = title
            imageView.setImageResource(imageId)
            btnLaunch.setOnClickListener {
                when(imageId)
                {
                    R.drawable.books_snap -> startActivity(Intent(context, BookOnboardingActivity::class.java))
                    R.drawable.gallery_snap -> startActivity(Intent(context, PictureGalleryDemoActivity::class.java))
                    R.drawable.poker_snap -> startActivity(Intent(context, PokerCardDemoActivity::class.java))
                }
            }

            return rootView
        }
    }

    companion object {
        fun newInstance(title: String, subtitle: String?, imageId: Int): GalleryImageFragment
        {
            val fragment = GalleryImageFragment()
            val args = Bundle()
            args.putString("title", title)
            subtitle?.let { args.putString("description", subtitle) }
            args.putInt("imageId", imageId)
            fragment.arguments = args
            return fragment
        }
    }


}