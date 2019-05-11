package com.tj.banklistfromserver.utils;

import android.content.Context;

import org.json.JSONObject;

public class ConnectServer {

    // 서버의 근본 주소
    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    // 서버 응답 처리하는 인터페이스
    public interface JsonResponseHandler {

        void onResponse(JSONObject json);
    }

    // 필요한 서버의 요청들을 하나하나 메소드로 만든다.
    public static void getRequestInfoBank(Context context, /* 필요한 파라미터용 변수들 */final JsonResponseHandler handler) {

    }


}
