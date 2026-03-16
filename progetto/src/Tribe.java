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

    protected int huntersSize() {
        return hunters.size();
    }

    protected int inventorsSize() {
        return inventors.size();
    }

    protected int shamansSize() {
        return shamans.size();
    }

    protected int gatherersSize() {
        return gatherers.size();
    }

    protected int artistsSize() {
        return artists.size();
    }

    protected int buildersSize() {
        return builders.size();
    }



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
