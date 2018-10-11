package com.guiying.module.cardgirl.ui.impl.ui;


import com.guiying.module.common.base.BaseView;
import com.guiying.module.cardgirl.ui.impl.data.bean.Girl;
import com.guiying.module.cardgirl.ui.impl.presenter.ICardGirlPresenter;

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
