package kz.attractorschool.gymnasticsfederation.common_data.enumiration;

public enum CompetitionLevel {
    INTERNATIONAL("Международный"), COUNTRY("Республиканский"), REGIONAL("Региональный");

    private final String name;

    CompetitionLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
