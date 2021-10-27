package com.zhdanovich.taskmanager.registration;

import com.zhdanovich.taskmanager.appuser.AppUser;
import com.zhdanovich.taskmanager.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final AppUserService appUserService;

    @Autowired
    public RegistrationService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public void register(RegistrationRequest request) {
        AppUser appUser = new AppUser(request.getEmail(), request.getPassword(), request.getUserRole());
        appUserService.signInUser(appUser);
    }

}
