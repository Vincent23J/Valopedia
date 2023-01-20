package com.si51.valopedia.models;

import java.util.List;

public class ValorantDetail {
    private String uuid, displayName, description, fullPortrait, background;
    private List<ValorantAbilities> abilities;
    private List<ValorantRole> role;

    public String getUuid(){return uuid;}
    public String getDisplayName(){return displayName;}
    public String getDescription(){return description;}
    public List<ValorantAbilities> getAbilities(){return abilities;}
    public List<ValorantRole> getRole(){return role;}
    public String getFullPortrait(){return fullPortrait;}
    public String getBackground(){return background;}
}
