/**
 * @author Madhuri
 */
class Solution {

	public Team[] sort(Team[] teams) {
		// your code goes here
		//selection sort 
		int n = teams.length;
		for(int i = 0; i < n - 1; i++){
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if(teams[j].compareTo(teams[min]) == 1) {
					min = j;
				}
			}
			Team temp = teams[i];
			teams[i] = teams[min];
			teams[min] = temp;
			}
		return teams;
	}
}

class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	public String toString() {
		//retrun all the attributes as a string but appending with ", "
		return "";
	}
	public int compareTo(Team that) {
		//primary conditions for number of wins
        if(this.noOfWins > that.noOfWins) {  
            return 1;
        }
        else if(this.noOfWins < that.noOfWins) {	
            return -1;
		}
		//primary conditions for losses
        else {
            if(this.noOfLosses > that.noOfLosses) { 	 
                return -1;
            }
            else if(this.noOfLosses < that.noOfLosses) {
                return 1;
			}
			//primary conditions for draw matches
            else{
            if(this.noOfDraws > that.noOfDraws) {
                return 1;
            }
            else if(this.noOfDraws < that.noOfDraws) {
                return -1;
            }
          }
        }
        return 0;
    }
}
