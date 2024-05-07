package dev.igraciarena.blogbackend.mapper;

import dev.igraciarena.blogbackend.domain.dto.request.PostCreateRequest;
import dev.igraciarena.blogbackend.domain.dto.request.PostUpdateRequest;
import dev.igraciarena.blogbackend.domain.dto.response.PostResponse;
import dev.igraciarena.blogbackend.domain.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResponse mapToResponse(final PostEntity post);

    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    PostEntity mapToEntity(final PostCreateRequest post);

    @Mapping(source = "post.uuid", target = "uuid")
    @Mapping(source = "postUpdate.title", target = "title")
    @Mapping(source = "postUpdate.subTitle", target = "subTitle")
    @Mapping(source = "postUpdate.content", target = "content")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    PostEntity mapToUpdated(final PostEntity post, final PostUpdateRequest postUpdate);

    List<PostResponse> mapToResponseList(final List<PostEntity> post);
}
