package com.niteroomcreation.simplewebrest.models.data.services;

import com.niteroomcreation.simplewebrest.models.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by monta on 21/12/20
 * please make sure to use credit when you're using people's code
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        com.niteroomcreation.simplewebrest.models.data.domains.User u = userRepo.getByName(s);
        if(u == null)
            throw new UsernameNotFoundException(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(u.getRole().getName()));

        return new User(u.getUserName(), u.getPassword(), grantedAuthorities);
    }
}
