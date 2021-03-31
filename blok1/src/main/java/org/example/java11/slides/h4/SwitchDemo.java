package org.example.java11.slides.h4;

public class SwitchDemo {

    public static final String EEN = "Een";
    public static final String TWEE = "Twee";
    public static final String DRIE_OF_VIER_OF_VIJF = "Drie of vier of vijf";
    public static final String IETS_ANDERS = "Iets anders";

    public String demoSwitchStatement(int i) {
        String result = "";

        switch (i) {
            case 1:
                result = EEN;
                break;
            case 2:
                result = TWEE;
                break;
            case 3:
            case 4: // ...
            case 5: // ...
                result = DRIE_OF_VIER_OF_VIJF;
                break;
            default:
                result = IETS_ANDERS;
                break;
        }

        if (i == 1) {
            result = EEN;
        } else if (i == 2) {
            result = TWEE;
        } else if (i == 3 || i == 4 || i == 5) {
            result = DRIE_OF_VIER_OF_VIJF;
        } else {
            result = IETS_ANDERS;
        }

        return result;
    }

    // java >= 14 needed:
    // public String demoSwitchExpression(int i) {
    //     return switch (i) {
    //         case 1 -> EEN;
    //         case 2 -> TWEE;
    //         case 3, 4, 5 -> DRIE_OF_VIER_OF_VIJF;
    //         default -> IETS_ANDERS;
    //     };
    // }

}
