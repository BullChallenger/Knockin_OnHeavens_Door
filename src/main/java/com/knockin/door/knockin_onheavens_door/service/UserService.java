package com.knockin.door.knockin_onheavens_door.service;

import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import com.knockin.door.knockin_onheavens_door.dto.UserDTO.*;
import com.knockin.door.knockin_onheavens_door.exception.BaseException;
import com.knockin.door.knockin_onheavens_door.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserCreateResponseDTO create(UserCreateRequestDTO dto) {
        UserEntity theUser  = UserEntity.of(
                                    dto.getEmail(),
                                    dto.getNickName(),
                                    dto.getPassword(),
                                    dto.getName()
                              );
        UserEntity savedUserEntity = userRepository.save(theUser);
        return UserCreateResponseDTO.from(savedUserEntity);
    }

    public UserUpdateDTO update(UserUpdateDTO dto) {
        UserEntity theUser = userRepository.findByUserId(dto.getUserId()).orElseThrow(
                () -> new BaseException(ResultType.NOT_FOUND)
        );

        if (dto.getEmail() != null) {
            theUser = theUser.toBuilder().email(dto.getEmail()).build();
        }

        if (dto.getNickName() != null) {
            theUser = theUser.toBuilder().nickName(dto.getNickName()).build();
        }

        if (dto.getName() != null) {
            theUser = theUser.toBuilder().name(dto.getName()).build();
        }

        UserEntity updatedUser = userRepository.saveAndFlush(theUser);

        return UserUpdateDTO.from(updatedUser);
    }
}
