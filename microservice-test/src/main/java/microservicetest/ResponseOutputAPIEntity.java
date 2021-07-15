package microservicetest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResponseOutputAPIEntity {

    public String message;

    //@JsonFormat(pattern = "MMM. dd. yyyy")
  //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
   //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MMM. dd. yyyy")
    @JsonDeserialize(using = CustomLocalDateTimeDeSerializer.class)
//    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    public LocalDate createdDate;

    @JsonFormat(pattern = "HH:mm:ss a")
    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    public LocalTime createdTime;

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
