package com.eeepay.appuser;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.eeepay.appuser.data.webservice.entity.ProductRst;
import com.eeepay.appuser.databinding.ActivityUserBinding;
import com.eeepay.appuser.ui.ProductContract;
import com.eeepay.appuser.ui.ProductPresenter;
import com.eeepay.modulebase.router.ArouterPath;
import com.eeepay.modulebase.base.BaseBindingActivity;

@Route(path = ArouterPath.UserActivity)
public class UserActivity extends BaseBindingActivity<ActivityUserBinding> implements ProductContract.View {
    private ProductContract.Presenter mPresenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_user;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
    }

    @Override
    protected void initData() {
        mPresenter = new ProductPresenter(this, null);
        //加载数据
        mPresenter.getProduct("Android", 10, 1, true);

    }


    @Override
    public void refresh(ProductRst productRst) {
        binding.setProduct(productRst.getResults().get(0));
    }

    @Override
    public void loadmore(ProductRst productRst) {
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

}
