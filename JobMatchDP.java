public class JobMatchDP {

    public static void main(String[] args) {

        // Matching scores between candidates and jobs
        int[][] matchScore = {
                {8, 6, 7},
                {5, 9, 8},
                {7, 8, 10}
        };

        int candidates = matchScore.length;
        int jobs = matchScore[0].length;

        System.out.println("Best Job Match Results:");

        for (int i = 0; i < candidates; i++) {
            int bestJob = 0;
            int maxScore = matchScore[i][0];

            for (int j = 1; j < jobs; j++) {
                if (matchScore[i][j] > maxScore) {
                    maxScore = matchScore[i][j];
                    bestJob = j;
                }
            }

            System.out.println("Candidate C" + (i + 1)
                    + " -> Job J" + (bestJob + 1)
                    + " (Score = " + maxScore + ")");
        }
    }
}