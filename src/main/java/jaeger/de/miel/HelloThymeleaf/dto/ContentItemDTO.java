package jaeger.de.miel.HelloThymeleaf.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@JsonIgnoreProperties(value = { "url" })
public class ContentItemDTO {
    private String name;
    private String size;
    private long sizeInBytes;
    private LocalDateTime last_modified;
    @ToString.Exclude private String url;
}
