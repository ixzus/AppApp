package com.eeepay.appuser.ui;

import com.eeepay.appuser.data.webservice.entity.ProductRst;

/**
 * Created by huan on 2017/11/28.
 */

public interface ProductContract {

    interface Presenter {
        void getProduct(String type, int pageSize, int pageNo, boolean isRefresh);
    }

    interface View {

        void refresh(ProductRst productRst);

        void loadmore(ProductRst productRst);

        void showSuccess();

        void showError();

    }
}
