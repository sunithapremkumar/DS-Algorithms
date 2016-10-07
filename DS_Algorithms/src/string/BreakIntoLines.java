package string;

/* * Q1 : Easy: Given a long string as input, break it into as many lines as possible such that each line is longer than the previous line. 
 * You can only break it at word boundaries (break at space). Print the number lines you are breaking it into, and how. Do it in constant space. 
 * 
 *   Q2 :  Easy-Moderate: Given a long string as input, break it into as many lines as possible such that each line is shorter than the previous line. You can use extra space.
 *   Q3:  Moderate-Hard: Do Q2. in constant space.
 * */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BreakIntoLines
{
	
	public void printLines(String s){
		
		if(s == null) {
			System.out.println("0");
			return;
		}
		StringBuilder previous = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(s, " ");
		int count = 0;
		while(st.hasMoreTokens()){
		
		   StringBuilder current = new StringBuilder(st.nextToken());
		   while((current.length() <= previous.length()) && (st.hasMoreTokens())){
		       current.append(" "); current.append(st.nextToken());
		   }
		   if(current.length() > previous.length()){
		     System.out.print("\n"+current.toString());
		     count++;
		   }
		   else
			   System.out.print(" "+ current.toString());
		   previous = current;
		}
		System.out.println("\n"+count);
		
	}
	
	
	 public void printLinesReverse(String s){
			if(s == null) {
				System.out.println("0");
				return;
			}
			Stack<String> stack = new Stack<String>();
			
			StringTokenizer st = new StringTokenizer(s, " ");
			int count = 0;
			while(st.hasMoreTokens()){
			
			   StringBuilder current = new StringBuilder(st.nextToken());
			   String previous = (stack.isEmpty())? "" :stack.peek();
			   while((current.length() <= previous.length()) && (st.hasMoreTokens())){
			       current.append(" "); current.append(st.nextToken());
			   }
			   if(current.length() > previous.length()){
			     stack.push(current.toString());
			     count++;
			   }
			   else{
			       stack.push(stack.pop() + current.toString());
			   }
			}
			while(!stack.isEmpty())
				System.out.print("\n"+stack.pop());
			System.out.println("\n"+count);
		 
			
		 
	 }
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way--in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.";
	    //String s = "f fa  fa ba";
		//String s ="Once upon a terribly dreadful time, there was a small cat-licking bird that lived on a lane by my house whose name was Charles just like every other soul, male or female, that lived on my smelly, stinky, orange, old, rotten, messy, busted cul-de-sac between Belmont and Rose which are both real long Streets Like North street or some carp that reminds me of a celebrity like Paris Hilton or some blonde loser that doesn't even know the capital of her own country, which is the United States of America aka: The U.S.A which is a pristine nation of beauty, opposing to a country as the country of Somalia and Belgium, a part of Europe, which doesn't even have a government, it's just in a complete state of anarchy just like my mind and soul which are both filled with outrageous nonsense that I'm typing down right now into some fat long sentence that probably makes no sense but who cares I'm trying to set some sort of weird record here like most ducks snorted or some weird thing like that and if I do set some sort of record I will be in the Guinness Book of World Records (though anti-American and pro European, a place of pitty and despair as Somalia is) which was always my dream because that book has a whole bunch a cool and weird stuff in it and I would Become famous and add to the weirdness of the book like some of their records which reminds me of the Rob & Big where Rob sets all of those skateboarding Records And Big Black eats bananas and donuts and three weeks later they both get plaques saying the record they set and I want to get one of those so that's why I'm writing all of this stuff down without ever using a period or some other sentence ending mark like an exclamation point or a question mark or any other symbol that could possibly end my streak of words that is really long now and would take me a while to count just like counting sheep which is supposed to put you to sleep but it really keeps you awake because you want to keep counting and counting until you don't know what comes after trillions, but that would take Years or something because it would take a while just to count a trillion seconds or minutes would be even worse just like how ducks are worse that geese because they are more aggressive around their young unlike great white sharks which are often eaten by their mothers when they are born and the ones who do make it out alive have no mother to teach them how to hunt or whatever because none of that matters because us human beings have mothers unless they die or run off with some CEO of a big company or someone else who makes a lot of money and then they leave you with your dad and you are jealous of your friends if you have any because they have moms and you don't because your mom was some greedy pig who wanted money but ended up only getting the money part and she bought drugs because she was depressed and ended up killing herself from an overdose and you wouldn't even know about it until you become some rich person and check the files somewhere and learn that she died of a overdose and you eyes get all teary and then you start crying because you know that you wouldn't be alive without that woman you called mom and I just found out right now that the longest sentence is like 10,000 words so I have a ways to go and you have to go with me so let's go to 6th gear and throw out some words like Emphysema which I had to do a report on in 4th grade because we had a ton of projects and this was the disease one and we chose diseases out of a hat and I came out with Emphysema which is a form of lung cancer which is 98% caused by smoking which reminds me of the way my dad describes smoking: \"you get plant leaves, wrap them in paper, light it on fire and suck on it\" which is normally a sentence but not today because I'm setting out on the quest for a long sentence that I'm typing up which reminds me of a story my grandpa told me about himself when he was \"your age\" about how they covered the letters on the type writers and they had to type so that they could memorize where the letters are on a type writer and my grandpa says he will never regret taking that class because it helped him out a lot when it came to typing and now a days he is not bad a typing at all because He is almost as fast as me because I am a pretty fast typer and writing this article isn't taking very long and expect being pretty far pretty soon at the pace I'm going right now so there are going to be some serious records getting busted when I'm finally finished writing this article on this dumb website which will probably end up huffing this article even though it is fun-packed and joyful and keeps the reader reading when they use that excuse to mom saying \"just one more sentence\" but that sentence is 10,000 words long and still continuing to go at a reasonable pace and it is going to shatter most of those long sentence records just like how the chargers are going to shatter the most consecutive years without a super bowl win record and I doubt that they will win one in the near future but they patriots are going to win some serious super bowls because they are the best team ever even better than the cowboys or 49ers and no one cares a bout them so go patriots and boo chargers even though I live in San Diego and Like the Padres I hate the Chargers because they are bad and the padres are bad too but I don't care because they are my favorite team and the dodgers are my least favorite along with the Yankees because the Yankees get a lot of money to spend and the padres and marlins get almost nothing and then the Yankees buy a-rod for a lot and the Rays get almost no money but are still fighting for first place this season without expensive players like Derek jeter or a-rod or johnny damon or whoever because they are an all around better team that can beat the Yankees even though the Yankees can beat the royals a lot who really suck because they suck more that the padres do and so do the mariners and Rockies even thought the Rockies went to the world series last year they lost and haven't stopped losing for a while now, either and they are last place in the nl west and that is where the padres used to be but they started hitting homeruns and winning games and are dong pretty good right now despite having little offense except for Adrian Gonzalez who is leading the NL in RBI's even though he is on the team who scores the least runs in the league but they are not last in homeruns though they are like 5 away or something but I�m not sure so screw that and let's talk about something fun like water or food or dirt or something but I think food is the best because their is a lot of things to talk about with food like you r favorite food which mine happens to be some spicy burrito form Chipotle mexican grill and it is very good just like this macaroni my mom made one time that had bread crumbs on top and it was very good like all of the food they serve on top chef which I wish I could be a judge for because they have a lot of good food on that show and it makes my mouth water whenever I watch it and that is why I watch it because the food is totally awesome and sometimes I hate the people but they end up getting eliminated like the Dance crews in France's Best Dance Crew which is a great show and you should watch it because people do good dancing like the JFrabbawockeez because they won the first season and they are very good just like supreme soul and So real crew and phresh select and super cr3w and I�m only at 1500 words right now so I have to write some serious stuff like a life biography about myself and anything I�ve ever done which includes going to big bear to ski, fishing, breathing, swimming, going, farting, eating, sleeping and a whole lot more stuff which reminds me of 4th grade again when my teacher was debating with the class whether \"a lot\" was one or two words and all of the kids including myself said one while the teacher said two and he was right and we were wrong but no one cared because we all had fun arguing about and I have fun arguing with my friends about football and not baseball because in baseball we all like the same team but in football I like the patriots and my friends like the chargers and the 49ers and the eagles and the saints but my team always woops their team's butt and they say that the patriots \"cheat\" and that's how they won even though the patriots just pwned their team and they suck and my team is good but we all agree when it comes to baseball because we all like the padres and we never really argue over anything in baseball which is my favorite sport and I play it and I am good a it and I want it to be my profession but I doubt that that will happen so my backup plan is being a cop because you get all of the benefits and you get paid after you retire which is good news and I would also like to be some government dude or something like that because they get the benefits too so it would be cool to work for the government which reminds me that my principal worked at the white house and taught the president email because he was the computer guy or something like that so h knows a whole bunch of computer crap like my dad and he is fat too so everyone makes fun of him and I think he huffs kittens too but I am not sure and about that and what the hell is up with all the n00b and kitten huffing on this stupid website like all of the things like \"the writer may have been huffing kittens\" and stuff like that it really annoys the hell out of me just like other things such as when people clip their finger nails it makes that weird noise that get me all crazy and I hate it just like how me friend hates the sound of chalk on a chalkboard which I find soothing and relaxing but he gets really annoyed and psyched out and he is also very pale-skinned and so is the rest of his family so it must have been some genetic thing like twins and clones and whole bunch of other confusing science crap that I learned a long time ago in 7th grade or something which was when we watched movies in class like UHF which has weird al in it and it is very funny because weird al has to save a TV station with a whole bunch of weird shows like wheel of fish and rauls wild kingdom with a whole bunch of cool animals like flamingos and turtles and stuff like that but who cares lets get to the meaty part of this article which is the part where I write the longest word known to man which is Methionylthreonylthreonyl...isoleucine which is cut out because it has 189,819 words so wikipedia had to cut out the middle part and the longest word is the name of a protein which is the largest known to man to so big names go to big things is apparently the moral of this story ladies and gentleman the road doesn't stop here and I have to continue no matter what you say or think so I should just write some story now that has no periods so lets start with a guy named Carl who liked fish and women and he went to Clara�s house and they had a good food but that isn't enough of a story to set the record so I think I�ll just stick to writing random crap which really makes no sense at all and here is some random picture";
		BreakIntoLines o = new BreakIntoLines();
		o.printLines(s);
		o.printLinesReverse(s);
	}
}
