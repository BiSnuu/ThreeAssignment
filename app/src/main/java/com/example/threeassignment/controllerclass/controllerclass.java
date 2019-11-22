package com.example.threeassignment.controllerclass;



import com.example.threeassignment.model.UserData;

public class controllerclass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("admin")) && (sd.getPassword().equals("1234"))) {
            return true;

        } else {
            return false;
        }
    }

}

