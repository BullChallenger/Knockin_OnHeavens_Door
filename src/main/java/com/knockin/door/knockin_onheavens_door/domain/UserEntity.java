package com.knockin.door.knockin_onheavens_door.domain;

import com.knockin.door.knockin_onheavens_door.constant.UserRole;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class UserEntity extends BaseEntity {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String nickName;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public UserEntity(String email, String nickName, String password, String name, UserRole role) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public static final UserEntity of(String email, String nickName, String password, String name) {
        return UserEntity.builder()
                            .email(email)
                            .nickName(nickName)
                            .password(password)
                            .name(name)
                            .role(UserRole.USER)
                         .build();
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void updateRole(UserRole role) {
        this.role = role;
    }
}
