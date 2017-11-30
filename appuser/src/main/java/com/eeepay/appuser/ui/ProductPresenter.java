package com.eeepay.appuser.ui;

import com.eeepay.appuser.data.ProductRepository;
import com.eeepay.appuser.data.webservice.entity.ProductRst;
import com.eeepay.modulebase.net.DataCallBack;

/**
 * Created by huan on 2017/11/28.
 */

public class ProductPresenter implements ProductContract.Presenter {

    private ProductContract.View mView;
    private ProductRepository mRepository;

    public ProductPresenter(ProductContract.View mView, ProductRepository mRepository) {
        this.mView = mView;
//        this.mRepository = mRepository;
        this.mRepository = new ProductRepository();
    }

    @Override
    public void getProduct(String type, int pageSize, int pageNo, final boolean isRefresh) {
        mRepository.getProduct(type, pageSize, pageNo, new DataCallBack<ProductRst>() {
            @Override
            public void onSuccess(ProductRst data) {
                if (isRefresh) {
                    mView.refresh(data);
                } else {
                    mView.loadmore(data);
                }
                mView.showSuccess();
            }

            @Override
            public void onError(int code, String errorMessage) {
                if (isRefresh) {
                    mView.showError();
                }
            }
        });
    }
}
