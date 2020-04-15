import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> musics;
    private ArrayList<Music> favorites;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        musics = new ArrayList<>();
        favorites=new ArrayList<>();
        player = new MusicPlayer();

    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addTrack(Music filename)
    {
        musics.add(filename);
    }

    /**
     * add a track to favorites
     * @param trackName track to be added
     */
    public void addFavorites(Music trackName){
        if(searchTrack(trackName.getName())==true)
            favorites.add(trackName);
        else
            System.out.println("Not found!!");

    }

    /**
     * remove a track to favorites
     * @param trackName track to be removed
     */
    public void removeFavorites(Music trackName){
        if(favorites.contains(trackName)==true)
            favorites.remove(trackName);
        else
            System.out.println("Not found!!");
    }

    /**
     * print favorites
     */
    public void listFavorites()
    {
        for(Music i: favorites)
            System.out.println(i.getName()+" ("+i.getArtist()+") "+" "+i.getReleasedDate());
    }

    public void listFavoriteTrack(int index)
    {
        System.out.println(favorites.get(index));
    }


    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return musics.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listTrack(int index)
    {
        System.out.println(musics.get(index));
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllTracks(String objectName)
    {
        System.out.println(objectName);
        for(Music i: musics) {
            System.out.print(i.getName()+" ("+i.getArtist()+") "+" "+i.getReleasedDate());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeTrack(int index)
    {
        if(validIndex(index))
            musics.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index))
            player.startPlaying(musics.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index >= 0 && index < musics.size())
            return true;
        else{
            System.out.println("Invalid index!");
            return false;
        }
    }

    public boolean searchTrack(String trackName ) {
        for (Music i : musics) {
            if (i.getName().equalsIgnoreCase(trackName))
                return true;

        }
        return false;
    }
}