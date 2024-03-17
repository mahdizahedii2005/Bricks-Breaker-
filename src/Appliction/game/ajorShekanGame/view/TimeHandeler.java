package Appliction.game.ajorShekanGame.view;

import java.util.ArrayList;

public class TimeHandeler {
    long min;
    long sec;
    long Hours;
    private long StartTimeSec;
    private boolean isGameRunning = true;
    private ArrayList<Long> StopTime = new ArrayList<>();
    private ArrayList<Long> startTime = new ArrayList<>();

    public void PuseTheGame() {
        isGameRunning = false;
        StopTime.add(System.currentTimeMillis() / 1000);
    }

    public void ReasumTheGame() {
        isGameRunning = true;
        startTime.add(System.currentTimeMillis() / 1000);
    }

    private long sumTheArray(ArrayList<Long> arr) {
        long sum = 0;
        for (long a : arr) {
            sum += a;
        }
        return sum;
    }

    public TimeHandeler() {
        StartTimeSec = System.currentTimeMillis() / 1000;
        min = 0;
        sec = 0;
        Hours = 0;
    }

    @Override
    public String toString() {
        String redult = "";
        if (getHours() > 9) {
            redult += getHours();
        } else {
            redult += "0" + getHours();
        }
        redult += ":";
        if (getMin() > 9) {
            redult += getMin();
        } else {
            redult += "0" + getMin();
        }
        redult += ":";
        if (getSec() > 9) {
            redult += getSec();
        } else {
            redult += "0" + getSec();
        }
        return redult;
    }

    private void Update() {
        long nowTimeSec = ((System.currentTimeMillis() / 1000) - StartTimeSec);
        if (!startTime.isEmpty() || !StopTime.isEmpty()) {
            nowTimeSec = nowTimeSec - (sumTheArray(startTime) - sumTheArray(StopTime));
        }
        if (!isGameRunning) {
            nowTimeSec = (StopTime.get(0) - StartTimeSec);
            if (!startTime.isEmpty() || !StopTime.isEmpty()) {
                nowTimeSec = nowTimeSec - (sumTheArray(startTime) - sumTheArray(StopTime)+StopTime.get(0));
            }
        }
        if (nowTimeSec < 60) {
            sec = nowTimeSec;
        } else {
            long nowTimeMin = nowTimeSec / 60;
            nowTimeSec = nowTimeSec - nowTimeMin * 60;
            if (nowTimeMin < 60) {
                sec = nowTimeSec;
                min = nowTimeMin;
            } else {
                long nowTimeHours = nowTimeMin / 60;
                nowTimeMin = nowTimeMin - nowTimeHours * 60;
                sec = nowTimeSec;
                min = nowTimeMin;
                Hours = nowTimeHours;
            }
        }
    }

    public long getMin() {
        Update();
        return min;
    }

    public long getSec() {
        Update();
        return sec;
    }

    public long getHours() {
        Update();
        return Hours;
    }
}
