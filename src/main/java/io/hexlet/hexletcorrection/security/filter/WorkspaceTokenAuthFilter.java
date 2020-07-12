package io.hexlet.hexletcorrection.security.filter;

import io.hexlet.hexletcorrection.security.authentication.WorkspaceTokenAuthentication;
import io.hexlet.hexletcorrection.security.service.SecuredAccountService;
import io.hexlet.hexletcorrection.security.service.SecuredWorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static io.hexlet.hexletcorrection.web.Routers.API_TYPOS;
import static java.util.Objects.nonNull;

//@RequiredArgsConstructor
public class WorkspaceTokenAuthFilter /*extends OncePerRequestFilter*/ {
//
//    private final AuthenticationManager manager;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
//        final var name = req.getHeader("Workspace-Name");
//        final var token = req.getHeader("Workspace-Token");
//
//        if (nonNull(name) && nonNull(token)) {
//            final var authentication = new WorkspaceTokenAuthentication(name, token);
//            manager.authenticate(authentication);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            doFilter(req, res, filterChain);
//        }
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) {
//        return !"POST".equals(request.getMethod()) && !API_TYPOS.equals(request.getServletPath());
//    }
}
