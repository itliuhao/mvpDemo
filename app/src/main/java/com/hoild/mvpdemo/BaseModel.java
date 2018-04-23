package com.hoild.mvpdemo;

import java.util.Map;

/**
 * author liuhao
 * time 2018/4/23
 */
public abstract class BaseModel<T> {

    //数据请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     */
    public BaseModel params(String... args) {
        mParams = args;
        return this;
    }

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(Callback<T> callback);

    // 执行Get网络请求，此类看需求由自己选择写与不写
    protected void requestGetAPI(String url, Callback<T> callback) {
        //这里写具体的网络请求
    }

    // 执行Post网络请求，此类看需求由自己选择写与不写
    protected void requestPostAPI(String url, Map params, Callback<T> callback) {
        //这里写具体的网络请求
    }
}
