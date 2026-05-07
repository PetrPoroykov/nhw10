public class Address {

    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        return country.equals(((Address) obj).country) && city.equals(((Address) obj).city);
    }
}
