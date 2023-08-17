package com.knockin.door.knockin_onheavens_door.service;

import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import com.knockin.door.knockin_onheavens_door.dto.SecurityUser;
import com.knockin.door.knockin_onheavens_door.exception.BaseException;
import com.knockin.door.knockin_onheavens_door.repository.UserRepository;
import com.knockin.door.knockin_onheavens_door.util.RoleUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleUtil roleUtil;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity theUser = userRepository.findByEmail(email).orElseThrow(
                () -> new BaseException(ResultType.NOT_FOUND)
        );

        return new SecurityUser(theUser.getEmail(),
                                theUser.getPassword(),
                                theUser.getUserId(),
                                theUser.getNickName(),
                                roleUtil.addAuthoritiesForContext(theUser));
    }
}
