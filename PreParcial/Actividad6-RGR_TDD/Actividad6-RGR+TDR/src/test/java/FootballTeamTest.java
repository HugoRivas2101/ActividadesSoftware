import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FootballTeamTest {

    private static final int THREE_GAMES_WON=3;

    @ParameterizedTest
    @ValueSource(ints={0,1,3,10})
    void constructorShouldSetGamesWonTest(int nbOfGamesWon) {
        FootballTeam team = new FootballTeam(nbOfGamesWon);
        assertThat(team.getGamesWon()).as("number of game won").isEqualTo(nbOfGamesWon);
    }

    @ParameterizedTest
    @ValueSource(ints={-10,-1})
    void constructorShouldThrowExceptionForIllegalGamesNb(int illegalNbOfGames){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new FootballTeam(illegalNbOfGames));
    }


    private static final int ANY_NUMBER=123;
    @Test
    void shouldBePossibleToCompareTeams(){
        FootballTeam team=new FootballTeam(ANY_NUMBER);
        assertThat(team).isInstanceOf(Comparable.class);
    }

    @Test
    void teamsWithMoreMatchesWonShouldBeGreater(){
        FootballTeam team1=new FootballTeam(2);
        FootballTeam team2=new FootballTeam(3);

        assertThat(team2.compareTo(team1)).isEqualTo(1);
    }

    @Test
    void teamsWithLessMatchesWonShouldBeLesser(){
        FootballTeam team1=new FootballTeam(4);
        FootballTeam team2=new FootballTeam(3);

        assertThat(team2.compareTo(team1)).isEqualTo(-1);
    }

    @Test
    void teamsWithSameMatchesWonShouldBeEqual(){
        FootballTeam team1=new FootballTeam(3);
        FootballTeam team2=new FootballTeam(3);

        assertThat(team2.compareTo(team1)).isEqualTo(0);
    }

}

/*


        assertThat(team.getGamesWon())
                .as("number of games won")
                .isEqualTo(3);
public class FootballTeamTest {
    private static final int THREE_GAMES_WON = 3;
    @Test
    void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(THREE_GAMES_WON);
        assertThat(team.getGamesWon())
            .as("number of games won")
            .isEqualTo(THREE_GAMES_WON);
       }
}
 */