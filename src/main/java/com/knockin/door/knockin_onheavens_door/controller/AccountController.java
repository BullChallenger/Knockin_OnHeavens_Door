package com.knockin.door.knockin_onheavens_door.controller;

import com.knockin.door.knockin_onheavens_door.dto.ResponseDTO;
import com.knockin.door.knockin_onheavens_door.dto.UserDTO.*;
import com.knockin.door.knockin_onheavens_door.service.UserService;
import com.knockin.door.knockin_onheavens_door.vo.UserVO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class AccountController extends AbstractController {

    private final UserService userService;

    @PostMapping(value = "/create")
    public ResponseDTO<UserCreateResponseVO> create(@RequestBody UserCreateRequestVO vo) {
        UserCreateResponseDTO response = userService.create(UserCreateRequestDTO.of(vo));
        UserCreateResponseVO result = UserCreateResponseVO.from(response);

        return ResponseDTO.ok(result);
    }

    @PutMapping(value = "/update")
    public ResponseDTO<UserUpdateVO> update(@RequestBody UserUpdateVO vo) {
        UserUpdateDTO response = userService.update(UserUpdateDTO.of(vo));
        UserUpdateVO result = UserUpdateVO.from(response);

        return ResponseDTO.ok(result);
    }

    @GetMapping(value = "/{userId}/read")
    public ResponseDTO<UserReadResponseVO> read(@PathVariable Long userId) {
       UserReadResponseDTO response = userService.read(userId);
       UserReadResponseVO result = UserReadResponseVO.from(response);

       return ResponseDTO.ok(result);
    }

    @PutMapping(value = "/delete")
    public ResponseDTO<Void> delete(@RequestBody UserDeleteRequestVO vo) {
        userService.delete(UserDeleteRequestDTO.of(vo));
        return ok();
    }
}
