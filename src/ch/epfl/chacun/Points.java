package ch.epfl.chacun;

public class Points {
    public static int forClosedForest(int tileCount, int mushroomGroupCount){
        return 2 * tileCount + 3 * mushroomGroupCount;
    }

    public static int forClosedRiver(int tileCount, int fishCount){
        return tileCount + fishCount;
    }

    public static int forMeadow(int mammothCount, int aurochsCount, int deerCount){
        return 3 * mammothCount + 2 * aurochsCount + deerCount;
    }

    public static int forLogboat(int lakeCount){
        return 2 * lakeCount;
    }

    public static int forRaft(int lakeCount){
        return lakeCount;
    }

    public static int forRiverSystem(int v03) {
    }
}
