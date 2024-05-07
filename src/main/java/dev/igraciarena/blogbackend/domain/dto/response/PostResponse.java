package dev.igraciarena.blogbackend.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Data
@EqualsAndHashCode
@Builder(builderClassName = "Builder")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponse {
    String title;
    @JsonProperty(value = "sub_title")
    String subTitle;
    String content;
    @JsonProperty(value = "created_date")
    LocalDateTime createdDate;
}
