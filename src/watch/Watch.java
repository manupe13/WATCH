package watch;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private double seconds = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double hours = Math.PI / 2;
    private List<Observer> observers = new ArrayList<>();

    public Watch() {
        Timer timer = new Timer();
        timer.schedule(task(), 0, 100);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    private TimerTask task() {
        return new TimerTask() {
            private static final double PI2 = Math.PI * 2;
            private static final double DegreesPerSecond = PI2 / 60;
            private static final double DegreesPerMinute = DegreesPerSecond / 60;
            private static final double DegreesPerHour = DegreesPerMinute / 12;
            @Override
            public void run() {
                seconds = normalize(seconds - DegreesPerSecond);
                minutes = normalize(minutes - DegreesPerMinute);
                hours = normalize(hours - DegreesPerHour);
                notifyObservers();
            }
            
            public double normalize(double angle) {
                return (angle + PI2) % PI2;
            }

        };
    }

    public void add(Observer observer) {
        observers.add(observer);
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) 
            observer.update();
    }
    
    
}
