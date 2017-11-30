package com.eeepay.appuser.data;

import com.eeepay.modulebase.net.DataCallBack;

/**
 * Created by huan on 2017/11/28.
 */

public interface IProduct {

    void getProduct(String type, int pageSize, int pageNo, final DataCallBack callBack);

}
