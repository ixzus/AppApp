package com.eeepay.appuser.data.webservice;

import com.eeepay.appuser.data.webservice.entity.ProductRst;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by huan on 2017/11/28.
 */

public interface WebService {

    @GET("data/{type}/{pageSize}/{pageNo}")
    Observable<ProductRst> getDryGoods(@Path("type") String type, @Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

}
