package com.tj.banklistfromserver.utils;

import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectServer {

    // 서버의 근본 주소
    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    // 서버 응답 처리하는 인터페이스
    public interface JsonResponseHandler {

        void onResponse(JSONObject json);
    }

    // 필요한 서버의 요청들을 하나하나 메소드로 만든다.
    public static void getRequestInfoBank(Context context, /* 필요한 파라미터용 변수들 */final JsonResponseHandler handler) {

        // 서버 <=> 클라이언트 (앱)
        OkHttpClient client = new OkHttpClient();

        // URL 설정 => 목적지 설정
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL+"/info/bank").newBuilder();

        // * GET, DELETE 메소드는 필요 파라미터를 URL에 담아줘야함
        // 이 과정을 쉽게 하려고 urlBuilder를 사용한다.

        // 실제로 서버에 접근하는 완성된 url
        String requestURL = urlBuilder.build().toString();

        // 완성된 url로 접근하는 request를 생성 (인텐트와 비슷)
        Request request = new Request.Builder().url(requestURL).build();

        // 만들어진 Request를 실제로 서버에 요청 (onClickListener와 비슷)
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseContent = response.body().string();

                Log.d("서버응답 내용", responseContent);
            }
        });
    }


}
