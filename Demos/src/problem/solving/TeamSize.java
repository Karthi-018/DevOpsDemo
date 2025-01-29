package problem.solving;

public class TeamSize {
	
	public static int countTeams(int t1, int t2, int p) {
		int miniTeams = Integer.MAX_VALUE;
		
		 for (int i = 0; i * t1 <= p; i++) {
	            int n = p - i * t1;
	            if (n % t2 == 0) {
	                int j = n / t2;
	                miniTeams = Math.min(miniTeams, i + j); 
	            }
	        }

		
		return miniTeams == Integer.MAX_VALUE ? -1 : miniTeams;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(countTeams(3,4,5));
	}

}
