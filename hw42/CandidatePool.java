/*=====================================

  class CandidatePool -- 

  pool
      ArrayList of Candidate objects

  getCandidatesForPosition( String pos )
      Returns ArrayList containing Candidates in pool applying for
      given pos.

  getBestCandidate( String pos )
      Return Candidate of given pos with highest score;
      If no candidates for given position, return null.

  removeCandidatesForPosition( String pos )
      Removes Candidates from pool with position pos, returns number
      of candidates removed.

  =====================================*/

import java.io.*; 
import java.util.*;


public class CandidatePool {
    ArrayList<Candidate> pool;
    
    public CandidatePool() {
	pool = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c ) {
	pool.add(c);
    }

    public String toString() {
	return pool.toString();
    }    

    public ArrayList<Candidate> getCandidatesForPosition( String pos ) {
	ArrayList<Candidate> subPool = new ArrayList<Candidate>();

	for (Candidate cand : pool)
	    if (cand.getPosition().equals(pos))
		subPool.add(cand);

	return subPool;
    }


    public Candidate getBestCandidate( String pos ) { 
	ArrayList<Candidate> subPool = getCandidatesForPosition(pos);
	Candidate bestCandidate = (Candidate) null;
	double bestScore = NEGATIVE_INFINITY;

	for (Candidate cand : subPool) {
	    double score = cand.getInterviewScore();

	    if (score.compareTo(bestScore) > 0) {
		bestScore = score;
		bestCandidate = cand;
	    }
	}

	return bestCandidate;
    }


    public int removeCandidatesForPosition( String pos ) {
	ArrayList<Candidate> subPool = getCandidatesForPosition();
	pool.removeAll(subPool);
	return subPool.size();
    }


}//end class CandidatePool
