package com.example.gaoying20190308.net;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private static OkHttpUtils mIntstance;
    private final OkHttpClient okHttpClient;
    private Handler handler=new Handler();
    //单列模式
    public static OkHttpUtils getmIntstance(){
        if (mIntstance==null){
            synchronized (OkHttpUtils.class){
                if (mIntstance==null){
                   mIntstance= new OkHttpUtils();
                }
            }
        }
        return mIntstance;
    }

    private OkHttpUtils(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       okHttpClient= new OkHttpClient.Builder()
               .addInterceptor(loggingInterceptor)
               .writeTimeout(5,TimeUnit.SECONDS)
               .readTimeout(5,TimeUnit.SECONDS)
               .connectTimeout(5,TimeUnit.SECONDS)
               .build();

    }

    //doget
    public void doGet(String url, final OkHttpCallBack okHttpCallBack){
        Request build = new Request.Builder().url(url).get().build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okHttpCallBack.Failure("请求失败");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    if (response.code()==200){
                        final String string = response.body().string();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                okHttpCallBack.success(string);
                            }
                        });
                    }
            }
        });
    }

    //dopost
    public void dopost(String url, HashMap<String,String>params,final OkHttpCallBack callBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String>map:params.entrySet()){
            builder.add(map.getKey(),map.getValue());
        }
        RequestBody requestBody=builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.Failure("网络请求失败");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callBack!=null){
                    if (response.code()==200){
                        final String string = response.body().string();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.success(string);
                            }
                        });
                    }
                }
            }
        });

    }
}
