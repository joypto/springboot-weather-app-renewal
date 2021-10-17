package com.renewal.weatherservicev2.service.raw_data;

import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living.UVIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.health.abstr.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.service.connection.ConnectionService;
import com.renewal.weatherservicev2.service.parser.LivingAndHealthJsonParser;
import com.renewal.weatherservicev2.util.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class LivingAndHealthIdxServiceTest {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private LivingAndHealthJsonParser livingAndHealthJsonParser;

    @Test
    void connectAndParsedResponse() {

        OpenApiRequestInterface request = UVIdxRequestVO.builder()
                .admCode("1100000000")
                .date(DateTime.getYesterdayYYYYMMDD())
                .build();

        URL url = request.makeUrl();
        String  data = connectionService.connect(url);

        LivingAndHealthResponseVO response = livingAndHealthJsonParser.parseFrom(data);
        System.out.println(response.toString());
    }
}