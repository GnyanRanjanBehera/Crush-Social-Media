package com.crush.crush_user_service.services;

import com.crush.crush_user_service.models.dtos.PageableResponse;
import com.crush.crush_user_service.models.dtos.UserDto;

public interface UserService {

    public UserDto fetchUserById(Integer userId);

    public PageableResponse<UserDto> fetchAllUser(int pageNumber,int pageSize,String sortBy, String sortDir);

    public UserDto updateUser(UserDto userDto);

    public  UserDto deleteUser(Integer userId);
}
