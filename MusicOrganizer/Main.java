import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        Music anotherBrickInTheWall = new Music("Another brick in the wall","Pink Floyd","1979");
        Music earthSong= new Music("Earth song","Micheal Jackson","1982");
        pop.addTrack(anotherBrickInTheWall);
        pop.addTrack(earthSong);

        Music inASilentWay=new Music("In a silent Way","Miles Davis","1969");
        jazz.addTrack(inASilentWay);

        Music someBodyToLove = new Music("Somebody to love","Queen","1976");
        Music inTheEnd = new Music("In the end","Linkin Park","2002");
        Music nothingElseMatter= new Music("Nothing else matters","Metallica","1991");
        rock.addTrack(someBodyToLove);
        rock.addTrack(inTheEnd);
        rock.addTrack(nothingElseMatter);

        Music loveStory=new Music("Love Story","Teylor Swift","2008");
        Music One = new Music("One","Johnny Cash","2000");
        country.addTrack(loveStory);
        country.addTrack(One);

        pop.addFavorites(anotherBrickInTheWall);
        rock.addFavorites(inTheEnd);
        rock.addFavorites(someBodyToLove);
        

        pop.listAllTracks("Pop");
        jazz.listAllTracks("Jazz");
        rock.listAllTracks("Rock");
        country.listAllTracks("Country");

        System.out.println("\nFavorites:");
        pop.listFavorites();
        jazz.listFavorites();
        rock.listFavorites();
        country.listFavorites();


    }
}
