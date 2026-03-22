import java.util.HashMap;
import java.util.Map;

//Class for associating the building with the effect
public class EffectRegistry {
    private static final Map<String, SerializableEffect> registry = new HashMap<>();
    static {
        registry.put("FLAT_25_PRESTIGE", (player, game) -> {
        });

        registry.put("SCORING_HUNTERS", (player, game) -> {
            // TODO: Logica punti per artisti
        });

        registry.put("SCORING_ARTISTS", (player, game) -> {
            // TODO: Logica punti per artisti
        });

        registry.put("SCORING_SHAMANS", (player, game) -> {
            // TODO: Logica punti per sciamani
        });

        registry.put("SCORING_GATHERERS", (player, game) -> {
            // TODO: Logica punti per raccoglitori
        });

        registry.put("SCORING_BUILDERS", (player, game) -> {
            // TODO: Logica punti per costruttori
        });

        registry.put("SCORING_INVENTORS", (player, game) -> {
            // TODO: Logica punti per inventori
        });

        registry.put("END_GAME_SET_PRESTIGE", (player, game) -> {
            // TODO: Logica punti set completo
        });

        registry.put("DOUBLE_BUILDER_PRESTIGE", (player, game) -> {
            // TODO: Raddoppia i punti dei costruttori
        });

        registry.put("SUSTENANCE_DISCOUNT_ARTISTS", (player, game) -> {
            player.setNumFood(player.getNumFood()+player.getTribe().artistsSize());
        });

        registry.put("SUSTENANCE_DISCOUNT_INVENTORS", (player, game) -> {
            player.setNumFood(player.getNumFood()+player.getTribe().inventorsSize());
        });

        registry.put("SUSTENANCE_DISCOUNT_GATHERERS", (player, game) -> {
            player.setNumFood(player.getNumFood()+player.getTribe().gatherersSize());
        });

        registry.put("SET_COMPLETION_FOOD", (player, game) -> {
            // TODO: Cibo per completamento set
        });

        registry.put("INVENTOR_PAIR_FOOD", (player, game) -> {
            player.setNumFood(player.getNumFood()+3);
        });

        registry.put("EXTRA_END_TURN_FOOD", (player, game) -> {
            player.setAddFoodStartOfRound(1);
        });

        registry.put("PLAYER_EXTRA_DRAFT", (player, game) -> {
            player.setAddTopPick(1);
        });

        registry.put("SHAMANIC_PENALTY_SHIELD", (player, game) -> {
            player.setNumPrestigePoints(player.getNumPrestigePoints()+1);
        });

        registry.put("EXTRA_SHAMANIC_STARS", (player, game) -> {
            player.setNumStars(player.getNumStars()+3);
        });

        registry.put("DOUBLE_SHAMANIC_REWARD", (player, game) -> {
            player.setNumPrestigePoints(player.getNumPrestigePoints()+1);
        });

        registry.put("HUNT_EXTRA_FOOD_AND_PRESTIGE", (player, game) -> {
            player.setNumFood(player.getNumFood()+player.getTribe().huntersSize());
            player.setNumPrestigePoints(player.getNumFood()+player.getTribe().huntersSize());
        });

        registry.put("PAINT_EXTRA_FOOD", (player, game) -> {
            player.setNumFood(player.getNumFood()+player.getTribe().paintersSize());
        });
    }

    // TODO: Guarda l'errore
    public static SerializableEffect getEffect(String name) {
        return registry.getOrDefault(name, (player, game) -> {
            System.err.println("not found effect named " + name);
        });
    }
}
