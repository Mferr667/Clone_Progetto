public class TurnOrderCard5 extends TurnOrderCard{

    protected  TurnOrderCard5(){
        super(5);
    }

    @Override
    protected void resolveBonusOrMalus() {
        Player firstplayer= getPlayerOrder().get(0);
        Player secondplayer= getPlayerOrder().get(1);
        Player fifthplayer= getPlayerOrder().get(4);

        firstplayer.setNumFood(firstplayer.getNumFood() + 3);
        secondplayer.setNumFood(secondplayer.getNumFood() + 1);

        if(fifthplayer.getNumFood() > 0){
            fifthplayer.setNumFood(fifthplayer.getNumFood() - 1);
        }
        else if(fifthplayer.getNumFood() == 0){
            fifthplayer.setNumPrestigePoints(fifthplayer.getNumPrestigePoints() - 2);
        }
    }
}
