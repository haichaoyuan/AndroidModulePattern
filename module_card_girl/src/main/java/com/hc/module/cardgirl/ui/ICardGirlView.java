package com.hc.module.cardgirl.ui;


import com.guiying.module.common.base.BaseView;
import com.hc.module.cardgirl.data.bean.Girl;
import com.hc.module.cardgirl.presenter.ICardGirlPresenter;

import java.util.List;

/**
 * Desc: 卡片女孩 的 ICardGirlView
 * Company: XueHai
 *
 * @author hc
 */
public interface ICardGirlView extends BaseView<ICardGirlPresenter> {
    void refresh(List<Girl> data);

    void load(List<Girl> data);

    void showError();

    void showNormal();
}
