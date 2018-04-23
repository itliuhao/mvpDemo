package com.hoild.mvpdemo;

/**
 * author liuhao
 * time 2018/4/23
 */
public class MvpPresenter extends BasePresenter<MvpView> {
    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String... params) {
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }
        //显示正在加载进度条
        getView().showLoading();

        DataModel.request(MvpModel.class.getName())
                .params(params)
                .execute(new Callback<String>() {

                    @Override
                    public void onSuccess(String data) {
                        getView().showData(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        getView().showToast(msg);
                    }

                    @Override
                    public void onError() {
                        getView().showErr();
                    }

                    @Override
                    public void onComplete() {
                        getView().hideLoading();
                    }
                });
    }
}
