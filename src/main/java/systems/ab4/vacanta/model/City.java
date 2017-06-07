package systems.ab4.vacanta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String cityName;

    @NotNull
    @ManyToOne
    private County county;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HolidayPlace> holidayPlaces;

    public City() {
        holidayPlaces = new ArrayList<>();
    }

    public City(String cityName) {
        this();
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public List<HolidayPlace> getHolidayPlaces() {
        return holidayPlaces;
    }

    public void addHolidayPlace(HolidayPlace holidayPlace) {
        holidayPlace.setCity(this);
        holidayPlaces.add(holidayPlace);
    }
}
