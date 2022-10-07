package geometrydash;

import java.util.Set;

public class GeometryDash {
    /**
     * Returns whether the given level can be completed using the given play.
     * @param level is not null and not empty
     * @param play is not null and not empty
     * @return true if the play completes the level and false otherwise
     */
    public static boolean isSuccessfulPlay(String level, String play) {
        int position = 0;
        for (int i = 0; i < play.length(); i++)
        {
            position += Character.getNumericValue(play.charAt(i));
            if (level.charAt(position) == '^')
                return false;
        }
        if (position == level.length() - 1)
            return true;

        return false;
    }

    /**
     * Returns the subset of plays which can complete the given level ending
     * with the target resting energy
     * @param level is not null and not empty
     * @param possiblePlays is not null
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return a subset of {@code possiblePlays} which complete the level with
     * {@code targetRestingEnergy} units of energy remaining
     */
    public static Set<String> successfulPlays(String level, Set<String> possiblePlays,
                                              int startingEnergy, int targetRestingEnergy) {
        Set<String> returnSet = new HashSet<>();

        for (String s : possiblePlays)
        {
            int energy = startingEnergy;
            int pos = 0;
            for (int i = 0; i < s.length(); i++)
            {
                pos += Character.getNumericValue(s.charAt(i));
                if (pos > level.length() - 1)
                    break;

                if (level.charAt(pos) == '^')
                    break;

                switch(Character.getNumericValue(s.charAt(i)))
                {
                    case 0:
                        energy++;
                        break;
                    case 1:
                        energy--;
                        break;
                    case 2:
                        energy -= 2;
                        break;
                    case 3:
                        energy -= 3;
                        break;
                    default:
                        ;
                }

                while(level.charAt(pos) == '*')
                {
                    pos += 4;
                    if (pos > level.length() - 1)
                        break;

                    if (level.charAt(pos) == '^')
                        break;
                }

                if (pos > level.length() - 1)
                    break;

                if (level.charAt(pos) == '^')
                    break;

                if (pos == level.length() - 1)
                {
                    if (energy == targetRestingEnergy)
                        returnSet.add(s);
                }
            }
        }

        return returnSet;
    }

    /**
     * Returns the shortest play that completes the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the shortest play that allows a player to complete the given level
     * @throws UnplayableLevelException if no play can complete the level
     */
    public static String shortestPlay(String level, int startingEnergy, int targetRestingEnergy)
            throws UnplayableLevelException {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the total number of plays which allow a player to complete the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the total number of plays which allow a player to complete the given level
     * with target resting energy {@code targetRestingEnergy}
     */
    public static int numberOfPlays(String level, int startingEnergy, int targetRestingEnergy) {
        // TODO: Implement this method
        return -1;
    }
}
