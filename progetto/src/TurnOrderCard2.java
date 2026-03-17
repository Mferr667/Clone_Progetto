public class TurnOrderCard2 extends TurnOrderCard {

    protected TurnOrderCard2(){
        super(2);
    }

    @Override
    protected void resolveBonusOrMalus() {
        Player firstplayer= getPlayerOrder().get(0);
        Player secondplayer= getPlayerOrder().get(1);

        firstplayer.setNumFood(firstplayer.getNumFood() + 1);

        if(secondplayer.getNumFood() > 0){
            secondplayer.setNumFood(secondplayer.getNumFood() - 1);
        }
        else if(secondplayer.getNumFood() == 0){
            secondplayer.setNumPrestigePoints(secondplayer.getNumPrestigePoints() - 2);
        }
    }
}
