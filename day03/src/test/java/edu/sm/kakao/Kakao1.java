package edu.sm.kakao;

import edu.sm.util.KakaoLocal;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;


@SpringBootTest
@Slf4j
class Kakao1 {

    @Value("${app.key.kakao_rest_key}")
    String key;

    @Test
    void contextLoads() throws Exception{
        String lat = "36.801572";
        String lng = "127.074947";
        String type= "병원";
        String result = "";
        result = (String) KakaoLocal.getContent(key, lat, lng, type);
        log.info(result);

    }

}