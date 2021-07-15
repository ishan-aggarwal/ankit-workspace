package assignment_old;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    public int id;
    public int location;
    public boolean covidPositive;
    public boolean inQuarantine;
    public ArrayList<Integer> usedIds;
    public ArrayList<ContactInfo> contactHistory;

    //default constructor
    public Student() {
        this.id = -1;
        this.location = -1;
        this.covidPositive = false;
        this.inQuarantine = false;
        this.usedIds = new ArrayList<>();
        this.contactHistory = new ArrayList<>();
    }

    public boolean setLocation(int newLocation) {
        if(newLocation >=0 && !this.inQuarantine) {
            this.location = newLocation;
            return true;
        }
        return false;
    }

    //generate random id and set it to id and add the same in the usedIds
    public void updateId() {
        Random random = new Random();
        int id = random.nextInt(Integer.MAX_VALUE);
        this.id = id;
        this.usedIds.add(id);
    }

    public boolean addContactInfo(ContactInfo info) {
        if(Objects.nonNull(info) && info.isValid()) {
            this.contactHistory.add(info);
        }
        return false;
    }

    public boolean uploadAllUsedIds(Server server) {
        if(Objects.nonNull(server)) {
            return server.addInfectedIds(this.usedIds);
        }
        return false;
    }

    public boolean testPositive(Server server) {
        this.covidPositive = true;
        this.inQuarantine = true;

        return this.uploadAllUsedIds(server);
    }

    public ArrayList<ContactInfo> getRecentPositiveContacts(Server server, int fromTime) {

        if(Objects.isNull(server) || fromTime < 0 || Objects.isNull(server.getInfectedIds())) {
            return null;
        }

        ArrayList<Integer> infectedIds = server.getInfectedIds();

        return (ArrayList<ContactInfo>) contactHistory.stream()
                .filter(contactInfo -> !contactInfo.used && infectedIds.contains(contactInfo.id)
                                        && contactInfo.time >= fromTime).collect(Collectors.toList());

    }

    public int riskCheck(Server server, int fromTime, boolean quarantineChoice) {
        ArrayList<ContactInfo> recentPositiveContacts = this.getRecentPositiveContacts(server, fromTime);

        if(Objects.isNull(recentPositiveContacts)) {
            return -1;
        }
        List<Integer> recentPositiveContactIds = recentPositiveContacts
                                                    .stream()
                                                    .map(contactInfo -> contactInfo.id)
                                                    .collect(Collectors.toList());
        boolean highRisk = false;

        long count1 = this.contactHistory
                .stream()
                .filter(contactInfo -> {
                    if (recentPositiveContactIds.contains(contactInfo.id) && contactInfo.distance <= 1) {
                        contactInfo.used = true;
                        return true;
                    } else {
                        return false;
                    }

                }).count();

        long count2 = this.contactHistory
                .stream()
                .filter(contactInfo -> {
                    if (recentPositiveContactIds.contains(contactInfo.id)) {
                        contactInfo.used = true;
                        return true;
                    } else {
                        return false;
                    }

                }).count();
        if(count2 >= 3) {
            contactHistory.stream().forEach(contactInfo -> contactInfo.used = true);
        }

        if(count1 > 0 || count2 > 3) {
            highRisk = true;
        }
        if(highRisk) {
            if(quarantineChoice) {
                this.inQuarantine = true;
            }
            return 1;
        } else {
            return 0;
        }

    }

}
