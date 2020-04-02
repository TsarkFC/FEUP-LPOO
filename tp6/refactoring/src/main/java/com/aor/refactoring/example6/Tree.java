package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    private final Date plantedAt;
    private Location location;
    private final List<Date> appraisalDates;

    public Date getPlantedAt(){
        return plantedAt;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.location = new Location(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public Date nextAppraisalDate(Date latestAppraisalDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        int saturday = (Calendar.DAY_OF_WEEK == Calendar.SATURDAY) ? 1 : 0;
        int sunday = (Calendar.DAY_OF_WEEK == Calendar.SUNDAY) ? 1 : 0;
        calendar.add(Calendar.DAY_OF_MONTH, 3 + saturday*1 + sunday*2);

        return calendar.getTime();
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }

        Date nextAppraisalDate = nextAppraisalDate(latestAppraisalDate);

        boolean dateInPast = nextAppraisalDate.before(today);

        return dateInPast;
    }
}


