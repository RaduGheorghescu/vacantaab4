package systems.ab4.vacanta.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String activityName;

    public Activity() {
    }

    public Activity(String activityName) {
        this();
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }



    public void addHolidayPlace(HolidayPlace holidayPlace) {
        holidayPlace.addActivity(this);
    }
}
