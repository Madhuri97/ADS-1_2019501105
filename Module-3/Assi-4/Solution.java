class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return "";
    }
}