public class SpawnMeter {
    public int countSpawnClearActions(int spawnMeter) {
        /*
           Drain meter till it gets to zero by applying rules. if even divide by 2 else reduce by 1.
           Return the number of actions done to reduce the meter
            count(14) => 7 => 6 => 3 => 2 => 1 => 0
            count = 0
        */
        int count = 0;
        while (spawnMeter > 0) {
            if (spawnMeter % 2 == 0) {
                spawnMeter = spawnMeter / 2;
            } else {
                spawnMeter = spawnMeter - 1;
            }
            count++;
        }
        return count;
    }

    public int recursiveCountSpawnClearActions(int spawnMeter) {
        if (spawnMeter == 0) { //base case
            return 0;
        }

        if (spawnMeter % 2 == 0) {
            return 1 + recursiveCountSpawnClearActions(spawnMeter / 2);
        } else {
            return 1 + recursiveCountSpawnClearActions(spawnMeter - 1);
        }
    }
}
