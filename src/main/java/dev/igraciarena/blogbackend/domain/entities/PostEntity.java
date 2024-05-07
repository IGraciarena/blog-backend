package dev.igraciarena.blogbackend.domain.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Value
@EqualsAndHashCode
@Builder
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "post")
public class PostEntity {
    @Id
    String uuid;
    String title;
    @Field(value = "sub_title")
    String subTitle;
    String content;
    @Field(value = "created_date")
    LocalDateTime createdDate;
}
