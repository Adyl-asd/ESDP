package kz.attractorschool.gymnasticsfederation.enumm;

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
