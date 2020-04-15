/**
 * A class to keep musics info
 * @author Alireza Ghafari 9831115
 * @version 0.0
 */
public class Music
{
    private String name;
    private String artist;
    private String releasedDate;

    public Music(String name, String artist, String releasedDate){
        this.artist=artist;
        this.name=name;
        this.releasedDate=releasedDate;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getReleasedDate() {
        return releasedDate;
    }


    @Override
    public String toString() {
        return "Artist: " + artist +"\nYear: " + releasedDate;
    }
}
