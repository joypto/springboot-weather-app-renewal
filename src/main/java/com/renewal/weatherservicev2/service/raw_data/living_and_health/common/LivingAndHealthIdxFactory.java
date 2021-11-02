package com.renewal.weatherservicev2.service.raw_data.living_and_health.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.exception.NonServicePeriodException;
import com.renewal.weatherservicev2.service.raw_data.living_and_health.specific.*;
import com.renewal.weatherservicev2.util.OpenApiType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LivingAndHealthIdxFactory {

    private final AsthmaIdxService asthmaIdxService;
    private final ColdIdxService coldIdxService;
    private final FoodPoisoningIdxService foodPoisoningIdxService;
    private final OakPollenIdxService oakPollenIdxService;
    private final PinePollenIdxService pinePollenIdxService;
    private final StrokeIdxService strokeIdxService;
    private final UvIdxService uvIdxService;
    private final WeedsPollenRiskIdxService weedsPollenRiskIdxService;

    public void callDataFromOpenApiAndSave(String type, String date, BigRegion bigRegion) {
        try {
            switch (type.toUpperCase()) {
                case OpenApiType.ASTHMA:
                    asthmaIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.COLD:
                    coldIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.FOOD_POISONING:
                    foodPoisoningIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.OAK_POLLEN_RISK:
                    oakPollenIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.PINE_POLLEN_RISK:
                    pinePollenIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.STROKE:
                    strokeIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.UV:
                    uvIdxService.callAndSaveData(date, bigRegion);
                    break;
                case OpenApiType.WEEDS_POLLEN_RISK:
                    weedsPollenRiskIdxService.callAndSaveData(date, bigRegion);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (NonServicePeriodException e) {
            log.error(e.getMessage());

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
