package com.guiying.module.cardgirl.ui.impl.model;

import com.guiying.module.cardgirl.ui.impl.data.bean.GirlsParser;

/**
 * Desc: 卡片女孩 的 ICardGirlModel
 * Company: XueHai
 *
 * @author hc
 */
public interface ICardGirlModel {

    void getGirls(int size, int page, LoadGirlsCallback loadGirlsCallback);

    public interface LoadGirlsCallback {
        void onGirlsLoaded(GirlsParser girlsParser);

        void onDataNotAvailable();
    }
}
