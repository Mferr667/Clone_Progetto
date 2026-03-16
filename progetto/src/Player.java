public class Player {
    private final String nickname;
    private int numFood;
    private int numPrestigePoints;
    private int numStars;
    private int totalBuildingDiscount;
    private int totalGatheringDiscount;
    private int addTopPick;
    private int addFoodStartOfRound;
    private int numSetCompleted;
    private int numTopPicksLeft;
    private int numBottomPicksLeft;
    private Tribe tribe;

    protected Player(String nickname) {
        	this.nickname = "nickname";
        	this.numFood = 0;
        	this.numPrestigePoints = 0;
        	this.numStars = 0;
        	this.totalBuildingDiscount = 0;
        	this.totalGatheringDiscount = 0;
        	this.addTopPick = 0;
        	this.addFoodStartOfRound = 0;
        	this.numSetCompleted = 0;
        	this.numTopPicksLeft = 0;
        	this.numBottomPicksLeft = 0;
        	this.tribe = new Tribe();
    }

    protected String getNickname() {
        return nickname;
    }

    protected int getNumFood() {
        return numFood;
    }

    protected int getNumPrestigePoints() {
        return numPrestigePoints;
    }

    protected int getNumStars() {
        return numStars;
    }

    protected int getTotalBuildingDiscount() {
        return totalBuildingDiscount;
    }

    protected int getTotalGatheringDiscount() {
        return totalGatheringDiscount;
    }

    protected int getAddTopPick() {
        return addTopPick;
    }

    protected int getAddFoodStartOfRound() {
        return addFoodStartOfRound;
    }

    protected int getNumSetCompleted() {
        return numSetCompleted;
    }

    protected int getNumTopPicksLeft() {
        return numTopPicksLeft;
    }

    protected int getNumBottomPicksLeft() {
        return numBottomPicksLeft;
    }

    protected Tribe getTribe() {
        return tribe;
    }



    protected void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    protected void setNumPrestigePoints(int numPrestigePoints) {
        this.numPrestigePoints = numPrestigePoints;
    }

    protected void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    protected void setTotalBuildingDiscount(int totalBuildingDiscount) {
        this.totalBuildingDiscount = totalBuildingDiscount;
    }

    protected void setTotalGatheringDiscount(int totalGatheringDiscount) {
        this.totalGatheringDiscount = totalGatheringDiscount;
    }

    protected void setAddTopPick(int addTopPick) {
        this.addTopPick = addTopPick;
    }

    protected void setAddFoodStartOfRound(int addFoodStartOfRound) {
        this.addFoodStartOfRound = addFoodStartOfRound;
    }

    protected void setNumSetCompleted(int numSetCompleted) {
        this.numSetCompleted = numSetCompleted;
    }

    protected void setNumTopPicksLeft(int numTopPicksLeft) {
        this.numTopPicksLeft = numTopPicksLeft;
    }

    protected void setNumBottomPicksLeft(int numBottomPicksLeft) {
        this.numBottomPicksLeft = numBottomPicksLeft;
    }

    protected void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

}
