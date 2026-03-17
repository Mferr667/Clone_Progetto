public class TurnOrderCard4 extends TurnOrderCard{

    protected  TurnOrderCard4(){
        super(4);
    }

    @Override
    protected void resolveBonusOrMalus() {
        Player firstplayer= getPlayerOrder().get(0);
        Player secondplayer= getPlayerOrder().get(1);
        Player fourthplayer= getPlayerOrder().get(3);

        firstplayer.setNumFood(firstplayer.getNumFood() + 2);
        secondplayer.setNumFood(secondplayer.getNumFood() + 1);

        if(fourthplayer.getNumFood() > 0){
            fourthplayer.setNumFood(fourthplayer.getNumFood() - 1);
        }
        else if(fourthplayer.getNumFood() == 0){
            fourthplayer.setNumPrestigePoints(fourthplayer.getNumPrestigePoints() - 2);
        }
    }
}
