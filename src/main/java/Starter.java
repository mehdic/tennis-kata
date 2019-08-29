import com.nexeo.katas.tennis.entities.Match;
import com.nexeo.katas.tennis.entities.Player;
import com.nexeo.katas.tennis.utils.Utils;

public class Starter
{
    public static void main(String[] args) {

            Player nadal=new Player("Player1","Nadal");
            Player federer=new Player("Player2","Federer");
            Match match=new Match(nadal,federer);
            while(!match.isFinished())
            {
                Utils.choosePlayerRandomly(nadal,federer).scorePoint(match);
            }
            Utils.printScoreToConsole(match.getMatchResult());

    }
}
