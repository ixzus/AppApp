package com.eeepay.appuser.data;

import com.eeepay.appuser.data.webservice.RxRetrofit;
import com.eeepay.appuser.data.webservice.entity.ProductRst;
import com.eeepay.modulebase.net.DataCallBack;
import com.eeepay.modulebase.net.NetObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huan on 2017/11/28.
 */

public class ProductRepository implements IProduct {

    @Override
    public void getProduct(String type, int pageSize, int pageNo, final DataCallBack callBack) {
        RxRetrofit.getInstance()
                .getWebService()
                .getDryGoods(type, pageSize, pageNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NetObserver<ProductRst>("getDryGoods", 0) {
                    @Override
                    public void onSuccess(int whichRequest, ProductRst productRst) {
                        callBack.onSuccess(productRst);
                    }

                    @Override
                    public void onError(int code, String errorMessage) {
                        callBack.onError(code, errorMessage);
                    }
                });

    }
}
