package com.hc.module.cardgirl.presenter;

import com.guiying.module.common.base.BasePresenter;

/**
 * Desc: 卡片女孩 的 ICardGirlPresenter
 * Company: XueHai
 *
 * @author hc
 */
public interface ICardGirlPresenter extends BasePresenter {
    void getGirls(int page, int size, boolean isRefresh);
}
