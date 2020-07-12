package io.hexlet.hexletcorrection.security.service;

import io.hexlet.hexletcorrection.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;

//@RequiredArgsConstructor
public class SecuredWorkspaceService /*implements UserDetailsService, UserDetailsPasswordService*/ {
//
//    private final WorkspaceRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        return repository.getSecuredWorkspaceByName(name)
//            .orElseThrow(() -> new UsernameNotFoundException("Secured Workspace with name='" + name + "' not found"));
//    }
//
//    @Override
//    public UserDetails updatePassword(UserDetails user, String newPassword) {
//        return null;
//    }
}
