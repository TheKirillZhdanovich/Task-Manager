package com.zhdanovich.taskmanager.registration;

import com.zhdanovich.taskmanager.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {

    private String email;
    private String password;
    private AppUserRole userRole;

}
