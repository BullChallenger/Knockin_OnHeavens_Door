package com.knockin.door.knockin_onheavens_door.dto;

import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import com.knockin.door.knockin_onheavens_door.vo.UserVO.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDTO {

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static final class UserCreateRequestDTO {

        private final String email;

        private final String password;

        private final String nickName;

        private final String name;

        public static final UserCreateRequestDTOBuilder builder(String email, String password, String nickName, String name) {
            return innerBuilder()
                                .email(email)
                                .password(password)
                                .nickName(nickName)
                                .name(name);
        }

        public static final UserCreateRequestDTO of(UserCreateRequestVO vo) {
            return UserCreateRequestDTO.builder(
                        vo.getEmail(),
                        vo.getPassword(),
                        vo.getNickName(),
                        vo.getName()
                    ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static final class UserCreateResponseDTO {

        private final Long userId;

        private final String email;

        private final String password;

        private final String nickName;

        private final String name;

        public static final UserCreateResponseDTOBuilder builder(Long userId, String email, String password, String nickName, String name) {
            return innerBuilder()
                    .userId(userId)
                    .email(email)
                    .password(password)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserCreateResponseDTO from(UserEntity entity) {
            return UserCreateResponseDTO.builder(
                    entity.getUserId(),
                    entity.getEmail(),
                    entity.getPassword(),
                    entity.getNickName(),
                    entity.getName()
            ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static final class UserUpdateDTO {

        private final Long userId;

        private final String email;

        private final String nickName;

        private final String name;

        public static final UserUpdateDTOBuilder builder(Long userId, String email, String nickName, String name) {
            return innerBuilder()
                    .userId(userId)
                    .email(email)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserUpdateDTO from(UserEntity entity) {
            return UserUpdateDTO.builder(
                    entity.getUserId(),
                    entity.getEmail(),
                    entity.getNickName(),
                    entity.getName()
            ).build();
        }

        public static final UserUpdateDTO of(UserUpdateVO vo) {
            return UserUpdateDTO.builder(
                    vo.getUserId(),
                    vo.getEmail(),
                    vo.getNickName(),
                    vo.getName()
            ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static final class UserReadResponseDTO {

        private final String email;

        private final String nickName;

        private final String name;

        public static final UserReadResponseDTOBuilder builder(String email, String nickName, String name) {
            return innerBuilder()
                    .email(email)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserReadResponseDTO from(UserEntity entity) {
            return UserReadResponseDTO.builder(
                    entity.getEmail(),
                    entity.getNickName(),
                    entity.getName()
            ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    public static final class UserDeleteRequestDTO {

        private final Long userId;

        private final String password;

        public static final UserDeleteRequestDTOBuilder builder(Long userId, String password) {
            return innerBuilder()
                    .userId(userId)
                    .password(password);
        }

        public static final UserDeleteRequestDTO of(UserDeleteRequestVO vo) {
            return UserDeleteRequestDTO.builder(
                    vo.getUserId(),
                    vo.getPassword()
            ).build();
        }
    }
}
