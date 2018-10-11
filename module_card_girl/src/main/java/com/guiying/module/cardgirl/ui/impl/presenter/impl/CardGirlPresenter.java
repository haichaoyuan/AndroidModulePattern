package com.guiying.module.cardgirl.ui.impl.presenter.impl;

import com.guiying.module.cardgirl.ui.impl.data.bean.GirlsParser;
import com.guiying.module.cardgirl.ui.impl.model.ICardGirlModel;
import com.guiying.module.cardgirl.ui.impl.model.impl.CardGirlModel;
import com.guiying.module.cardgirl.ui.impl.presenter.ICardGirlPresenter;
import com.guiying.module.cardgirl.ui.impl.ui.ICardGirlView;

/**
 * Desc: 卡片女孩 的 CardGirlPresenter
 * Company: XueHai
 *
 * @author hc
 */
public class CardGirlPresenter implements ICardGirlPresenter {
    private ICardGirlView mView;
    private ICardGirlModel mCardGirlModel;

    public CardGirlPresenter(ICardGirlView iCardGirlView) {
        this.mView = iCardGirlView;
        this.mCardGirlModel = new CardGirlModel();
    }

    @Override
    public void getGirls(int page, int size, boolean isRefresh) {
        mCardGirlModel.getGirls(size, page, new ICardGirlModel.LoadGirlsCallback() {
            @Override
            public void onGirlsLoaded(GirlsParser girlsParser) {
                if (isRefresh) {
                    mView.refresh(girlsParser.getResults());
                } else {
                    mView.load(girlsParser.getResults());
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                if (isRefresh) {
                    mView.showError();
                }
            }
        });
    }

    @Override
    public void start() {
        getGirls(1, 100, true);
    }
}
