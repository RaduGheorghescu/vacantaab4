package systems.ab4.vacanta.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */

@Entity
public class HolidayPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String placeName;

    @NotNull
    @ManyToOne
    private City city;

    private double averagePrice;

    @ManyToMany
    private List<Activity> activities;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;


    public HolidayPlace() {
        activities = new ArrayList<>();
    }

    public HolidayPlace(String placeName, double averagePrice, Date startDate, Date endDate) {
        this();
        this.placeName = placeName;
        this.averagePrice = averagePrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}
