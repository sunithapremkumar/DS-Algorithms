package interviewcake;

import java.util.*;
/**
 * Write a function mergeRanges() that takes a list of meeting time ranges and returns a list of condensed ranges.

For example, given:

  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

your function would return:

  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 * @author suni
 *
 */
public class MergeMeetings {
	
	
	/**
	 * ALGO: 1. Sort the meetings as per start time
	 *       2. If the start of current meeting is earlier than the end of last meeting, then take the max of thse 2 meetings as end
	 *       3. Else add the current meeting to merged list.
	 */
	       
	public List<Meeting> mergeMeetings(List<Meeting> meetings){
		
		  // sort by start time
		  Collections.sort(meetings, new Comparator<Meeting>(){
				  
				  public int compare(Meeting m1, Meeting m2){
			         return m1.start - m2.start; 
		  		  }
		      });
		
		  //merge
		 List<Meeting> mergedMeetings = new ArrayList<>();
		 mergedMeetings.add(meetings.get(0));
	
		 for(Meeting cur: meetings){
			 Meeting lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
		     if(cur.start <= lastMeeting.end){ // there is overlap
		    	 lastMeeting.end = Math.max(cur.end, lastMeeting.end);
		     }
		     else  // no overlap so add this meeting as such
		    	 mergedMeetings.add(cur);
		  }
		 
		 return mergedMeetings;
	}
	
	
	
	
	
	private class Meeting{
		
		int start;
		int end;
		
		public Meeting(int st, int en)
		{
			start = st;
			end = en;
		}
		
		
	}

}
