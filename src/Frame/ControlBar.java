package Frame;

import javax.swing.*;
import java.awt.*;

public class ControlBar extends JPanel {

    private final MenuBarCallback cb;

    private JButton startBtn;
    private JButton pauseBtn;
    private JButton stopBtn;
    private JButton resetBtn;

    public ControlBar(MenuBarCallback cb) {
        this.cb = cb;

        addStartButton();
        addPauseButton();
        addStopButton();
        addResetButton();

        setVisible(true);
    }

    public void addStartButton() {
        startBtn = new JButton("Start");
        startBtn.addActionListener(e -> cb.onStart());
        add(startBtn, FlowLayout.LEFT);
    }

    public void addPauseButton() {
        pauseBtn = new JButton("Pause");
        pauseBtn.addActionListener(e -> cb.onPause());
        add(pauseBtn);
    }

    public void addStopButton() {
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(e -> cb.onStop());
        add(stopBtn);
    }

    public void addResetButton() {
        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> cb.onRestart());
        add(resetBtn);
    }

}
