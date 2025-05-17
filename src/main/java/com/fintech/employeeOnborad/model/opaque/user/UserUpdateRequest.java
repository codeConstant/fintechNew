package com.fintech.employeeOnborad.model.opaque.user;

import com.fintech.employeeOnborad.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserUpdateRequest  extends UserCURequest{

    private long id;

    public User buildUserModel(){
        var user  = super.buildUserModel();
        user.setId(id);
        return user;
    }
}
