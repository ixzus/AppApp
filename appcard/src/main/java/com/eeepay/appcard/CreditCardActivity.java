package com.eeepay.appcard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.eeepay.appcard.databinding.ActivityCreditCardBinding;
import com.eeepay.modulebase.base.BaseBindingActivity;
import com.eeepay.modulebase.router.ArouterPath;
import com.eeepay.modulebase.service.RouterService;

@Route(path = ArouterPath.CreditCardActivity)
public class CreditCardActivity extends BaseBindingActivity<ActivityCreditCardBinding> {

    @Override
    protected int initLayout() {
        return R.layout.activity_credit_card;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
    }

    @Override
    protected void initData() {
        CreditCardInfo info = new CreditCardInfo();
        info.setName("aaaaaaaaaaa");
        binding.setCardinfo(info);
        String value = RouterService.getValue("gogogo");
        if (!TextUtils.isEmpty(value)) {
            info = new CreditCardInfo();
            info.setName(value);
            binding.setCardinfo(info);
        }
    }

    public void gotonext(View view) {
        Log.e("TAG", "gotonext: click");
        ArouterPath.startUserActivity("1111");
    }

}
