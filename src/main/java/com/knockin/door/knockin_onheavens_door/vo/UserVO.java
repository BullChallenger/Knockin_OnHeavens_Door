package com.knockin.door.knockin_onheavens_door.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.knockin.door.knockin_onheavens_door.dto.UserDTO.*;
import lombok.*;

public class UserVO {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class UserCreateRequestVO {

        private String email;

        private String password;

        private String nickName;

        private String name;
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class UserCreateResponseVO {

        private Long userId;

        private String email;

        private String password;

        private String nickName;

        private String name;

        public static final UserCreateResponseVOBuilder builder(Long userId, String email, String password, String nickName, String name) {
            return innerBuilder()
                    .userId(userId)
                    .email(email)
                    .password(password)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserCreateResponseVO from(UserCreateResponseDTO dto) {
            return UserCreateResponseVO.builder(
                    dto.getUserId(),
                    dto.getEmail(),
                    dto.getPassword(),
                    dto.getNickName(),
                    dto.getName()
            ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class UserUpdateVO {

        private Long userId;

        private String email;

        private String nickName;

        private String name;

        public static final UserUpdateVOBuilder builder(Long userId, String email, String nickName, String name) {
            return innerBuilder()
                    .userId(userId)
                    .email(email)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserUpdateVO from(UserUpdateDTO dto) {
            return UserUpdateVO.builder(
                    dto.getUserId(),
                    dto.getEmail(),
                    dto.getNickName(),
                    dto.getName()
            ).build();
        }
    }

    @Getter
    @Builder(builderMethodName = "innerBuilder")
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class UserReadResponseVO {

        private String email;

        private String nickName;

        private String name;

        public static final UserReadResponseVOBuilder builder(String email, String nickName, String name) {
            return innerBuilder()
                    .email(email)
                    .nickName(nickName)
                    .name(name);
        }

        public static final UserReadResponseVO from(UserReadResponseDTO dto) {
            return UserReadResponseVO.builder(
                    dto.getEmail(),
                    dto.getNickName(),
                    dto.getName()
            ).build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class UserDeleteRequestVO {

        private Long userId;

        private String password;
    }

}
