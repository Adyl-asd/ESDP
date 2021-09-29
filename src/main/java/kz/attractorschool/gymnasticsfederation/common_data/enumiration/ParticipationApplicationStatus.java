package kz.attractorschool.gymnasticsfederation.common_data.enumiration;

public enum ParticipationApplicationStatus {
    CREATED("Создана"), FILED("Подана"), CONFIRMED("Подтверждена");

    private final String name;

    ParticipationApplicationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
