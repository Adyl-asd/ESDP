package kz.attractorschool.gymnasticsfederation.common_data.enumiration;

public enum Status {
    ACTIVE("Активный"), UNDER_CONSIDERATION("На_рассмотрении"), EXPIRED("Истек"),
    INACTIVE("Неактивный"), DISQUALIFIED("Дисквалифицирован");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

