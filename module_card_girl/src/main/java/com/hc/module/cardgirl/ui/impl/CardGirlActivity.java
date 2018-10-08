package com.hc.module.cardgirl.ui.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.base.BaseActionBarActivity;
import com.guiying.module.common.base.BasePresenter;
import com.hc.module.cardgirl.R;
import com.hc.module.cardgirl.data.UserAdapter;
import com.hc.module.cardgirl.data.bean.Girl;
import com.hc.module.cardgirl.presenter.ICardGirlPresenter;
import com.hc.module.cardgirl.presenter.impl.CardGirlPresenter;
import com.hc.module.cardgirl.ui.ICardGirlView;
import com.zc.swiple.SwipeFlingView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc: 卡片女孩 的 CardGirlActivity
 * Company: XueHai
 *
 * @author hc
 */
@Route(path = "/card_girl/card")
public class CardGirlActivity extends BaseActionBarActivity implements ICardGirlView, SwipeFlingView.OnItemClickListener {

    @BindView(R.id.layout_swipe_fling)
    SwipeFlingView mLayoutSwipeFling;
    private BasePresenter mPresenter;


    @Override
    protected int setTitleId() {
        return R.string.card_girls_activity_title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_girl);
        ButterKnife.bind(this);
        mLayoutSwipeFling = ButterKnife.findById(this, R.id.layout_swipe_fling);

        mPresenter = new CardGirlPresenter(this);
        mPresenter.start();

    }


    @Override
    public void refresh(List<Girl> data) {
        UserAdapter mAdapter = new UserAdapter(this, data);
        mLayoutSwipeFling.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mLayoutSwipeFling.setFlingListener(new SwipeFlingView.onSwipeListener() {
            /**
             * 拖拽开始时调用
             */
            @Override
            public void onStartDragCard() {

            }

            /**
             * 用来判断是否允许卡片向左离开(fling)
             *
             * @return true:允许卡片向左离开(fling)
             */
            @Override
            public boolean canLeftCardExit() {
                return true;
            }

            /**
             * 用来判断是否允许卡片向右离开(fling)
             *
             * @return true:允许卡片向右离开(fling)
             */
            @Override
            public boolean canRightCardExit() {
                return true;
            }

            @Override
            public void onPreCardExit() {

            }

            /**
             * 在卡片向左完全离开时，会回调此函数
             *
             * @param view               当前的view
             * @param o
             * @param b 若true:表示此次卡片离开是来之于手势拖拽 反之则来之于点击按钮触发之类的
             */
            @Override
            public void onLeftCardExit(View view, Object o, boolean b) {

            }

            /**
             * 在卡片向右完全离开时，会回调此函数
             *
             * @param view               当前的view
             * @param o
             * @param b 若true:表示此次卡片离开是来之于手势拖拽 反之则来之于点击按钮触发之类的
             */
            @Override
            public void onRightCardExit(View view, Object o, boolean b) {

            }

            @Override
            public void onSuperLike(View view, Object o, boolean b) {

            }

            @Override
            public void onTopCardViewFinish() {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onAdapterEmpty() {

            }

            @Override
            public void onScroll(View view, float v) {

            }

            @Override
            public void onEndDragCard() {

            }
        });
        mLayoutSwipeFling.setOnItemClickListener(this);
    }

    @Override
    public void load(List<Girl> data) {
        UserAdapter mAdapter = new UserAdapter(this, data);
        mLayoutSwipeFling.setAdapter(mAdapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void setPresenter(ICardGirlPresenter presenter) {

    }

    @Override
    public void onItemClicked(int i, Object o) {
        Toast.makeText(this, "点一点", Toast.LENGTH_LONG).show();
    }
}
