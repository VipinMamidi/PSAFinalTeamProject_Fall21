package FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils;

/**
 * Class to combine the long codes for an array of objects with a determination of coding perfection.
 */
public class Coding {
    public Coding(long[] longs, boolean perfect) {
        this.longs = longs;
        this.perfect = perfect;
    }

    public final long[] longs;
    public final boolean perfect;
}
