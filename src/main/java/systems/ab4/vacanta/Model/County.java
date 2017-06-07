package systems.ab4.vacanta.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */
@Entity
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String countyName;

    @NotNull
    @ManyToOne
    private Country country;

    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cities;

    public County() {
        cities = new ArrayList<>();
    }

    public County(String countyName) {
        this();
        this.countyName = countyName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        city.setCounty(this);
        cities.add(city);
    }
}
