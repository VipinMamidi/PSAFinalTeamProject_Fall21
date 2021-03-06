package FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySort;

import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.HuskySortable;
import FinalTeamProject_Fall2021_Sec06.huskySort.util.Config;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Class to perform HuskySort on objects belong to a sub-class of HuskySortable.
 *
 * @param <X> the type of object to be sorted -- must implement HuskySortable.
 */
public final class GenericHuskySort<X extends HuskySortable<X>> extends FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySort.IntroHuskySort<X> {

    /**
     * Primary constructor for GenericHuskySort.
     *
     * @param postSorter the sorter to remove remaining inversions.
     * @param config     the configuration.
     */
    public GenericHuskySort(final Consumer<X[]> postSorter, final Config config) {
        super("Generic HuskySort", HuskyCoderFactory.createGenericCoder(), postSorter, config);
    }

    /**
     * Secondary constructor for GenericHuskySort.
     *
     * @param config the configuration.
     */
    public GenericHuskySort(final Config config) {
        this(Arrays::sort, config);
    }
}
