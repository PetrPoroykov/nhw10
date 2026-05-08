public class Address {

    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        return country.equals(((Address) obj).country) && city.equals(((Address) obj).city);
    }

    @Override
    public String toString() {
        return country + " " + city;
    }

    @Override
    public int hashCode() {
        return country.hashCode() + city.hashCode();
    }
}
