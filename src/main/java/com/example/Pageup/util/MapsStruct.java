package com.example.Pageup.util;

import com.example.Pageup.entity.Registration;
import com.example.Pageup.payload.PostDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MapsStruct {
    Registration mapToEntity(PostDto postDto);
    PostDto mapToDto(Registration registration);
    @Mapping(target = "id", ignore = true)
    void updateRegistration(PostDto postDto,@MappingTarget Registration registration);

}
