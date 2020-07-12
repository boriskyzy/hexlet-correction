package io.hexlet.hexletcorrection.security.provider;

import io.hexlet.hexletcorrection.security.authentication.WorkspaceTokenAuthentication;
import io.hexlet.hexletcorrection.security.service.SecuredWorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

//@RequiredArgsConstructor
public class WorkspaceTokenAuthProvider /*implements AuthenticationProvider*/ {
//
//    private final SecuredWorkspaceService service;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        final var workspaceName = auth.getName();
//        final var workspace = service.loadUserByUsername(workspaceName);
//        final var token = auth.getCredentials().toString();
//        if (passwordEncoder.matches(token, workspace.getPassword())) {
//            return new WorkspaceTokenAuthentication(workspaceName, token, workspace.getAuthorities());
//        }
//        throw new BadCredentialsException("BadCredentialsException");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return WorkspaceTokenAuthentication.class.equals(authentication);
//    }
}
