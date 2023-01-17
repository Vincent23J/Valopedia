package com.si51.valopedia.models;

import java.util.List;

public class ValorantData {
    private String displayName, description, displayIcon, fullPotrait, background;
    private List<ValorantRole> roles;
    private List<ValorantAbilities> ablilities;


    public String  getDisplayName(){return displayName;}
    public String  getDescription(){return description;}
    public String  getDisplayIcon(){return displayIcon;}
    public String  getFullPotrait(){return fullPotrait;}
    public String  getBackground(){return background;}
    public List<ValorantRole> getRoles(){return roles;}
    public List<ValorantAbilities> getAblilities(){return ablilities;}
}
