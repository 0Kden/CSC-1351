
public class Movie implements Comparable<Movie> {
	private String movieTitle;
	private int releaseYear;
	private String rating;
	private int movieReview;
	
	
	public Movie (String Title, int Year, String Rating, int Review) {	//constructor that sets the values of movieTitle, releaseYear, rating, and movieReview
		movieTitle = Title;
		releaseYear = Year;
		rating = Rating;
		movieReview = Review;
	}
			
	public String getTitle() {	//returns the value of movieTitle
		return movieTitle;
	}
			
	public int getYear() {	//returns the value of releaseYear
		return releaseYear;
	}
				
	public String getRating() {	//returns the value of rating
		return rating;
	}
			
	public int getReview() {	//returns the value of movieReview
		return movieReview;
	}
			
	public int compareTo(Comparable oList) {
		
		if(movieTitle.compareTo(((Movie) oList).getTitle())>0) {
			return 1;
		}
		else if(movieTitle.compareTo(((Movie) oList).getTitle())<0) {
			return -1;
		}
		else {
			if(releaseYear<((Movie) oList).getYear())
				return-1;
			else if(releaseYear == ((Movie) oList).getYear())
				return 0;
			else
				return 1;
			}
		
	}
			
	public String toString() {
		return String.format("Title: " + movieTitle + " Year: " + releaseYear + " Rating: " + rating + " Review: " + movieReview) + ";";
		
	}
			//returns the following string: “Title: “ + movieTitle + “, Year : “ + releaseYear + “, Rating: “ + rating + “, Review: “ + movieReview + “;” 
}
