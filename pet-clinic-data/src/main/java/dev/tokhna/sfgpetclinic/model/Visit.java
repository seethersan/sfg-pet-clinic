package dev.tokhna.sfgpetclinic.model;

import java.time.LocalDateTime;

public class Visit extends BaseEntity {
    private LocalDateTime datetime;
    private String description;
    private Pet pet;

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
