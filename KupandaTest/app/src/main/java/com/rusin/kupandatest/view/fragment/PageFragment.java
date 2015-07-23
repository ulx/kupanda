package com.rusin.kupandatest.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rusin.kupandatest.R;
import com.rusin.kupandatest.net.object.ItemsResponse;

/**
 * Created by alexander on 23.07.15.
 */
public class PageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backColor;
    private ImageView mImage;
    private TextView mText;
    private ItemsResponse.KuItem mItem;

    public static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_item, null);
        mImage = (ImageView) view.findViewById(R.id.recycler_image);
        mText = (TextView)view.findViewById(R.id.recycler_text);

        mText.setText(mItem.title_75 );

        Glide.with(getActivity()).load(mItem.image_item)
                .fitCenter()
                .into(mImage);
        return view;
    }

    public void setContent(ItemsResponse.KuItem item) {
         mItem = item;

    }
}
