package hu.consumeSoldierAPI.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Soldier {
    private int id;
    private String rank;
    private Date birth;
    private String weapon;
    private boolean alive;
    private int shotpeople;

    public Soldier() {
    }

    public Soldier(String rank, String birth, String weapon, int shotpeople) {
        this.rank = rank;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birth = format.parse(birth);
        } catch (ParseException ex) {
            System.out.println("ex in Soldier(): "+ex.getMessage());
        }
        this.weapon = weapon;
        this.alive = true;
        this.shotpeople = shotpeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getShotpeople() {
        return shotpeople;
    }

    public void setShotpeople(int shotpeople) {
        this.shotpeople = shotpeople;
    }
}
