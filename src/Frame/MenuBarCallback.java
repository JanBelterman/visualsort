package Frame;

import Sorting_algorithms.SortingAlgorithm;

public interface MenuBarCallback {

    void onStart();
    void onStop();
    void onPause();
    void onRestart();

    void onSwitchSortingAlgorithm(SortingAlgorithmEnum sa);

}
