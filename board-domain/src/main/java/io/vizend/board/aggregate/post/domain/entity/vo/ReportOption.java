package io.vizend.board.aggregate.post.domain.entity.vo;

import io.vizend.accent.domain.entity.ValueObject;
import io.vizend.accent.util.json.JsonUtil;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportOption implements ValueObject {
    //
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private AlarmMethod alarmMethod;
    private boolean reportMe;


    public static ReportOption defaultOption() {
        //
        return ReportOption
                .builder()
                .startDate(LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .startTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
                .endDate(LocalDate.now().plusDays(3).format(DateTimeFormatter.ISO_DATE))
                .endTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
                .alarmMethod(AlarmMethod.Email)
                .reportMe(true)
                .build();
    }

    public static ReportOption fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ReportOption.class);
    }

    public static ReportOption sample() {
        //
        return defaultOption();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String toString() {
        //
        return toJson();
    }
}
