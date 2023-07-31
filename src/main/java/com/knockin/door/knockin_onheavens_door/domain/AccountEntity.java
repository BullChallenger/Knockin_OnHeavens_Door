package com.knockin.door.knockin_onheavens_door.domain;

import com.knockin.door.knockin_onheavens_door.constant.AccountRole;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "innerBuilder")
public class AccountEntity {

    @Id
    @Column(name = "account_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String email;

    private String nickName;

    private String encryptedPassword;

    private String name;

    @Builder.Default private AccountRole role = AccountRole.USER;

    public static AccountEntityBuilder builder(String email, String nickName, String encryptedPassword, String name) {
        return innerBuilder()
                            .email(email)
                            .nickName(nickName)
                            .encryptedPassword(encryptedPassword)
                            .name(name);
    }
}
