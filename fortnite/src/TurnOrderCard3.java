public class TurnOrderCard3 extends TurnOrderCard {

    protected  TurnOrderCard3(){
        super(3);
    }

    @Override
    protected void resolveBonusOrMalus() {
        Player firstplayer= getPlayerOrder().get(0);
        Player thirdplayer= getPlayerOrder().get(2);

        firstplayer.setNumFood(firstplayer.getNumFood()+ 2);

        if(thirdplayer.getNumFood() > 0){
            thirdplayer.setNumFood(thirdplayer.getNumFood() - 1);
        }
        else if(thirdplayer.getNumFood() == 0){
            thirdplayer.setNumPrestigePoints(thirdplayer.getNumPrestigePoints() - 2);
        }
    }
}
