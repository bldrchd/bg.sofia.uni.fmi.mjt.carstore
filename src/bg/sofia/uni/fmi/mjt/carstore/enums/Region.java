package bg.sofia.uni.fmi.mjt.carstore.enums;

public enum Region {
    SOFIA, BURGAS, VARNA, PLOVDIV, RUSE, GABROVO, VIDIN, VRATSA;
    
    public static String getPrefix(Region reg){
        switch(reg){
        case SOFIA: return "CB"; 
        case BURGAS: return "A";
        case VARNA: return "B";
        case PLOVDIV: return "PB";
        case RUSE: return "P";
        case GABROVO: return "EB";
        case VIDIN: return "BH";
        case VRATSA: return "BP";
            default: return null;
        }
    }
}
