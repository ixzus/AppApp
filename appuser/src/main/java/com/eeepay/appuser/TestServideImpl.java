package com.eeepay.appuser;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.eeepay.modulebase.router.ArouterPath;
import com.eeepay.modulebase.service.ITestService;

/**
 * Created by huan on 2017/11/29.
 */
@Route(path = ArouterPath.TestService , name = "测试服务")
public class TestServideImpl implements ITestService {
    @Override
    public String getValue(String key) {
        Log.e("TAG", "service: getvalue" + key);
        return "key:"+key;
    }

    @Override
    public void init(Context context) {
        // sdk
        Log.e("TAG", "service: init");
    }
}
