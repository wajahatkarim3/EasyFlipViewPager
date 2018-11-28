package com.wajahatkarim3.easyflipviewpager.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BookPageIntroFragment extends Fragment {

    String title = "";
    String subtitle = "";
    int imageId;

    public static BookPageIntroFragment newInstance(String title, String subtitle, int imageId)
    {
        BookPageIntroFragment fragment = new BookPageIntroFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("subtitle", subtitle);
        args.putInt("imageId", imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageId = getArguments().getInt("imageId", R.drawable.ic_launcher_background);
        title = getArguments().getString("title", "");
        subtitle = getArguments().getString("subtitle", "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_page_layout, container, false);

        ImageView imageView = rootView.findViewById(R.id.imageView);
        TextView txtTitle = rootView.findViewById(R.id.textView2);
        TextView txtSubTitle = rootView.findViewById(R.id.textView3);

        txtTitle.setText(title);
        txtSubTitle.setText(subtitle);
        imageView.setImageResource(imageId);

        if (imageId == R.drawable.all_about_reading)
            rootView.setTag(21);
        else
            rootView.setTag(40);

        return rootView;
    }
}
