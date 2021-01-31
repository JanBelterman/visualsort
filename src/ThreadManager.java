import SortingAlgorithms.SortingAlgorithm;

public class ThreadManager {

    private Thread sortingThread;

//    private SortingAlgorithm sortingAlgorithm;

    public void setSortingAlgorithm(SortingAlgorithm sa) {
//        sortingAlgorithm = sa;
    }

    // TODO: if thread is started, start should be grayed out and reset should be clickable. Also when thread is done. Can we listen for thread finish event?
    public void startSorting(SortingAlgorithm sortingAlgorithm) {
        if (sortingThread == null && sortingAlgorithm != null) {
            sortingThread = new Thread(sortingAlgorithm::run);
            sortingThread.start();
        } else {
            resumeSorting();
        }
    }

    public void resumeSorting() {
        try {
            sortingThread.notify();
        } catch (Exception ignored) {
            System.out.println("Could not resume thread");
        }
    }

    // TODO: kan start of moet ik resume hierna doen? & hoe houdt ie state bij van de array???
    // tuurlijk als ik continue gaat gwn die thread verder, duhh, nee dat is niet, die
    // sortingAlgorithm is dan tot een bepaald punt gesorteerd en daar gaat ie gwn op verder!
    // Met een nieuwe thread.
    public void pauseSorting() {
        try {
            sortingThread.suspend();
//            sortingThread.wait(); // TODO: test better than suspend.
        } catch (Exception ignored) {
            System.out.println("Could not suspend thread");
        }
    }

    public void stopSorting() {
        if (sortingThread != null) {
//            sortingThread.stop();
            sortingThread.interrupt(); // TODO: test interrupt better than stop?
            this.sortingThread = null;
        }
    }

}
