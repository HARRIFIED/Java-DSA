/*
    Every ad shown on Twitch has a unique integer ad_id, starting at 0, 1, 2, 3...
    Each user on Twitch has an array of ad_ids that they have seen, in the order that they viewed them (unsorted, can
    have duplicates).
    The product team has requested that we update the algorithm that decides which ad to show to a user. They would
    like to always show the lowest ad_id that the user has NOT already seen.
    Write a function that, given the user's array of seen ad_ids, returns the correct ad_id. Assume valid input.

    Examples:
    [6,2,1,4,0] = return 3
    [2,5,3] = return 1
    [] = return 0
     [0,1,2,3]
 */


public class TwichCountingSort {
    public int solution(int[] adIds) {
        boolean[] seen = new boolean[adIds.length + 2]; // accounting for 0 index and nums.length + 1

        for (int id: adIds) {
            if (id > 0 && id < seen.length) {
                seen[id] = true;
            }
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return seen.length;
    }
}
