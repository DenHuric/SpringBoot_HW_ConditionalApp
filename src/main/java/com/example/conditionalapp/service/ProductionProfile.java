package com.example.conditionalapp.service;

import com.example.conditionalapp.service.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
