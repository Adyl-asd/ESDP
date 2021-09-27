package kz.attractorschool.gymnasticsfederation.enumm;

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
