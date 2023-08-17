package com.knockin.door.knockin_onheavens_door.service;

import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import com.knockin.door.knockin_onheavens_door.dto.UserDTO.*;
import com.knockin.door.knockin_onheavens_door.exception.BaseException;
import com.knockin.door.knockin_onheavens_door.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserCreateResponseDTO create(UserCreateRequestDTO dto, PasswordEncoder bCryptPasswordEncoder) {
        UserEntity theUser  = UserEntity.of(
                                    dto.getEmail(),
                                    dto.getNickName(),
                                    bCryptPasswordEncoder.encode(dto.getPassword()),
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
            theUser.updateEmail(dto.getEmail());
        }

        if (dto.getNickName() != null) {
            theUser.updateNickName(dto.getNickName());
        }

        if (dto.getName() != null) {
            theUser.updateName(dto.getName());
        }

        return UserUpdateDTO.from( userRepository.saveAndFlush(theUser) );
    }

    public UserReadResponseDTO read(Long userId) {
        UserEntity theUser = userRepository.findByUserId(userId).orElseThrow(
                () -> new BaseException(ResultType.NOT_FOUND)
        );
        return UserReadResponseDTO.from(theUser);
    }

    public void delete(UserDeleteRequestDTO dto) {
        UserEntity theUser = userRepository.findByUserId(dto.getUserId()).orElseThrow(
                () -> new BaseException(ResultType.NOT_FOUND)
        );
        theUser.updateIsDeleted(true);
        userRepository.saveAndFlush(theUser);
    }
}
