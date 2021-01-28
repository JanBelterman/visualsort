package Frame;

public interface MenuBarCallback {

    void onStart();
    void onStop();
    void onPause();
    void onRestart();

    void onSwitchSortingAlgorithm(SortingAlgorithmEnum sa);

}
