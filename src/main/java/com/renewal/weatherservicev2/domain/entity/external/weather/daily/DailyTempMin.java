package com.renewal.weatherservicev2.domain.entity.external.weather.daily;

import com.renewal.weatherservicev2.domain.entity.external.abstr.DailyWeather;
import com.renewal.weatherservicev2.domain.vo.openapi.response.weather.DailyWeatherRes;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyTempMin implements DailyWeather {

    @Id
    @Column(name = "daily_temp_min_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;

    public void setDataByDay(DailyWeatherRes request, int day) {
        switch (day) {
            case 1:
                this.day1 = request.getTempMin();
                break;
            case 2:
                this.day2 = request.getTempMin();
                break;
            case 3:
                this.day3 = request.getTempMin();
                break;
            case 4:
                this.day4 = request.getTempMin();
                break;
            case 5:
                this.day5 = request.getTempMin();
                break;
            case 6:
                this.day6 = request.getTempMin();
                break;
            case 7:
                this.day7 = request.getTempMin();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
