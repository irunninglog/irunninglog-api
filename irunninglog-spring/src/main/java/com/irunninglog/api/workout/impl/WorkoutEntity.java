package com.irunninglog.api.workout.impl;

import com.irunninglog.api.Privacy;
import com.irunninglog.api.data.impl.ShoeEntity;
import com.irunninglog.jpa.AbstractEntityWithUser;
import com.irunninglog.jpa.DateConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workout_entity")
class WorkoutEntity extends AbstractEntityWithUser {

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private long duration;

    @Column(nullable = false, name = "ddate")
    @Convert(converter = DateConverter.class)
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    @ManyToOne
    private ShoeEntity shoe;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public ShoeEntity getShoe() {
        return shoe;
    }

    public void setShoe(ShoeEntity shoe) {
        this.shoe = shoe;
    }

}
