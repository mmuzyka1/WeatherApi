package enums;

public enum Cities {
    LONDON("London", ",uk"),
    OXFORD("Oxford", ",uk"),
    GDAŃSK("Gdańsk", ",pl");

    private final String cityName;
    private final String country;

    Cities(String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }
}
