package com.guiying.module.cardgirl.ui.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guiying.module.cardgirl.R;
import com.guiying.module.common.base.BaseActionBarActivity;
import com.guiying.module.common.base.BasePresenter;
import com.guiying.module.cardgirl.ui.impl.data.UserAdapter;
import com.guiying.module.cardgirl.ui.impl.data.bean.Girl;
import com.guiying.module.cardgirl.ui.impl.presenter.ICardGirlPresenter;
import com.guiying.module.cardgirl.ui.impl.presenter.impl.CardGirlPresenter;
import com.guiying.module.cardgirl.ui.impl.ui.ICardGirlView;
import com.zc.swiple.SwipeFlingView;

import java.util.List;


/**
 * Desc: 卡片女孩 的 CardGirlActivity
 * Company: XueHai
 *
 * @author hc
 */
@Route(path = "/card_girl/card")
public class CardGirlActivity extends BaseActionBarActivity implements ICardGirlView, SwipeFlingView.OnItemClickListener {

    SwipeFlingView mLayoutSwipeFling;
    private Button btnShow;
    private BasePresenter mPresenter;


    @Override
    protected int setTitleId() {
        return R.string.card_girls_activity_title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_girl);
        mLayoutSwipeFling = this.findViewById(R.id.layout_swipe_fling);
        btnShow = this.findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/card_girl/webview").navigation();
            }
        });

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
