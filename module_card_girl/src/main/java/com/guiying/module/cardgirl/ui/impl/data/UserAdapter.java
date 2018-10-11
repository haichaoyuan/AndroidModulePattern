package com.guiying.module.cardgirl.ui.impl.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.guiying.module.cardgirl.R;
import com.guiying.module.cardgirl.ui.impl.data.bean.Girl;
import com.guiying.module.cardgirl.ui.impl.view.CardImageView;
import com.guiying.module.cardgirl.ui.impl.view.SwipeIndicatorView;

import java.util.List;


/**
 * Author: hc
 * DATE: 2018/10/8 = 上午11:27
 */
public class UserAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Girl> mList;

    public UserAdapter(Context context, List<Girl> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.swipe_fling_item, parent, false);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        Girl cardEntity = ((Girl) getItem(position));
        holder.likeIndicator.reset();
        holder.unLikeIndicator.reset();
        holder.nameView.setText(cardEntity.getWho());
        holder.addressView.setText(cardEntity.getDesc());
        holder.img.reset();
        holder.img.setUser(cardEntity);

        if(holder.img != null){
            Glide.with(holder.img.getContext())
                    .load(cardEntity.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.img);
        }
        return convertView;
    }

    static class ViewHolder {
        FrameLayout cardLayout;
        CardImageView img;
        TextView nameView;
        TextView addressView;
        SwipeIndicatorView likeIndicator;
        SwipeIndicatorView unLikeIndicator;
        TextView mFriendCountTv;
        TextView mInterestCountTv;
        ViewGroup mBottomLayout;

        ViewHolder(View rootView) {
            cardLayout = (FrameLayout) rootView;
            img = rootView.findViewById(R.id.item_img);
            nameView = rootView.findViewById(R.id.item_name);
            addressView = rootView.findViewById(R.id.item_address);
            likeIndicator = rootView.findViewById(R.id.item_swipe_like_indicator);
            unLikeIndicator = rootView.findViewById(R.id.item_swipe_unlike_indicator);
            mFriendCountTv = rootView.findViewById(R.id.item_friend_count);
            mInterestCountTv = rootView.findViewById(R.id.item_interest_count);
            mBottomLayout = rootView.findViewById(R.id.item_bottom_layout);
        }

        @Override
        public String toString() {
            return "[Card:" + nameView.getText() + "]";
        }
    }

}
