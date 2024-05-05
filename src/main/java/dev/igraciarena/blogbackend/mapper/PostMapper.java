package dev.igraciarena.blogbackend.mapper;

import dev.igraciarena.blogbackend.domain.dto.PostResponse;
import dev.igraciarena.blogbackend.domain.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResponse mapToResponse(PostEntity post);

    List<PostResponse> mapToResponseList(List<PostEntity> post);
}
