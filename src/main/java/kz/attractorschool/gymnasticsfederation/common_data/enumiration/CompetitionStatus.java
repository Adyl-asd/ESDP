package kz.attractorschool.gymnasticsfederation.common_data.enumiration;

public enum CompetitionStatus {
    UNDER_CONSIDERATION("На_рассмотрении"), CONFIRMED("Подтверждено"), COMPLETED("Завершено");

    private final String name;

    CompetitionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
