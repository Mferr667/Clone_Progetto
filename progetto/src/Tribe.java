import java.util.ArrayList;

public class Tribe {
    private ArrayList<Hunter> hunters;
    private ArrayList<Inventor> inventors;
    private ArrayList<Shaman> shamans;
    private ArrayList<Gatherer> gatherers;
    private ArrayList<Artist> artists;
    private ArrayList<Builder> builders;
    private ArrayList<Building> buildings;

    protected Tribe() {
        this.hunters = new ArrayList<>();
        this.inventors = new ArrayList<>();
        this.shamans = new ArrayList<>();
        this.gatherers = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.builders = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }


    // GETTERS
    protected ArrayList<Hunter> getHunters() {
        return hunters;
    }

    protected ArrayList<Inventor> getInventors() {
        return inventors;
    }

    protected ArrayList<Shaman> getShamans() {
        return shamans;
    }

    protected ArrayList<Gatherer> getGatherers() {
        return gatherers;
    }

    protected ArrayList<Artist> getArtists() {
        return artists;
    }

    protected ArrayList<Builder> getBuilders() {
        return builders;
    }

    protected ArrayList<Building> getBuildings() {
        return buildings;
    }

    // SETTERS
    protected void addHunter(Hunter hunter) {
        hunters.add(hunter);
    }

    protected void addInventor(Inventor inventor) {
        inventors.add(inventor);
    }

    protected void addShaman(Shaman shaman) {
        shamans.add(shaman);
    }

    protected void addGatherer(Gatherer gatherer) {
        gatherers.add(gatherer);
    }

    protected void addArtist(Artist artist) {
        artists.add(artist);
    }

    protected void addBuilder(Builder builder) {
        builders.add(builder);
    }

    protected void addBuilding(Building building) {
        buildings.add(building);
    }
}
