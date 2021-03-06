package com.nickteck.colormecrazy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.model.ContentListData;

import java.util.ArrayList;

/**
 * Created by admin on 8/7/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private ArrayList<ContentListData> images;
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, ArrayList<ContentListData> images) {
        this.images = images;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate( R.layout.image_layout, null);
        assert view != null;
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position).getImage_drawable());


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
