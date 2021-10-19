package com.renewal.weatherservicev2.service.raw_data.living_and_health.specific;

import com.renewal.weatherservicev2.domain.entity.external.living_and_health.AsthmaIdx;
import com.renewal.weatherservicev2.domain.entity.external.living_and_health.StrokeIdx;
import com.renewal.weatherservicev2.domain.vo.openapi.abstr.OpenApiRequestInterface;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.AsthmaIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.request.living_and_health.StrokeIdxRequestVO;
import com.renewal.weatherservicev2.domain.vo.openapi.response.living_and_health.LivingAndHealthResponseVO;
import com.renewal.weatherservicev2.repository.living_and_health.StrokeIdxRepository;
import com.renewal.weatherservicev2.service.connection.LivingAndHealthConnectionService;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.common.LivingAndHealthIdxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StrokeIdxService {

    private final StrokeIdxRepository strokeIdxRepository;
    private final LivingAndHealthConnectionService connectionService;

    public void getAndSaveData(String admCode, String date) {
        StrokeIdx strokeIdx = getData(admCode, date);
        saveData(strokeIdx);
    }

    public StrokeIdx getData(String admCode, String date) {
        OpenApiRequestInterface request = StrokeIdxRequestVO.builder()
                .admCode(admCode)
                .date(date)
                .build();

        LivingAndHealthResponseVO response = connectionService.connectAndGetParsedResponse(request);
        StrokeIdx data = new StrokeIdx();
        return data.from(response);
    }

    private void saveData(StrokeIdx strokeIdx) {
        strokeIdxRepository.save(strokeIdx);
    }

}
