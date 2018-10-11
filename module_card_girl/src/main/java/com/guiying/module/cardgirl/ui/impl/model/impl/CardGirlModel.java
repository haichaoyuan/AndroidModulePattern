package com.guiying.module.cardgirl.ui.impl.model.impl;

import com.guiying.module.common.http.DataType;
import com.guiying.module.common.http.HttpClient;
import com.guiying.module.common.http.OnResultListener;
import com.guiying.module.cardgirl.ui.impl.data.bean.GirlsParser;
import com.guiying.module.cardgirl.ui.impl.model.ICardGirlModel;

/**
 * Desc: 卡片女孩 的 CardGirlModel
 * Company: XueHai
 *
 * @author hc
 */
public class CardGirlModel implements ICardGirlModel {
    String GAN_HUO_API = "http://gank.io/api/data/";

    @Override
    public void getGirls(int size, int page, LoadGirlsCallback callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(GAN_HUO_API)
                .url("福利/" + size + "/" + page)
                .bodyType(DataType.JSON_OBJECT, GirlsParser.class)
                .build();
        client.get(new OnResultListener<GirlsParser>() {

            @Override
            public void onSuccess(GirlsParser result) {
                callback.onGirlsLoaded(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(String message) {
                callback.onDataNotAvailable();
            }
        });
    }
}
